package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Cross(80), new Wall(2), new Water(50), new Cross(120));
        Team teamA = new Team("Команда А", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Human("Джек"));
        course.doIt(teamA);
        teamA.showResults();
    }
}