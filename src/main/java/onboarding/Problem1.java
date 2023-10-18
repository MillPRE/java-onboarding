package onboarding;
import java.util.List;

import static java.lang.Integer.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = MAX_VALUE;
        if(!checkPageException(pobi) || !checkPageException(crong)) return -1;
        return getWinner(getScore(pobi), getScore(crong));
    }

    /*
    * [ 페이지 번호 계산 시 가장 큰 수 구하는 함수 ]
    * 입력: [왼쪽 페이지 번호, 오른쪽 페이지 번호]
    * 1. 페이지 번호의 각 자리 숫자를 모두 더함
    * 2. 페이지 번호의 각 자리 솟자를 모두 곱함
    * 3. 가장 큰 숫자를 리턴
    * */
    public static int getScore(List<Integer> list) {
        int maxScore = -1;
        for(int page: list) {
            String pageString = Integer.toString(page); // 페이지 String 전환
            int sum = 0;
            int multi = 1;
            // 페이지 각 자리 숫자 더하기, 곱하기 연산 할 for문
            for(int i = 0; i < pageString.length() ; i++) {
                int value = parseInt(String.valueOf(pageString.charAt(i)));
                sum += value;
                multi *= value;
            }
            int temp_max = Math.max(sum, multi);
            maxScore = Math.max(temp_max, maxScore);
        }
        return maxScore;
    }

    public static int getWinner(int pobiScore, int crongScore) {
        if(pobiScore == crongScore) return 0;
        return pobiScore > crongScore ? 1 : 2;
    }

    /* 예외처리
    * 1. 왼쪽 페이지와 오른쪽 페이지의 차이가 1이 맞는가.
    * 2. 시작 면이나 마지막 면이 나오면 안된다.
    * 3. 왼쪽 페이지 홀수, 오른쪽 페이지 짝수가 맞는가
    * 4. 왼쪽 페이지가 1이거나 오른쪽 페이지가 400이면 안된다.
    * */

    public static boolean checkPageException(List<Integer> list) {
        // false return시 error
        return checkPageRange(list) && checkPageOddOrEven(list) && checkPageDiff(list);
    }

    public static boolean checkPageDiff(List<Integer> list) {
        // 왼쪽 + 1 != 오른쪽 이면 false;
        return list.get(0) + 1 == list.get(1);
    }

    public static boolean checkPageOddOrEven(List<Integer> list) {
        // 왼쪽 홀수 && 오른쪽 짝수 true return
        return list.get(0) % 2 != 0 && list.get(1) % 2 == 0;
    }

    public static boolean checkPageRange(List<Integer> list) {
        // 페이지 범위는 2~399까지만 나올 수 있다.
        return list.get(0) >= 2 && list.get(0) <= 399 && list.get(1) >= 2 && list.get(1) <= 399;
    }

}