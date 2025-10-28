import java.util.*; 
class Solution { 
public int[][] kClosest(int[][] points, int k) { 
PriorityQueue<int[]> maxHeap = new PriorityQueue<>( 
(a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * 
a[1])) 
); 
for (int[] point : points) { 
maxHeap.offer(point); 
if (maxHeap.size() > k) { 
maxHeap.poll(); 
} 
} 
int[][] result = new int[k][2]; 
for (int i = 0; i < k; i++) { 
result[i] = maxHeap.poll(); 
} 
return result; 
} 
public static void main(String[] args) { 
Solution sol = new Solution(); 
int[][] points = {{3,3},{5,-1},{-2,4}}; 
int k = 2; 
int[][] result = sol.kClosest(points, k); 
for (int[] p : result) { 
System.out.println(Arrays.toString(p)); 
} 
}
}
