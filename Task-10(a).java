import java.util.*; 
class Solution { 
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { 
List<List<Integer>> result = new ArrayList<>(); 
if (nums1.length == 0 || nums2.length == 0 || k == 0) return result; 
PriorityQueue<int[]> minHeap = new 
PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]]))); 
for (int i = 0; i < Math.min(k, nums1.length); i++) { 
minHeap.offer(new int[]{i, 0});  // {index in nums1, index in nums2} 
} 
while (k-- > 0 && !minHeap.isEmpty()) { 
int[] pair = minHeap.poll(); 
int i = pair[0], j = pair[1]; 
result.add(Arrays.asList(nums1[i], nums2[j])); 
if (j + 1 < nums2.length) { 
minHeap.offer(new int[]{i, j + 1}); 
} 
} 
return result; 
} 
public static void main(String[] args) { 
Solution sol = new Solution(); 
int[] nums1 = {1, 7, 11}; 
int[] nums2 = {2, 4, 6}; 
int k = 3; 
List<List<Integer>> result = sol.kSmallestPairs(nums1, nums2, k); 
System.out.println(result);   
}
}
