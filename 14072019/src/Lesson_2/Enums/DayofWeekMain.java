package Lesson_2.Enums;

public class DayofWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));

    }
    private static String getWorkingHours(DayOfWeek dayOfWeek) {
        switch(dayOfWeek) {
            case SUNDAY:
                return "Воскресение. Не рабочий день";
            case MONDAY:
                return "Понедельник. Осталось рабочих часов: 40";
            case TUESDAY:
                return "Вторник. Осталосб рабочих часов: 32";
            case WEDNESDAY:
                return "Среда. Осталось рабочих часов: 24";
            case THURSDAY:
                return "Четверг. Осталось рабочих часов: 16";
            case FRIDAY:
                return "Пятница. Осталось рабочих часов: 8";
            case SATURDAY:
                return "Суббота. Не рабочий день";
        }
        return "Передайте корректный день недели";
    }
}
