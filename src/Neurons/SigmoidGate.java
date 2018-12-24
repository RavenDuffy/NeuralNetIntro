package Neurons;

public class SigmoidGate {
	private Unit u0;
	private Unit utop;
	
	public Unit forward(Unit u0) {
		this.u0 = u0;
		this.utop = new Unit(sigmoid(this.u0.value), 0.0f);
		return utop;
	}
	
	public void backward() {
		float s = sigmoid(u0.value);
		u0.grad += (s * (1 - s)) * utop.grad;
	}
	
	public float sigmoid(float x) {
		return 1f / (1f + ((float) Math.exp(-x))); // sigmoid calculation
	}
}
