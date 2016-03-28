package net.bethydiakabana;

/**
 * Calculates the sum of 1 + 1/2 + ... 1/N
 * @author Bethy Diakabana
 *
 */
public class Harmonics {
	public static void main(String[] args) {
//		int N = Integer.parseInt(args[0]);
		int N = 20;
		double sum = 0;
		for (int i = 1; i <= N; i++) {
			if (i == N)
				System.out.printf("1/%d = ", N);
			else 
				System.out.printf("1/%d + ", i);
			sum += 1.0 / i;
		} // end for
		System.out.println(sum);
	} // end main
} // end class Harmonics
