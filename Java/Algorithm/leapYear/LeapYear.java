package leapYear;

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

            for(int i = 0; i < cnt; i++) {
                if(lotto[i] == rand) { // 중복
                    System.out.println("<< " + i + 1 + "번과 중복 >>");
                    overlap = true;
                }
            }

            if(!overlap) {
                for(int i = 0; i < cnt; i++) {
                    if(lotto[i] > rand) {
                        for(int j = cnt; j > i; j--) {
                            lotto[j] = lotto[j - 1];
                        }
                        lotto[i] = rand;
                        max = false;
                        break;
                    }
                }
                if(max) {
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
