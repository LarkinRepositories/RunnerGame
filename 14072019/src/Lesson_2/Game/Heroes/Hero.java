package Lesson_2.Game.Heroes;

public abstract class Hero implements Damagable, Healable {
    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;


    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
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

    void info() {

        System.out.println(name + " " + (health < 0 ? "Р“РµСЂРѕР№ РјРµСЂС‚РІС‹Р№" : health) + " " + damage);
    }
}
