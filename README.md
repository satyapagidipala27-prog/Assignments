# Design Patterns

Small Java examples of object-oriented design patterns. Each pattern lives in
its own folder and can be opened or compiled independently.

## Patterns

- [Bridge](Bridge/): separates media types from playback devices.
- [Composite](Composite/): treats files and folders through a shared interface.
- [Decorator](Decorator/): demonstrates the Decorator pattern.

Each folder contains its Java source files under `src/`.

## Run an example

From a pattern folder, compile and run its `Main` class. For example:

```sh
cd Bridge
javac -d out src/*.java
java -cp out Main
```
