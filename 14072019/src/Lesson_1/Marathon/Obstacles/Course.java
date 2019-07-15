package Lesson_1.Marathon.Obstacles;

import Lesson_1.Marathon.Competitors.Competitor;
import Lesson_1.Marathon.Obstacles.Obstacle;

import java.util.Arrays;

public class Course extends Obstacle {
    private Obstacle[] course;

    public Course(Obstacle...obstacles) {
        this.course = Arrays.copyOf(obstacles, obstacles.length);
    }

    @Override
    public void doIt(Competitor competitor) {
        for (Obstacle obstacle:this.course) {
            obstacle.doIt(competitor);
        }
    }
}
