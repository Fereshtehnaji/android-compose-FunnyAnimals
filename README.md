# 🦊 Jetpack Compose Funny Animals App with sound of Animals🎵

A simple Jetpack Compose application for kids.

Technologies use in application:
1. MVVM architecture
2. Jetpack Compose for ui
3. Navigation in Jetpack Compose
4. Ui update loop structure for have stateless and reusable composable
5. Animation on list item
6. Managing music throughout the app
7. Material design theme and priciple

## How does the ui update loop work?
- Event: click on item (change animation, play sound,  show a label)
- Update state: caller of animalScreen cand respond these events by updating state
- Display state: when the state is updated, animalScreen will be called again with new items and it can display them on screen

The caller (AnimalActivity) is reponsible for figuring out where and how to hold this state.
Animal screen  is completely decoupled from how state is managed.

