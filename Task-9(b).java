class RegexMatching { 
public boolean isMatch(String s, String p) { 
return matchHelper(s, p, 0, 0); 
} 
private boolean matchHelper(String s, String p, int i, int j) { 
if (j == p.length()) return i == s.length(); 
boolean firstMatch = (i < s.length() &&  
(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')); 
if (j + 1 < p.length() && p.charAt(j + 1) == '*') { 
return matchHelper(s, p, i, j + 2) || (firstMatch && matchHelper(s, p, i + 1, 
j)); 
} else { 
return firstMatch && matchHelper(s, p, i + 1, j + 1); 
} 
} 
public static void main(String[] args) { 
RegexMatching regex = new RegexMatching(); 
System.out.println(regex.isMatch("aa", "a*"));   
System.out.println(regex.isMatch("mississippi", "mis*is*p*."));   
System.out.println(regex.isMatch("ab", ".*"));   
System.out.println(regex.isMatch("aab", "c*a*b"));   
} 
}
