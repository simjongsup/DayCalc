import java.util.Scanner;

public class DayCalc {
    public static void main(String[] args) {
        int year, day, month;
        Scanner scanner = new Scanner(System.in);
        //연,월,일을 입력받음
        do {
            System.out.println("연도를 입력하세요 : ");
            year = scanner.nextInt();
        } while (year < 1900);
        do {
            System.out.println("월을 입력하세요 : ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        do {
            System.out.println("일을 입력하세요 : ");
            day = scanner.nextInt();
        } while (day < 1 || day > 31);

        PrintDay(year, month, day);
    }
    public static void PrintDay(int year, int month, int day) {
        char dayOfWeek = DayofDate(year, month, day);
        System.out.println(year + "년 " + month + "월 " + day + "일은 " + dayOfWeek + "요일입니다." );

    }
    public static int MonthDays(int year, int month) {
        int dayOfMonth = 0;
        //윤년일 조건
        Boolean isLeapYear = ((year % 4 == 0) && (year % 100 !=0)) || year % 400 == 0;
        //31일 일 조건
        Boolean is31 = (month == 1) || (month == 3) || (month == 5) || (month == 7)
                || (month == 8) || (month == 10) || (month == 12);

        if (isLeapYear && month == 2) {
            dayOfMonth = 29;
        } else if (!isLeapYear && month == 2) {
            dayOfMonth = 28;
        } else if (is31) {
            dayOfMonth = 31;
        } else {
            dayOfMonth = 30;
        }
        return dayOfMonth;
    }
    public static char DayofDate(int year, int month, int day) {
        char dayOfWeek = 0;
        int totalDay = 0;
        for(int i = 1900; i <= year; i++) {
            //입력 년도 이전 까지는 12월 까지 다 더함
            if (i < year) {
                for(int j = 1; j <= 12; j++) {
                    totalDay += MonthDays(i, j);
                }
                //입력 년도는 입력 월 이전까지 더함
            } else {
                for(int j = 1; j < month; j++) {
                    totalDay += MonthDays(i, j);
                }
            }
        }
        //나머지 일 수를 구해진 전체 일수에 더함
        totalDay += day;
        //기준일인 1900년 1월 1일이 월요일이므로
        switch (totalDay % 7) {
            case 0:
                dayOfWeek = '일';
                break;
            case 1:
                dayOfWeek = '월';
                break;
            case 2:
                dayOfWeek = '화';
                break;
            case 3:
                dayOfWeek = '수';
                break;
            case 4:
                dayOfWeek = '목';
                break;
            case 5:
                dayOfWeek = '금';
                break;
            case 6:
                dayOfWeek = '토';
                break;
        }
        return dayOfWeek;
    }
}
