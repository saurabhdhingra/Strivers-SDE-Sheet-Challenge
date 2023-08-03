import java.util.Arrays;

public class aggressiveCows {
    public static int aggressiveCowss(int[] stalls, int k) {
        int len = stalls.length;
        Arrays.sort(stalls);
        int low = 1; 
        int high = stalls[len-1] - stalls[0];
        int res = 0;
        while(low<=high){
            int mid = (low + high) >> 1;
            if(isPossible(stalls, mid, k,len)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }

    static boolean isPossible(int[] stalls, int minDist, int k, int len){
        int cows = 1;
        int lastPos = stalls[1];

        for(int i = 1; i < len; i++){
            if(stalls[i] - stalls[lastPos] >= minDist){
                cows++;
                lastPos = i;
                if(cows >= k) return true;
            }
        }

        return false;
    }
}
