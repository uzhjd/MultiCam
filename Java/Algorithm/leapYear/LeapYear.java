package leapYear;

/*
 * 크기가 6인 정수형 배열을 만든 후 1부터 45사이의 중복되지 않는 로또 번호를 생성하여 크기 순서대로 저장한 후 출력하는 코드를 작성하세요.
 *
 * [ 실행 예 ]
 * 로또 번호 : 3 14 21 39 33 42
 *
 * */

public class LeapYear {

    public static void main(String[] args) {
        int[] lotto = new int[6];
        int cnt = 0, rand;
        boolean overlap, max;

        while(cnt < 6) {
            rand = ((int)(Math.random() * 100)) % 45 + 1; // 랜덤 번호 생성
            System.out.println(rand);

            overlap = false; // 중복 flag 초기화
            max = true;

            // 앞의 번호 중 중복값 확인
            for(int i = 0; i < cnt; i++) {
                if(lotto[i] == rand) { // 중복
                    System.out.println("<< " + i + 1 + "번과 중복 >>");
                    overlap = true;
                }
            }

            // 로또 값 넣기
            if(!overlap) {
                // 오른차순 정렬
                for(int i = 0; i < cnt; i++) {
                    if(lotto[i] > rand) {
                        for(int j = cnt; j > i; j--) { // 뒤에서부터 채워나가기
                            lotto[j] = lotto[j - 1];
                        }
                        lotto[i] = rand;
                        max = false;
                        break;
                    }
                }
                if(max) { // lotto배열에 들어있는 수들보다 큰 수
                    lotto[cnt] = rand;
                }
                cnt++;
            }
        }

        System.out.println("\n[ lotto번호 ]");

        for(int i = 0; i < 6; i++) {
            System.out.printf("%d ", lotto[i]);
        }
    }
}
