class Solution {
    public int strStr(String haystack, String needle) {
        
        int ans = -1;

        int N = haystack.length();
        int M = needle.length();

        if(M > N){
            return -1;
        }

        int lps[] = new int[M];

        int i = 0;
        int j = 0;

        computeLPSArray(needle, M, lps);

        while((N-i)>=(M-j)){
            if(needle.charAt(j) == haystack.charAt(i)){
                i++;
                j++;
            }if(j==M){
                ans = i-j;
                j = lps[j-1];
                break;
            }else if(i < N && needle.charAt(j) != haystack.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }

        }
        return ans;
    }

    void computeLPSArray(String pat,int m, int[] lps ){
        int len = 0;

        lps[0] = 0;

        int i = 1;
        while(i<m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}