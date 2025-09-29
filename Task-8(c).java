//Decode an encoded string
import java.util.*;

class Main {
    public static String decode_string(String s){
        Stack<Integer>countStack=new Stack<>();
        Stack<StringBuilder>strStack=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10+(ch-'0');
                
            }else if(ch=='['){
                countStack.push(k);
                strStack.push(curr);
                curr=new StringBuilder();
                k=0;
            }else if(ch==']'){
                int t=countStack.pop();
                StringBuilder prev=strStack.pop();
                for(int i=0;i<t;i++)prev.append(curr);
                curr=prev;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
    public static void main(String[] args){
        String enc1="3[a]2[bc]";
        String enc2="3[a2[c]]";
        System.out.println(enc1+"->"+decode_string(enc1));
        System.out.println(enc2+"->"+decode_string(enc2));
    }
}
