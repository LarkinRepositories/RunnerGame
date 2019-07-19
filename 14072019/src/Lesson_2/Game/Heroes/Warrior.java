package Lesson_2.Game.Heroes;

public class Warrior extends Hero {
    private int damage;
    public Warrior(int health, String name, int damage) {
        super(health, name);
        this.damage = damage;
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if(hero.getHealth() <= 0) {
                System.out.println(this.getName()+" мертв!");
            } else {
                hero.causeDamage(damage);
                System.out.println(this.getName() + " наносит урон " + hero.getName());
            }
        }
    }

    @Override
    public void info() {
        System.out.println(this.getName() + " " + (this.getHealth() < 0 ? this.getName()+ " мертв!" : this.getHealth() +" "+damage));
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Воин не может лечить");
    }
}
