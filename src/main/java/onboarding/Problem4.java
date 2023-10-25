package onboarding;

public class Problem4 {
    /*
    * word A -> Z
    * word Z -> A
    * ascii code A(65) -> Z(90): (90 - 본인) + 65
    * ascii code B(66) -> Y(89): (90 - 본안) + 65
    * ascii code Z(90) -> A(65): (90 - 본안) + 65
    * a(97) z(122)
    * */
    public static String solution(String word) {
        String answer = "";
        for(int i = 0 ; i < word.length() ; i++) {
            int c = (int) word.charAt(i);
            if(c >= 65 && c <= 90) {
                c = (90 - c) + 65;
                answer += (char) c;
            } else if(c >= 97 && c <= 122) {
                c = (122 - c) + 97;
                answer += (char) c;
            } else {
                answer += (char) c;
            }


        }

        return answer;
    }
}
