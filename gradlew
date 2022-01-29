// Copyright 2014 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'dart:ui' as ui;

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/painting.dart';
import 'package:vector_math/vector_math_64.dart';

import 'debug.dart';

/// Information collected for an annotation that is found in the layer tree.
///
/// See also:
///
///  * [Layer.findAnnotations], which create and use objects of this class.
@immutable
class AnnotationEntry<T> {
  /// Create an entry of found annotation by providing the object and related
  /// information.
  const AnnotationEntry({
    required this.annotation,
    required this.localPosition,
  }) : assert(localPosition != null);

  /// The annotation object that is found.
  final T annotation;

  /// The target location described by the local coordinate space of the
  /// annotation object.
  final Offset localPosition;

  @override
  String toString() {
    return '${objectRuntimeType(this, 'AnnotationEntry')}(annotation: $annotation, localPosition: $localPosition)';
  }
}

/// Information collected about a list of annotations that are found in the
/// layer tree.
///
/// See also:
///
///  * [AnnotationEntry], which are members of this class.
///  * [Layer.findAllAnnotations], and [Layer.findAnnotations], which create and
///    use an object of this class.
class AnnotationResult<T> {
  final List<AnnotationEntry<T>> _entries = <AnnotationEntry<T>>[];

  /// Add a new entry to the end of the result.
  ///
  /// Usually, entries should be added in order from most specific to least
  /// specific, typically during an upward walk of the tree.
  void add(AnnotationEntry<T> entry) => _entries.add(entry);

  /// An unmodifiable list of [AnnotationEntry] objects recorded.
  ///
  /// The first entry is the most specific, typically the one at the leaf of
  /// tree.
  Iterable<AnnotationEntry<T>> get entries => _entries;

  /// An unmodifiable list of annotations recorded.
  ///
  /// The first entry is the most specific, typically the one at the leaf of
  /// tree.
  ///
  /// It is similar to [entries] but does not contain other information.
  Iterable<T> get annotations sync* {
    for (final AnnotationEntry<T> entry in _entries)
      yield entry.annotation;
  }
}

/// A composited layer.
///
/// During painting, the render tree generates a tree of composited layers that
/// are uploaded into the engine and displayed by the compositor. This class is
/// the base class for all composited layers.
///
/// Most layers can have their properties mutated, and layers can be moved to
/// different parents. The scene must be explicitly recomposited after such
/// changes are made; the layer tree does not maintain its own dirty state.
///
/// To composite the tree, create a [SceneBuilder] object, pass it to the
/// root [Layer] object's [addToScene] method, and then call
/// [SceneBuilder.build] to obtain a [Scene]. A [Scene] can then be painted
/// using [dart:ui.FlutterView.render].
///
/// ## Memory
///
/// Layers retain resources between frames to speed up rendering. A layer will
/// retain these resources until all [LayerHandle]s referring to the layer have
/// nulled out their references.
///
/// Layers must not be used after disposal. If a RenderObject needs to maintain
/// a layer for later usage, it must create a handle to that layer. This is
/// handled automatically for the [RenderObject.layer] property, but additional
/// layers must use their own [LayerHandle].
///
/// {@tool snippet}
///
/// This [RenderObject] is a repaint boundary that pushes an additional
/// [ClipRectLayer].
///
/// ```dart
/// class ClippingRenderObject extends RenderBox {
///   final LayerHandle<ClipRectLayer> _clipRectLayer = LayerHandle<ClipRectLayer>();
///
///   @override
///   bool get isRepaintBoundary => true; // The [layer] property will be used.
///
///   @override
///   void paint(PaintingContext context, Offset offset) {
///     _clipRectLayer.layer = context.pushClipRect(
///       needsCompositing,
///       offset,
///       Offset.zero & size,
///       super.paint,
///       clipBehavior: Clip.hardEdge,
///       oldLayer: _clipRectLayer.layer,
///     );
///   }
///
///   @override
///   void dispose() {
///     _clipRectLayer.layer = null;
///     super.dispose();
///   }
/// }
/// ```
/// {@end-tool}
/// See also:
///
///  * [RenderView.compositeFrame], which implements this recomposition protocol
///    for painting [RenderObject] trees on the display.
abstract class Layer extends AbstractNode with DiagnosticableTreeMixin {
  /// If asserts are enabled, returns whether [dispose] has
  /// been called since the last time any retained resources were created.
  ///
  /// Throws an exception if asserts are disabled.
  bool get debugDisposed {
    late bool disposed;
    assert(() {
      disposed = _debugDisposed;
      return true;
    }());
    return disposed;
  }
  bool _debugDisposed = false;

  /// Set when this layer is appended to a [ContainerLayer], and
  /// unset when it is removed.
  ///
  /// This cannot be set from [attach] or [detach] which is called when an
  /// entire subtree is attached to or detached from an owner. Layers may be
  /// appended to or removed from a [ContainerLayer] regardless of whether they
  /// are attached or detached, and detaching a layer from an owner does not
  /// imply that it has been removed from its parent.
  final LayerHandle<Layer> _parentHandle = LayerHandle<Layer>();

  /// In