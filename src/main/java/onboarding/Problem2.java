package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean flag = true;
        while(flag) {
            if(cryptogram.length() < 2) {
                return cryptogram;
            }
            String decode = decodingCrypto(cryptogram);
            flag = compareDecoding(cryptogram, decode);
            cryptogram = decode;
        }
        return cryptogram;
    }

    /*
    * [ 중복 삭제 함수 ]
    * */
    public static String decodingCrypto(String cryptogram) {
        // JAVA String 객체는 한번 할당되면 변경이 불가능하다.
        // StringBuilder는 변경 가능한 문자열 객체를 만들어 준다.
        StringBuilder result = new StringBuilder();
        System.out.println(cryptogram);
        char prev = cryptogram.charAt(0);

        for(int i = 1; i < cryptogram.length() ; i++) {
            char curr = cryptogram.charAt(i);
            if(prev != curr) {
                if(prev != '\u0000') {
                    result.append(prev);
                }
                prev = curr;
            } else {
                // '\u0000' 공백 의미
                prev = '\u0000';
            }
        }

        if(prev != '\u0000') result.append(cryptogram.charAt(cryptogram.length()-1));

        return result.toString();
    }

    public static boolean compareDecoding(String before, String after) {
        return !before.equals(after);
    }
}
