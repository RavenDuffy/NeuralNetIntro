package Optimisation;

/** This program takes two numbers and makes them more positive using 
numerical gradient optimisation. This form of optimisation utilises
calculus to find sets of values that consistently increase the output
*/

public class NumericalGradient {
	public static void main(String[] args) {
		System.out.println(optimiseValues(-2f, 3f, 0.0001f, 0.01f));
	}
	
	/**
	    float x, y: these are the starting values for the multiply function
	    float h: this is the tweak and is used to observe what changes when
	             the numbers are adjusted by a small value
	    float stepSize: this numbers is used to scale the adjustment to x and y
	    				smaller numbers are more optimal as they insure no values
	    				are skipped
	 */
	public static float optimiseValues(float x, float y, float h, float stepSize) {
		float originalOutput = multiplyGate(x, y); // this holds the first 
												   // unadjusted value
		
		// the derivative shows how quickly something is changing and in what
		// direction the change occurs
		
		// calculates derivative with respect to x
		float xTweaked = x + h; // tweaks x using h
		float xTweakOutput = multiplyGate(xTweaked, y); // gives an adjusted
														// output using h
		float xDerivative = (xTweakOutput - originalOutput) / h;
		
		// calculates derivative with respect to y
		float yTweaked = y + h;
		float yTweakOutput = multiplyGate(x, yTweaked);
		float yDerivative = (yTweakOutput - originalOutput) / h;
		
		// calculates the new 'optimised' values
		x += stepSize * xDerivative; // reduces/increases the x and y values to
		y += stepSize * yDerivative; // get a larger answer
		float finalOutput = multiplyGate(x, y); // calculates a new optimised value
		
		return finalOutput;
	}
	
	public static float multiplyGate(float x, float y) {
		return x * y;
	}
}
