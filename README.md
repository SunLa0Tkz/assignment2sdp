# Assignment 2 — Game World Kit

Name: Rustem Gazymbekov
Group: SE-2535

Theme: game world (enemies + terrain).

## Structure

```
src/
  factorymethod/      Part A
  abstractfactory/     Part B
  Main.java
```

## Part A — Factory Method

Single product: `Enemy`. Three variants: `Goblin`, `Skeleton`, `Slime`.

`EnemySpawner` is the abstract Creator. It declares the factory method
`createEnemy()` and has a business method `spawn()` that works only through
the `Enemy` interface, without knowing which concrete enemy it got.

`GoblinSpawner`, `SkeletonSpawner`, `SlimeSpawner` each override
`createEnemy()` and return their own enemy.

`Main` never creates an enemy directly (`new Goblin()`, etc.) — only through
a spawner.

## Part B — Abstract Factory

Family of two products: `Enemy` and `Terrain` (separate interfaces from
Part A, living in a different package — the two parts are independent).

`WorldFactory` is the abstract factory interface, one create-method per
product in the family.

`ForestWorldFactory` and `IceWorldFactory` are the two concrete factories,
each returning a matching pair (forest + wolves, ice + golem).

`WorldBuilder` is the client. It receives a factory through its constructor
and only talks to `Enemy` / `Terrain` — it has no idea which concrete
classes are behind them.

The world is picked in exactly one place: one line inside `Main`.

## Build and run

```
javac -d out $(find src -name "*.java")
java -cp out Main
java -cp out Main ice
```

First command runs the forest world by default, second runs the ice world.

## Notes for the defense

- Factory Method relies on inheritance — subclasses of the Creator decide
  what gets created.
- Abstract Factory relies on composition — the client holds a reference to
  a factory instead of extending one.
- Adding a new enemy in Part A means a new ConcreteProduct and a new
  ConcreteCreator; nothing else changes (Open/Closed Principle).
- Adding a new kind of product to the Part B family (say, a Soundtrack)
  means changing the `WorldFactory` interface and every concrete factory.
  That's the actual weak spot of Abstract Factory: adding a new factory is
  cheap, adding a new product type across the whole family is not.