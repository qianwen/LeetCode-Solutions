/* Reverse Integer 
* Reverse digits of an integer.

* Example1: x = 123, return 321
* Example2: x = -123, return -321
*
*/

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(1000000003));
		System.out.println(reverse2(-123));
	}

	public static int reverse(int x) { 
		if (x == 0) {
			return 0;
		}
		
		long newN = 0;
		long longX = x;

		while (longX != 0) {
			newN = newN * 10 + longX % 10;
			longX = longX / 10; 
		}

        if (newN > Integer.MAX_VALUE || newN < Integer.MIN_VALUE) {
        	throw new IllegalArgumentException();
        }

		return (int)newN;
	}

	public static int reverse2(int x) {
		if (x == 0) {
			return 0;
		}

		int indictor = 1;
		if (x < 0) {
			indictor = -1;
			x = Math.abs(x);
		}

		String s = Integer.toString(x);
		StringBuilder sb = new StringBuilder();

		for (int i = s.length() -1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		int temp = Integer.parseInt(sb.toString());
		return temp * indictor; 
	}
}