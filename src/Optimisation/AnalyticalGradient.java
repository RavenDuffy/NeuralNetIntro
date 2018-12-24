package Optimisation;

/**
 *  This is a more succinct version of the optimisation by numerical gradient. It
 *  is made possible because the derivative of x will always equal y and vice versa.
 *  It will calculate roughly the same value using much simpler operations and using
 *  less resources. 
 *  
 *  However, this is will not work depending on the input values. It will always work
 *  in the case of the multiply gate but in other more complex problems new analytical
 *  gradients will have to be calculated.
 */

public class AnalyticalGradient {
	public static void main(String[] args) {
		System.out.println(optimiseValue(-2f, 3f, 0.01f));
	}
	
	/**
	 * float x, y: these are the numbers used in the multiplyGate
	 * float stepSize: this is the scale on which the output will be optimised by
	 */
	public static float optimiseValue(float x, float y, float stepSize) {
		float xGradient = y;
		float yGradient = x;
		
		x += stepSize * xGradient;
		y += stepSize * yGradient;
		
		float newOutput = multiplyGate(x, y);
		
		return newOutput;
	}
	
	public static float multiplyGate(float x, float y) {
		return x * y;
	}
}
