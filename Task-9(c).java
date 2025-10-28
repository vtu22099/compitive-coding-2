import java.util.*; 
class SequentialDigits { 
public List<Integer> sequentialDigits(int low, int high) { 
List<Integer> result = new ArrayList<>(); 
for (int start = 1; start <= 9; start++) { 
generateNumbers(start, 0, low, high, result); 
} 
Collections.sort(result); 
return result; 
} 
private void generateNumbers(int digit, int num, int low, int high, List<Integer> 
result) { 
if (num >= low && num <= high) { 
result.add(num); 
} 
if (num > high || digit > 9) { 
return; 
} 
generateNumbers(digit + 1, num * 10 + digit, low, high, result); 
} 
public static void main(String[] args) { 
SequentialDigits obj = new SequentialDigits(); 
int low = 100, high = 300; 
System.out.println("Sequential digits in range: " + obj.sequentialDigits(low, 
high)); 
} 
}
