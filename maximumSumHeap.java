
import java.util.*;
 
class GFG {
 

    static void KMaxCombinations(int A[], int B[],
                                 int N, int K)
    {

        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
 

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                pq.add(A[i] + B[j]);
 
        int count = 0;
 
        while (count < K) {
            System.out.println(pq.peek());
            pq.remove();
            count++;
        }
    }
 
  
    public static void main(String[] args)
    {
        int A[] = { 4, 2, 5, 1 };
        int B[] = { 8, 0, 5, 3 };
        int N = A.length;
        int K = 3;
 
 
        KMaxCombinations(A, B, N, K);
    }
}