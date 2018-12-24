package Neurons;

public class Unit {
	public float value; // both public because they are going to be changed and observed
	public float grad;
	
	public Unit(float value, float grad) {
		this.value = value; // this is the value calculated in the 'forward' pass
		this.grad = grad;   // this is the derivative of the circuit output w.r.t this unit, calculated in the 'backward' pass
	}
}
