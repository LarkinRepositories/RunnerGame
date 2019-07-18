package Lesson_2.Game;
import Lesson_2.Game.Heroes.*;

import java.util.Random;

public class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        int round = 3;

        Hero[] team1 = new Hero[]{new Warrior(9000, "Воин1", 500)
                , new Assasin(150, "Ассасин1", 70)
                , new Doctor(120, "Доктор1", 60)};


        Hero[] team2 = new Hero[]{new Warrior(250, "Воин2", 60)
                , new Assasin(160, "Ассасин2", 90)
                , new Doctor(110, "Доктор2", 80)};



        //for (int j = 0; j < aliveMembers(team1); j++) {
        while(!aliveMembers(team2)) {
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0 && team1[i].getHealth() > 0) {
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else if (team2[i].getHealth() > 0)  {
                    if(team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(2)]);
                    } else {
                        team2[i].hit(team1[i]);
                    }
                }
            }
        }

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }
    private static boolean aliveMembers (Hero[] heroes) {
        int aliveMember = heroes.length;
        for(Hero hero: heroes) {
            if (hero.getHealth() <= 0) aliveMember--;
        }
        return aliveMember == 0;
    }
}
