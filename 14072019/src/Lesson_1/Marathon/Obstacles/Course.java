package Lesson_1.Marathon.Obstacles;

import Lesson_1.Marathon.Competitors.Competitor;



public class Course extends Obstacle {
    private Obstacle[] course;

    public Course(Obstacle...obstacles) {
        this.course = obstacles;
    }

    @Override
    public void doIt(Competitor competitor) {
        for (Obstacle obstacle:this.course) {
            obstacle.doIt(competitor);
        }
    }
}
