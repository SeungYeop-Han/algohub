import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] cloth : clothes) {
            hm.compute(cloth[1], (k, v) -> {
                if (v == null) {
                    // 해당 카테고리의 옷을 입지 않는 경우 포함
                    return 2;
                }
                
                return v + 1;
            });
        }
        
        int ans = 1;
        for (int multiplicity : hm.values()) {
            ans *= multiplicity;
        }
        // 옷을 하나도 입지 않은 경우 제외
        return ans - 1;
    }
}