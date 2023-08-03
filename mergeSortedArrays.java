import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		int maxLength = kArrays.get(0).size();

		for(int i = 1; i < k; i++){
			if(kArrays.get(i).size() > maxLength){
				maxLength = kArrays.get(i).size();
			}
		}

		for(int i = 0; i < maxLength; i++){
			for(int j = 0; j < k; j++){
				try{
					minHeap.offer(kArrays.get(j).get(i));
				}catch (ArrayIndexOutOfBoundsException e) {
    				continue;
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();

		while(!minHeap.isEmpty()){
			ans.add(minHeap.poll());
		}

		return ans;
	}
}
