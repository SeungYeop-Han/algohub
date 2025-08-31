import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] playCounts) {
        
        HashMap<String, Integer> totalPlayCountByGenre = new HashMap<>();
        HashMap<String, int[]> top2SongIdByGenre = new HashMap<>();
        
        final int numOfSong = genres.length;
        for (int i = 0; i < numOfSong; i++) {
            
            int curId = i;
            String curGenre = genres[i];
            int curPlayCount = playCounts[i];
            
            // 장르 별 총 재생 횟수 집계
            totalPlayCountByGenre.compute(curGenre, (k, v) -> {
                if (v == null) {
                    return curPlayCount;
                }
                return v + curPlayCount;
            });
            
            // 장르 별 top2 집계
            top2SongIdByGenre.compute(curGenre, (gen, top2) -> {
                
                if (top2 == null) {
                    return new int[] {curId, -1};
                }
                
                if (top2[1] == -1) {                             // 2위가 존재하지 않으면
                    top2[1] = curId;
                } else if (curPlayCount > playCounts[top2[1]]) { // 존재하면 2위와 비교(동점자 기준 고려, 등호 없음)
                    top2[1] = curId;
                }
                
                // 1순위와 2순위 비교 후 스왑(동점자 기준 고려, 등호 없음)
                if (playCounts[top2[1]] > playCounts[top2[0]]) {
                    int temp = top2[0];
                    top2[0] = top2[1];
                    top2[1] = temp;
                }
                
                return top2;
            });
        }
        
        // 가장 인기있는 장르부터 선정하기 위한 우선순위 큐
        PriorityQueue<Map.Entry<String, Integer>> popularGenreFirst = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()
        );
        // 우선순위 큐에 장르 별 총 재생횟수 엔트리 삽입
        for (Map.Entry<String, Integer> e : totalPlayCountByGenre.entrySet()) {
            popularGenreFirst.add(e);
        }
        // 인기 장르 순으로 top 2 노래를 베스트 앨범에 수록
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        while (popularGenreFirst.peek() != null) {
            String genre = popularGenreFirst.poll().getKey();
            int[] top2 = top2SongIdByGenre.get(genre);
            bestAlbum.add(top2[0]);
            // 2위가 존재하는 경우에만 정답에 삽입
            if (top2[1] != -1) {
                bestAlbum.add(top2[1]);
            }
        }
        
        // ArrayList<Integer> 를 int[] 로 변환
        return bestAlbum.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}