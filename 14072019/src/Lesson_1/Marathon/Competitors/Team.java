package Lesson_1.Marathon.Competitors;


public class Team implements Competitor {
    private String teamName;
    private Competitor[] competitors;

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public void showResults() { //выводим результат
        this.info();
        if (this.isOnDistance()) System.out.println(teamName + " справилась с полосой препятствий");
        else System.out.println(teamName + " не справилась с полосой препятствий");
    }

    @Override
    public void run(int dist) {
        for (Competitor competitor:this.competitors) {
            competitor.run(dist);
        }
    }

    @Override
    public void swim(int dist) {
        for (Competitor competitor:this.competitors) {
            competitor.swim(dist);
        }

    }

    @Override
    public void jump(int height) {
        for (Competitor competitor:this.competitors){
            competitor.jump(height);
        }

    }

    @Override
    public boolean isOnDistance() {
        int teamScore = 0;
        for (Competitor competitor:this.competitors) {
            if (competitor.isOnDistance()) teamScore++;
        }
        return teamScore == this.competitors.length;
    }

    @Override
    public void info() {
        for (Competitor competitor:this.competitors) {
            competitor.info();
        }

    }
}
