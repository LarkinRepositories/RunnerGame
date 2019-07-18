package Lesson_2.Game.Heroes;

public abstract class Hero implements Damagable, Healable, CanHeal, DealsDamage {
    private int health;
    private String name;

    public Hero(int health, String name) {
        this.health = health;
        this.name = name;
    }
    @Override
    public void causeDamage(int damage) {
        if(this.health < 0) {
            System.out.println(this.getName()+" мертв!");
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
    public String getName() {
        return name;
    }

   public abstract void info();
}
