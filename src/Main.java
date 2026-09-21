import factorymethod.EnemySpawner;
import factorymethod.GoblinSpawner;
import factorymethod.SkeletonSpawner;
import factorymethod.SlimeSpawner;

import abstractfactory.WorldFactory;
import abstractfactory.ForestWorldFactory;
import abstractfactory.IceWorldFactory;
import abstractfactory.WorldBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method ===");
        List<EnemySpawner> spawners = List.of(
                new GoblinSpawner(),
                new SkeletonSpawner(),
                new SlimeSpawner()
        );
        for (EnemySpawner spawner : spawners) {
            System.out.println(spawner.spawn());
        }

        System.out.println();
        System.out.println("=== Part B: Abstract Factory ===");
        WorldFactory worldFactory = args.length > 0 && args[0].equals("ice")
                ? new IceWorldFactory()
                : new ForestWorldFactory();

        WorldBuilder worldBuilder = new WorldBuilder(worldFactory);
        System.out.println(worldBuilder.buildWorld());
    }
}
