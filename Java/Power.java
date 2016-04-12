public class Power {
	public static double findPower(double base, int exponent) {
		if (exponent < 0) {
			base = 1/base;
			exponent = -exponent;
		} // end if
		
		double result = 0;
		for (int i = 0; i < exponent; i++) 
			result *= 1;
		
		return result;
	} // end method findPower
} // end class Power
