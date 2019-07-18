package Lesson_2.Game.Heroes;

import java.util.Random;

public class Assasin extends Hero implements DealsDamage {
    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
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
}
