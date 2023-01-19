package calendar;

import java.util.*;

public class calendar {

    int leapYear(int year) {
        int day = 0;

        if(((year % 4 == 0) && (!(year % 100 == 0)) || (year % 400 == 0))) {
            day = 29;
        } else {
            day = 28;
        }

        return day;
    }

    public static void main(String[] args) {
        Exam1 leap = new Exam1();
        Scanner sc = new Scanner(System.in);
        String[] week = {"월", "화", "수", "목", "금", "토", "일"};
        int year, month, day, m, total = 0;
        String result;

        System.out.println("년 월 일을 차례로 입력해주세요.: ");
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        sc.close();

        // year
        for(int i = 1; i < year; i++) {
            total += leap.leapYear(i);
        }
        total += (year - 1) * 337;

        // month
        for(int i = 1; i < month; i++) {
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                total += 31;
            } else if(i == 4 || i == 6 || i == 9 || i == 11) {
                total += 30;
            } else {
                total += leap.leapYear(year);
            }
        }

        // day
        total += day - 1;

        result = week[total % 7];

        System.out.printf("입력하신 %d년 %d월 %d일은 %s요일 입니다.", year, month, day, result);
    }

}
