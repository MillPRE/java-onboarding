package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    * [0] : 오만 원권
    * [1] : 만 원권
    * [2] : 오천 원권
    * [3] : 천 원권
    * [4] : 오백원 동전
    * [5] : 백원 동전
    * [6] : 오십원 동전
    * [7] : 십원 동전
    * [8] : 일원 동전
    *
    * money는 1 이상 1,000,000 이하인 자연수이다.
    * */

    private static int getQuot(int money, int digit) {
        return money / digit;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] digitArr = {50000, 10000, 5000, 1000, 500, 100, 50 , 10, 1};
        int quot;

        for(int i = 0 ; i < digitArr.length ; i++) {
            quot = getQuot(money,digitArr[i]);
            answer.add(quot);
            money -= answer.get(i) * digitArr[i];
        }

        return answer;
    }
}
