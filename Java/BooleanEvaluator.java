package diakabanab.homework2;

/**
 * Evaluates two <tt>boolean</tt> values 
 * 
 * @author Bethy Diakabana
 * @since November 5, 2015
 * 
 */

public class BooleanEvaluator {
	/**
	 * <p>Evaluates <i>and</i>, <i>or</i>, <i>xor</i>, 
	 * <i>nand</i>, and <i>nor</i> according to the 
	 * truth table below:</p>
	 * 
	 * <table border = "1" 
	 * 	<tr>
	 * 		<td>X</td>
	 *      <td>Y</td>
	 *      <td>XY</td>
	 *      <td>X + Y</td>
	 *      <td>X&oplus;Y</td>
	 *      <td>X|Y</td>
	 *      <td>X&darr;Y</td>
	 *   </tr>
	 *   <tr>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *   </tr>
	 *   <tr>
	 *     <td>1</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>0</td>
	 *   </tr>
	 *   <tr>
	 *     <td>0</td>
	 *     <td>1</td>
	 *     <td>0</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *     <td>0</td>
	 *   </tr>
	 *   <tr>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>0</td>
	 *     <td>1</td>
	 *     <td>1</td>
	 *   </tr>
	 *  </table>
	 * 
	 * @param x Boolean variable
	 * @param y Boolean variable
	 */
	public static void evaluateBools(boolean x, boolean y) {
		System.out.printf("Evaluate %b and %b\n", x, y);
		System.out.printf("X AND Y: %b\n", x && y); 
		System.out.printf("X OR Y: %b\n", x || y);
		System.out.printf("X XOR Y: %b\n", x ^ y);
		System.out.printf("X NAND Y: %b\n", !(x && y));
		System.out.printf("X NOR Y: %b\n", !(x || y));
		System.out.println();
	} // end method evaluateBooleanVariables

	/* Outputs every case of X and Y */
	public static void main(String[] args) {
		BooleanEvaluator.evaluateBools(true, true);
		BooleanEvaluator.evaluateBools(true, false);
		BooleanEvaluator.evaluateBools(false, true);
		BooleanEvaluator.evaluateBools(false, false);
	} // end main
} // end class BooleanFunctionEvaluator
