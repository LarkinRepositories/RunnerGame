package Lesson_2.Game.Heroes;

public abstract class Hero implements Damagable, Healable {
    protected int health;
    protected String name;



    public Hero(int health, String name) {
        this.health = health;
        this.name = name;
    }
    @Override
    public void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой мертв!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }
    @Override
    public void addHealth(int health) {
        this.health += health;
    }

    abstract void info();
}
