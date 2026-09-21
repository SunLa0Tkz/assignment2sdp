package abstractfactory;

public class WorldBuilder {

    private final WorldFactory worldFactory;

    public WorldBuilder(WorldFactory worldFactory) {
        this.worldFactory = worldFactory;
    }

    public String buildWorld() {
        Enemy enemy = worldFactory.createEnemy();
        Terrain terrain = worldFactory.createTerrain();
        return "World: " + terrain.describe() + " | Enemy: " + enemy.describe();
    }
}
