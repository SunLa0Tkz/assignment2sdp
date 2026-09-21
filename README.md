Theme: Game World Kit

Part A — Factory Method: spawning individual Enemy entities (Goblin, Skeleton, Slime).
Part B — Abstract Factory: generating a unified World family — Enemy + Terrain + Soundtrack — for Forest, Ice, and Desert biomes.

Repository structure

assignment2-design-patterns/
├── src/
│   ├── factorymethod/      (Part A)
│   │   ├── Enemy.java                 Product interface
│   │   ├── GoblinEnemy.java           ConcreteProduct
│   │   ├── SkeletonEnemy.java         ConcreteProduct
│   │   ├── SlimeEnemy.java            ConcreteProduct
│   │   ├── EnemySpawner.java          Creator (abstract)
│   │   ├── GoblinSpawner.java         ConcreteCreator
│   │   ├── SkeletonSpawner.java       ConcreteCreator
│   │   ├── SlimeSpawner.java          ConcreteCreator
│   │   └── FactoryMethodDemo.java     Client / Entry point
│   └── abstractfactory/    (Part B)
│       ├── Enemy.java / Terrain.java / Soundtrack.java     Abstract products
│       ├── WorldFactory.java                               AbstractFactory
│       ├── Forest*.java (Enemy/Terrain/Soundtrack/Factory)  ConcreteFactory + family
│       ├── Ice*.java    (Enemy/Terrain/Soundtrack/Factory)  ConcreteFactory + family
│       ├── Desert*.java (Enemy/Terrain/Soundtrack/Factory)  ConcreteFactory + family
│       ├── World.java                                       Client (composition)
│       └── AbstractFactoryDemo.java                          Entry point / family selection
└── README.md

Build & run

find src -name "*.java" > sources.txt
javac -d out @sources.txt

java -cp out factorymethod.FactoryMethodDemo
java -cp out abstractfactory.AbstractFactoryDemo