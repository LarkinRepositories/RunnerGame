package Lesson_2.Game;

public class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        int round = 3;

        Hero[] team1 = new Hero[]{new Warrior(250, "РўРёРіСЂРёР»", 50, 0)
                , new Assasin(150, "РђРєР°Р»Рё", 70, 0)
                , new Doctor(120, "Р–Р°РЅРЅР°", 0, 60)};


        Hero[] team2 = new Hero[]{new Warrior(290, "РњРёРЅРѕС‚Р°РІСЂ", 60, 0)
                , new Assasin(160, "Р”Р¶РёРЅРєСЃ", 90, 0)
                , new Doctor(110, "Р—РѕРё", 0, 80)};



        for (int j = 0; j < round; j++) {
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else {
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
}
