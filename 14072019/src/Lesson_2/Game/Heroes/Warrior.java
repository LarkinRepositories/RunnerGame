package Lesson_2.Game.Heroes;

public class Warrior extends Hero implements DealsDamage {
    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Р“РµСЂРѕР№ РїРѕРіРёР± Рё Р±РёС‚СЊ РЅРµ РјРѕР¶РµС‚!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " РЅР°РЅРµСЃ СѓСЂРѕРЅ " + hero.name);
        }
    }

}
