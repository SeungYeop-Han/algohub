import java.util.HashMap;

class Solution {
    
    public boolean solution(String[] phoneBook) {
        
        HashMap<String, Boolean> hm = new HashMap<>();
        
        for (String phoneNum : phoneBook) {
            hm.put(phoneNum, true);
        }
        
        for (String phoneNum : phoneBook) {
            // "phoneNum" 에 대해 "p", "ph", ... "phoneNu"
            for (int i = 1; i < phoneNum.length(); i++) {
                if(hm.containsKey(phoneNum.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}