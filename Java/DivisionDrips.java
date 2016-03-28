package net.bethydiakabana;

/**
 * Prints a table where entry (i, j) is a '* ' if i divides j
 * or j divides i and '. ' otherwise.
 * 
 * @author Bethy Diakabana
 *
 */
public class DivisorDrips {
	public static void main(String[] args) {
//		int N = Integer.parseInt(args[0]);
		int N = 24;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i % j == 0 || j % i == 0)
					System.out.print("* ");
				else
					System.out.print("  ");
			} // end for
			System.out.println(i);
		} // end for
	} // end main
} // end class DivisorDrips
