package Lesson_2.Game.Heroes;

public class Doctor extends Hero implements CanHeal {
    private int addHeal;
    public Doctor(int heal, String name, int addHeal) {
        super(heal, name);
        this.addHeal = addHeal;
    }

    @Override
    public void healing(Hero hero) {
        hero.addHealth(addHeal);
    }

    @Override
    void info() {
        System.out.println(name + " " + (health < 0 ? "Герой мертв" : health +" "+addHeal));
    }
}
