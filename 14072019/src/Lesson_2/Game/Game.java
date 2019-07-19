package Lesson_2.Game;
import Lesson_2.Game.Heroes.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) {

        //Random randomStep = new Random();
        //Random randomHealing = new Random();
        //int round = 3;

        Hero[] team1 = new Hero[]{new Warrior(9000, "Воин1", 700)
                , new Assasin(150, "Ассасин1", 70)
                , new Doctor(120, "Доктор1", 60)};


        Hero[] team2 = new Hero[]{new Warrior(250, "Воин2", 60)
                , new Assasin(160, "Ассасин2", 90)
                , new Doctor(110, "Доктор2", 80)};


        teamFight(team1, team2);

    }
    private static void teamFight(Hero[] team1, Hero[] team2) {
        ArrayList<Hero> teamOne = new ArrayList<>(team1.length);
        ArrayList<Hero> teamTwo = new ArrayList<>(team2.length);
        teamOne.addAll(Arrays.asList(team1));
        teamTwo.addAll(Arrays.asList(team2));

       for (
               int x = (int) (Math.random() * teamOne.size()-1),
               y = (int) (Math.random() * teamTwo.size()-1);
               x != -1 && teamOne.size() > 0 || y != -1 && teamTwo.size() > 0;
               x = (int) (Math.random() * teamOne.size()-1), y = (int) (Math.random() * teamTwo.size()-1)
       ) {
                    if (teamOne.get(x) instanceof Doctor) { //TODO: добавить проверку на полное здоровье в healing();
                        teamOne.get(x).healing(teamOne.get((int) (Math.random() * teamOne.size()-1)));
                    } else {
                        teamOne.get(x).hit(teamTwo.get(y));
                        if (teamTwo.get(y).getHealth() <= 0) {
                            System.out.println(teamTwo.get(y).getName()+" мертв!");
                            teamTwo.remove(teamTwo.get(y));
                            teamTwo.trimToSize();
                            System.out.println("Теперь игроков в команде2: "+teamTwo.size());
                        }
                    }
                    if (teamTwo.get(y) instanceof Doctor) {
                        teamTwo.get(y).healing(teamTwo.get((int) (Math.random() * teamTwo.size()-1)));
                    } else {
                        teamTwo.get(y).hit(teamOne.get(x));
                        if (teamOne.get(x).getHealth() <= 0) {
                            System.out.println(teamOne.get(x).getName() + " мертв!");
                            teamOne.remove(teamOne.get(x));
                            teamOne.trimToSize();
                            System.out.println("Теперь игроков в команде1: "+teamOne.size());
                        }
                    }
       }
        System.out.println("---------------");

        for (Hero t1: teamOne) {
            t1.info();
        }

        for (Hero t2: teamTwo) {
            t2.info();
        }
    }
}
