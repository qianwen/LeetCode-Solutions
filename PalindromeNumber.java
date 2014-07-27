/* Palindrome Number
* Determine whether an integer is a palindrome. Do this without extra space.

* A palindromic number or numeral palindrome is a number that remains the same when its digits are reversed.
*/

public class PalindromeNumber {
	public static void main(String[] args) {
		//System.out.println(palindromeNumber(-1));
		//System.out.println(palindromeNumber(2));
		//System.out.println(palindromeNumber(1001));
		//System.out.println(palindromeNumber(88));
		//System.out.println(palindromeNumber(67));
		System.out.println(palindromeNumber(12321));
		System.out.println(palindromeNumber2(12321));
		System.out.println(palindromeNumber(13100));
		System.out.println(palindromeNumber2(13100));
	}

    // string comparison 
	public static boolean palindromeNumber(int x) {
		if (x < 0) {
			return false; 
		} else if (x < 10) {
			return true;
		} else if (x % 10 == 0) {
			return false;
		} else {
			String s = Integer.toString(x);
			StringBuilder sb = new StringBuilder();

			for (int i = s.length() - 1; i >= 0; i --) {
				sb.append(s.charAt(i));
			}

			String newS = sb.toString();

			return newS.equals(s);
		}
	}

    // compare both side of the number 
	public static boolean palindromeNumber2(int x) {
		if (x < 0) {
			return false; 
		} else if (x < 10) {
			return true;
		} else if (x % 10 == 0) {
			return false;
		} else {
			int a = x, b = 0;  

			while (a > b) {  
				b = b * 10 + a % 10;  
				a /= 10;  
			}  

			if(a == 0) {
				return (x == b); 
			} 

			return (a == b) || a == (b / 10);  
		}
	}
}   