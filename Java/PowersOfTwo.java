package net.bethydiakabana;

public class PowersOfTwo {
	public static void main(String[] args) {
//		int N = Integer.parseInt(args[0]);
		int N = 10;
		int powerOfTwo = 1;
		for (int i = 0; i <= N; i++) {
			System.out.println(i + " " + powerOfTwo);
			powerOfTwo *= 2;
		} // end for 
	} // end main
} // end class PowersOfTwo
