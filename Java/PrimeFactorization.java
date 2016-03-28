package net.bethydiakabana;

public class PrimeFactorization {
	public static void main(String[] args) {
//		long N = Long.parseLong(args[0]);
		long N = 23456;
		// uses exponents for efficiency
		for (int i = 2; i*i <= N; i++) {
			// continues to divide through if i is a factor of N
			while (N % i == 0) {
				System.out.print(i + " ");
				N = N / i;
			} // end while
		} // end for
		
		// if the biggest factor occurs only once
		if (N > 1)
			System.out.println(N);
		else
			System.out.println();
	} // end main
} // end PrimeFactorization
