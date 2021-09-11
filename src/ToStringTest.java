
import java.util.*;


public class ToStringTest {

    public static void main(String[] args) {

        String[] research = {"xy","xy"};

        int n = 1;
        int k = 1;

        Set<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i< research.length;i++){
            for(int j=0; j<research[i].length();j++){
                if(set.add(research[i].charAt(j))){
                    list.add(research[i].charAt(j)); // 검색된 검색어 목록
                    map.put(research[i].charAt(j),0);
                }
            }
        }

        for(int i=0;i<=research.length-n;i++){
            for(int m = 0; m < list.size(); m++) {
                Character ch = list.get(m); // 조사 대상 문자
                int flag = 1;
                int sum = 0;

                for (int j = i; j < i + n; j++) { // j가 n일 동안 도는 루프
                    int cnt = search_cnt(ch,research[j]);
                    if(cnt < k){
                        flag = 0;
                        break;
                    }
                    sum += cnt;


                }

                if(sum < 2 * n * k){
                    flag = 0;
                }

                if(flag == 1){ // issue 검색어
                  map.put(ch,map.get(ch) + 1);
                }

            }
        }

        List<Character> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        boolean map_isEmpty = true;
        for(Character key : keySetList) {
            if(map.get(key) != 0){
                map_isEmpty = false;
                break;
            }
        }
        if(map_isEmpty == true) System.out.println("None");

        Character answer = keySetList.get(0);

        System.out.println(answer);





    }

    public static int search_cnt(Character ch,String str){
        int cnt = 0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ch){
                cnt++;
            }
        }

        return cnt;
    }


}
