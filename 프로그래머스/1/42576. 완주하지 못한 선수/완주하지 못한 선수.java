import java.util.HashMap;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
    
        // 내부 버킷의 재할당이 일어나지 않도록 초기 capacity 값 설정
        // 초기 capacity = 100,000 / load factor = 100,000 / 0.75 ≈ 133,334
        HashMap<String, Integer> hm = new HashMap<>(133_334);
        
        for (String name : completion) {
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (hm.getOrDefault(name, 0) == 0) {  // 중복도가 0 인 경우: 존재하지 않음
                return name;
            } else {
                // 키가 존재함이 보장됨
                hm.compute(name, (k, v) -> v - 1);
            }
        }
        
        // 도달하지 않는 반환 문
        return "";
    }
}