package Neurons;

public class MultiplyGate { 
	private Unit u0; // input unit
	private Unit u1; // input unit
	private Unit utop; // output unit
	
	// saves the two input Units and creates one output Unit (utop)
	public Unit forward(Unit u0, Unit u1) {
		this.u0 = u0;
		this.u1 = u1;
		utop = new Unit(u0.value * u1.value, 0.0f); // creating a new unit
		return utop;
	}
	
	// backward should only be run when a gradient value has been calculated for
	// the utop Unit
	
	// gets the gradient from utop and chain rules it with the local gradient
	// derived from multiplyGate, adds the gradients to those Units
	// i.e. this function calculates the local derivative(grad) and multiplies it 
	//      by the gradient above it (chain rule)
	public void backward() {
		this.u0.grad += this.u1.value * this.utop.grad;
		this.u1.grad += this.u0.value * this.utop.grad;
	}
}
