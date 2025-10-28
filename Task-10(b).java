import java.util.*; 
class Solution { 
public int findKthLargest(int[] nums, int k) { 
PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
for (int num : nums) { 
minHeap.offer(num);  
if (minHeap.size() > k) { 
minHeap.poll(); 
} 
} 
return minHeap.peek(); 
} 
public static void main(String[] args) { 
Solution sol = new Solution(); 
int[] nums = {3,2,1,5,6,4}; 
int k = 2; 
System.out.println(sol.findKthLargest(nums, k));  
} 
}
