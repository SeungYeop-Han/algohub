import java.util.Map;
import java.util.HashMap;

class Solution {

    int numFriends;

    public int solution(String[] friends, String[] gifts) {

        numFriends = friends.length;
        
        Map<String, Integer> nameToIdx = allocateIndexForName(friends, numFriends);
        int[][] giveCnts = recordWhoGivesWhoHowMany(gifts, nameToIdx);
        int[] presentIndexes = calculatePresentPoints(giveCnts);
        int[] totalTakens = calculateTotalTakeCounts(giveCnts, presentIndexes);
        
        return max(totalTakens);
    }

    private int max(int[] totalTakens) {
        int max = -1;
        for (int i = 0; i < numFriends; i++) {
            if (totalTakens[i] > max) {
                max = totalTakens[i];
            }
        }

        return max;
    }

    private int[] calculateTotalTakeCounts(int[][] giveCnts, int[] presentIndexes) {
        int[] totalTakens = new int[numFriends];
        for (int i = 0; i < numFriends; i++) {
            for (int j = i + 1; j < numFriends; j++) {
                if (i == j) continue;

                int giveCnt = giveCnts[i][j];
                int takeCnt = giveCnts[j][i];

                if (giveCnt > takeCnt) {
                    totalTakens[i]++;
                } else if (takeCnt > giveCnt) {
                    totalTakens[j]++;
                } else {
                    if (presentIndexes[i] > presentIndexes[j]) {
                        totalTakens[i]++;
                    } else if (presentIndexes[j] > presentIndexes[i]) {
                        totalTakens[j]++;
                    }
                }
            }
        }
        return totalTakens;
    }

    private int[] calculatePresentPoints(int[][] giveCnts) {
        int[] presentIndexes = new int[numFriends];
        for (int i = 0; i < numFriends; i++) {

            // sum give count
            int totalGiveCnt = 0;
            for (int j = 0; j < numFriends; j++) {
                if (i == j) continue;

                totalGiveCnt += giveCnts[i][j];
            }

            // sum take count
            int totalTakeCnt = 0;
            for (int j = 0; j < numFriends; j++) {
                if (i == j) continue;

                totalTakeCnt += giveCnts[j][i];
            }

            // record present index
            presentIndexes[i] = totalGiveCnt - totalTakeCnt;
        }
        return presentIndexes;
    }

    private int[][] recordWhoGivesWhoHowMany(String[] gifts, Map<String, Integer> nameToIdx) {
        int[][] giveCnts = new int[numFriends][numFriends];
        for (String whoGivesWho : gifts) {
            String giver = whoGivesWho.split(" ")[0];
            String taker = whoGivesWho.split(" ")[1];
            giveCnts[nameToIdx.get(giver)][nameToIdx.get(taker)]++;
        }
        return giveCnts;
    }

    private static Map<String, Integer> allocateIndexForName(String[] friends, int numFriends) {
        Map<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < numFriends; i++) {
            nameToIdx.put(friends[i], i);
        }
        return nameToIdx;
    }
}