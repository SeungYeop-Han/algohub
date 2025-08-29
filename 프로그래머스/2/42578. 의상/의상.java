import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] cloth : clothes) {
            hm.compute(cloth[1], (k, v) -> {
                if (v == null) {
                    return 1;
                }
                
                return v + 1;
            });
        }
        
        int ans = 1;
        for (int multiplicity : hm.values()) {
            ans *= (multiplicity + 1);
        }
        return ans - 1;
    }
}