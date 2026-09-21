package factorymethod;

public abstract class EnemySpawner {

    protected abstract Enemy createEnemy();

    public String spawn() {
        return "Spawned: " + createEnemy().describe();
    }
}
