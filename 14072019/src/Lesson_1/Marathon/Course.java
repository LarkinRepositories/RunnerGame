package Lesson_1.Marathon;

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
