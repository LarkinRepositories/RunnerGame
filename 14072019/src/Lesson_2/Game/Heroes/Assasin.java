package Lesson_2.Game.Heroes;

import java.util.Random;

public class Assasin extends Hero {
    private int cricitalHit;
    private int damage;
    Random random = new Random();

    public Assasin(int health, String name, int damage) {
        super(health, name);
        this.damage = damage;
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if (this.getHealth() < 0) {
                System.out.println(this.getName()+" мертв!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.getName() + " атакует " + hero.getName());
        }
    }

    @Override
    public void info() {
        System.out.println(this.getName() + " " + (this.getHealth() < 0 ? this.getName() + " мертв!" : this.getHealth() +" "+damage));
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Ассасин не может лечить");
    }
}
