package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/*
* 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 리턴
*
* */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        for(List<String> data: forms) {
            String name = data.get(1);
            List<List<String>> temp = new ArrayList<>(List.copyOf(forms));
            temp.remove(data);
            for(int i = 0 ; i < name.length()-1 ; i ++) {
                String subName = name.substring(i, i+2);
                for(List<String> t: temp) {
                    if(t.get(1).contains(subName)) {
                        answer.add(t.get(0));
                    }
                }
            }
        }
        answer = new ArrayList<>(Set.copyOf(answer));
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
