package Neurons;

public class AddGate {
	private Unit u0;
	private Unit u1;
	private Unit utop;
	
	public Unit forward(Unit u0, Unit u1) {
		this.u0 = u0;
		this.u1 = u1;
		utop = new Unit(u0.value + u1.value, 0.0f);
		return utop;
	}
	
	public void backward() {
		// derivative with respect to u0 and u1 equals 1
		this.u0.grad += 1 * utop.grad;
		this.u1.grad += 1 * utop.grad;
	}
}
