package onboarding;

public class Problem3 {
    /* 1부터  매개변수로 넘어오는 number까지 3, 6, 9가 들어간다면 개수만큼 손뼉을 쳐야한다.
    * 최종 몇 번 쳐야하는지를 return하는 문제 */
    public static int solution(int number) {
        int answer = 0;

        if(number < 3) return answer;

        for(int i = 1 ; i <= number ; i++) {
            StringBuilder current = new StringBuilder();
            current.append(i);
            answer += count369(current);
        }

        return answer;
    }
    private static int count369(StringBuilder stringNum) {
        int cnt = 0;
        for(int i = 0 ; i < stringNum.length() ; i++) {
            if(stringNum.substring(i, i+1).equals("3")) cnt++;
            if(stringNum.substring(i, i+1).equals("6")) cnt++;
            if(stringNum.substring(i, i+1).equals("9")) cnt++;
        }
        return cnt;
    }

}
