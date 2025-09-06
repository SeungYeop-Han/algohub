class Solution {
    public boolean solution(String s) {
        int top = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                top++;
            } else if(top == -1) {
                return false;
            } else {
                top--;
            }
        }
        
        if (top == -1) {
            return true;
        }
        
        return false;
    }
}