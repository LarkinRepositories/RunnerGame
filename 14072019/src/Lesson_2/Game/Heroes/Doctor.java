package Lesson_2.Game.Heroes;

public class Doctor extends Hero implements CanHeal {
    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    public void healing(Hero hero) {
        hero.addHealth(addHeal);
    }
}
