package Lesson_2.Game.Heroes;

import java.util.Random;

public class Assasin extends Hero implements DealsDamage {
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
            if (health < 0) {
                System.out.println("Р“РµСЂРѕР№ РїРѕРіРёР± Рё Р±РёС‚СЊ РЅРµ РјРѕР¶РµС‚!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " РЅР°РЅРµСЃ СѓСЂРѕРЅ " + hero.name);
        }
    }

    @Override
    void info() {
        System.out.println(name + " " + (health < 0 ? "Герой мертв" : health +" "+damage));
    }
}
