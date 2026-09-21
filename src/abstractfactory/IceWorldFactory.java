package abstractfactory;

public class IceWorldFactory implements WorldFactory {

    @Override
    public Enemy createEnemy() {
        return new IceEnemy();
    }

    @Override
    public Terrain createTerrain() {
        return new IceTerrain();
    }
}
