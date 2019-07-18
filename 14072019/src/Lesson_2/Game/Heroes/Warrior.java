package Lesson_2.Game.Heroes;

public class Warrior extends Hero implements DealsDamage {
    private int damage;
    public Warrior(int health, String name, int damage) {
        super(health, name);
        this.damage = damage;
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
