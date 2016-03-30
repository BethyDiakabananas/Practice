/**
 * Class <tt>BitStringEvaluator<tt> takes in two bit streams of the 
 * same length, and evaluates the bitwise AND, bitwise OR, and bitwise XOR
 * of the bit stream
 * 
 * @author Bethy Diakabana
 * 
 */
public class BitStringEvaluator {
	/**
	 * Evaluates the bitwise AND, bitwise OR, and bitwise XOR two bit streams of
	 * the <i>n</i> length
	 * 
	 * @param bitStreamOne
	 *            first bit stream
	 * @param bitStreamTwo
	 *            second bit stream
	 */
	public static void evaluateBitStrings(int bitStreamOne, int bitStreamTwo) {
		if (Integer.toBinaryString(bitStreamOne).length() != Integer
				.toBinaryString(bitStreamTwo).length())
			System.out.println("Please enter bit strings of the same length.");
		else {
			System.out.printf("BITWISE AND: %s\n",
					Integer.toBinaryString((bitStreamOne & bitStreamTwo)));
			System.out.printf("BITWISE OR: %s\n",
					Integer.toBinaryString((bitStreamOne | bitStreamTwo)));
			System.out.printf("BITWISE XOR: %s\n",
					Integer.toBinaryString((bitStreamOne ^ bitStreamTwo)));
		} // end if
	} // end method evaluateBitiseOperator

	public static void main(String[] args) {
		BitStringEvaluator.evaluateBitStrings(0b1101, 0b1011);
	} // end main
} // end class BitStringEvaluator
