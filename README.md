# Design Patterns

Small Java examples of object-oriented design patterns. Each pattern lives in
its own folder and can be opened or compiled independently.

## Patterns

- [Bridge](DesignPatterns/Bridge/): separates media types from playback devices.
- [Composite](DesignPatterns/Composite/): treats files and folders through a shared interface.
- [Decorator](DesignPatterns/Decorator/): demonstrates the Decorator pattern.
- [Facade](DesignPatterns/Facade/): provides a simple interface for home automation subsystems.
- [Flyweight](DesignPatterns/Flyweight/): shares character objects to reduce duplicate instances.
- [Proxy](DesignPatterns/proxy/): controls and logs access to file downloads.

Each pattern folder inside `DesignPatterns/` contains its Java source files under `src/`.

## Run an example

From a pattern folder, compile and run its `Main` class. For example:

```sh
cd DesignPatterns/Bridge
javac -d out src/*.java
java -cp out Main
```
