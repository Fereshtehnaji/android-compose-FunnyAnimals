// Copyright 2014 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'dart:math' as math;
import 'dart:ui' show lerpDouble, hashValues;

import 'package:flutter/foundation.dart';

import 'box.dart';
import 'layer.dart';
import 'layout_helper.dart';
import 'object.dart';

/// An immutable 2D, axis-aligned, floating-point rectangle whose coordinates
/// are given relative to another rectangle's edges, known as the container.
/// Since the dimensions of the rectangle are relative to those of the
/// container, this class has no width and height members. To determine the
/// width or height of the rectangle, convert it to a [Rect] using [toRect()]
/// (passing the container's own Rect), and then examine that object.
///
/// The fields [left], [right], [bottom], and [top] must not be null.
@immutable
class RelativeRect {
  /// Creates a RelativeRect with the given values.
  ///
  /// The arguments must not be null.
  const RelativeRect.fromLTRB(this.left, this.top, this.right, this.bottom)
    : assert(left != null && top != null && right != null && bottom != null);

  /// Creates a RelativeRect from a Rect and a Size. The Rect (first argument)
  /// and the RelativeRect (the output) are in the coordinate space of the
  /// rectangle described by the Size, with 0,0 being at the top left.
  factory RelativeRect.fromSize(Rect rect, Size container) {
    return RelativeRect.fromLTRB(rect.left, rect.top, container.width - rect.right, container.height - rect.bottom);
  }

  /// Creates a RelativeRect from two Rects. The second Rect provides the
  /// container, the first provides the rectangle, in the same coordinate space,
  /// that is to be converted to a RelativeRect. The output will be in the
  /// container's coordinate space.
  ///
  /// For example, if the top left of the rect is at 0,0, and the top left of
  /// the container is at 100,100, then the top left of the output will be at
  /// -100,-100.
  ///
  /// If the first rect is actually in the container's coordinate space, then
  /// use [RelativeRect.fromSize] and pass the container's size as the second
  /// argument instead.
  factory RelativeRect.fromRect(Rect rect, Rect container) {
    return RelativeRect.fromLTRB(
      rect.left - container.left,
      rect.top - container.top,
      container.right - rect.right,
      container.bottom - rect.bottom,
    );
  }

  /// A rect that covers the entire container.
  static const RelativeRect fill = RelativeRect.fromLTRB(0.0, 0.0, 0.0, 0.0);

  /// Distance from the left side of the container to the left side of this rectangle.
  ///
  /// May be 