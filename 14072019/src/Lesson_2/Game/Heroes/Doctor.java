package Lesson_2.Game.Heroes;

public class Doctor extends Hero {
    private int addHeal;
    public Doctor(int heal, String name, int addHeal) {
        super(heal, name);
        this.addHeal = addHeal;
    }

    @Override
    public void healing(Hero hero) {
        if (hero.getHealth() <= 0) {
            System.out.println(this.getName()+": не могу лечить " + hero.getName()+"! "+hero.getName()+" мертв!");
        }
        else {
            hero.addHealth(addHeal);
            System.out.println(this.getName()+" вылечил "+hero.getName()+" "+addHeal+" здоровья");
        }
    }

    @Override
    public void info() {
        System.out.println(this.getName() + " " + (this.getHealth() < 0 ? this.getName()+  " мертв!" : this.getHealth() +" "+addHeal));
    }

    @Override
    public void hit(Hero hero) {
        System.out.println("Доктор не может наносить урон");
    }
}
