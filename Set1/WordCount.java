package Set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Problem No 2
public class WordCount {
	public static void main(String[] args) throws IOException {
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		 boolean isInput = true;
		boolean inputPresent  = false;
		while(isInput) {
			System.out.println("1 - Input a Sentence ");
			System.out.println("2 - Count Words in Sentence ");
			System.out.println("3 - Count Vowels in Sentence ");
			System.out.println("4 - Display All words ");
	        System.out.println("5 - Exit ");
	        System.out.println("Enter your choice  : ");
	        int choice = Integer.parseInt(obj.readLine());
	        switch(choice) {
	        case 1:
	        	System.out.println("Enter the String");
	        	str = obj.readLine();
	        	inputPresent = true;
	        break;
	        case 2:
	        	if(inputPresent) {
		        	System.out.println("Words Count = "+countWord(str));	
	        	}else {
	        		System.out.println("Please Enter a sentence before");
	        	}
	        break;
	        case 3:
	        	if(inputPresent) {
		        	System.out.println("Vowel Count = "+countVowels(str));
	        	}else {
	        		System.out.println("Please Enter a sentence before");
	        	}
	        break;
	        case 4:
	        	if(inputPresent) {
		        	System.out.println("Words : ");
		        	String[] words = getWords(str);
		        	for(int i=0;i<words.length;i++) {
		        		if(words[i]!=null) {
		        			System.out.println(words[i]);
		        		}
		        	}
	        	}else {
	        		System.out.println("Please Enter a sentence before");
	        	}
	        break;
	        case 5:
	        	isInput = false;
	        break;
	        }   
		}
	}
	public static String[] getWords(String s){
			 int count = 0;
		        int index = 0;
		        String words = "";
		        String[] word = new String[s.length()];
		        int top = 0;
		        for(int i=0;i<s.length();i++){
		            if(s.charAt(i)==' '){
		                count++;
		                word[top++] = words;
		                words = "";
		            }else if(i==s.length()-1) {
		                count++;
		                word[top++] = words+s.charAt(i);
		                words = "";
		            }else{
		                words+=s.charAt(i);
		            }
		        }
		      return word;
    }
	public static int countVowels(String s){
		int count = 0;
	        for(int i=0;i<s.length();i++){
	           char ch = s.charAt(i);
	           if(ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch=='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
	        	   count++;
	           }
	        }
        return count;
    }
	public static int countWord(String s){
		 int count = 0;
		        int index = 0;
		        for(int i=0;i<s.length();i++){
		            if(s.charAt(i)==' '){
		                count++;
		            }else if(i==s.length()-1) {
		                count++;
		            }else{
		            }
		        }
       return count;
    }

}
