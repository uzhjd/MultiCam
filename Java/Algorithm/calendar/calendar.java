package calendar;

import java.util.*;

/*
 * [ 요일 계산 프로그램 ]
 *
 * 사용자에게 년, 월, 일을 입력받아 사용 예와 같이 입력받은 날짜의 요일을 반환하는 코드를 작성하세요.
 * 단, 외부 라이브러리는 사용하지 않고 모든 기능은 main() 메서드 안에서 직접 구현합니다.
 *
 * [ 실행 예 ]
 * 날짜를 입력하세요: 2023 1 18
 * 입력하신 2023년 1월 18일은 수요일 입니다.
 *
 * [ 힌트!!! ]
 * 1. 서기 1년 1월 1일은 월요일 입니다. => 서기 1년 2월 1일 | 서기 2년 1월 1일
 * 2. 윤년 계산과 각 월의 마지막 일자 계산을 활용합니다.
 *
 * */

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
