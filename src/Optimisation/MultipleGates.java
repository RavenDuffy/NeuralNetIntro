package Optimisation;

/** 
 *  This program calcuates the expression: f(x, y, z) = (x + y) * z
 *  
 *  When making circuits with multiple gates the each step must be broken down and derived
 *  separately. After the steps are derived, the derivative of the whole function is created
 *  using the chain rule to combine the previous derivatives. The original values are changed
 *  in response to a 'force'. This change is calculated by adding the original value to a 
 *  step (0.01 in this case) multiplied by its respective derivative.
 */

public class MultipleGates {
	public static void main(String[] args) {
		System.out.println(circuit(-2, 5, -4));
	}
	
	public static float circuit(float x, float y, float z) {
		float xa = x; float ya = y; float za = z; // these will be adjusted later on
		
		float q = addGate(x, y);		// these are in separate steps to show
		float f = multiplyGate(q, z);	// the math behind them more easily
		System.out.println(f); 			// This is the initial, unchanged value
		
		// This portion will calculate the gradient/derivative of the multiplyGate,
		// simply swapping the numbers reveals the gradient because of the calculus
		// product rule.
		float derivativefwrtz = q; 
		float derivativefwrtq = z; // 'wrt' means with respect to
		
		// This portion will calculate the gradient/derivative of the addGate, in
		// this case each value is set to 1 because of the calculus sum rule.
		float derivativeqwrtx = 1f;
		float derivativeqwrty = 1f;
		
		// This portion calculates the gradient/derivative of the entire function:
		// f(x, y, z) = (x + y) * z. It does so using the chain rule.
		float derivativefwrtx = derivativeqwrtx * derivativefwrtq;
		float derivativefwrty = derivativeqwrty * derivativefwrtq;
		
		// array of the final gradients to be used (not a necessary step but useful)
		float[] gradientsfwrtXYZ = {derivativefwrtx, derivativefwrty, derivativefwrtz};
		
		// allow inputs to change with response to a force (0.01)
		float stepSize = 0.01f;
		xa = x + stepSize * gradientsfwrtXYZ[0];
		ya = y + stepSize * gradientsfwrtXYZ[1];
		za = z + stepSize * gradientsfwrtXYZ[2];
		
		// re-running the f(x, y, z) circuit will now give a more positive output
		q = addGate(xa, ya);		// using the newly updated x, y and z
		f = multiplyGate(q, za);
		
		return f;
	}
	
	public static float multiplyGate(float a, float b) {
		return a * b;
	}
	
	public static float addGate(float a, float b) {
		return a + b;
	}
}
