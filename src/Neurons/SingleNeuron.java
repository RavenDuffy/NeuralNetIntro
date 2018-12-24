package Neurons;

public class SingleNeuron {
	private Unit s; //  this is used to save the value of the forward pass
	
	// unit inputs
	private Unit a = new Unit(1f, 0f);
	private Unit b = new Unit(2f, 0f);
	private Unit c = new Unit(-3f, 0f);
	private Unit x = new Unit(-1f, 0f);
	private Unit y = new Unit(3f, 0f);

	// gates to be used
	private MultiplyGate mulGate1 = new MultiplyGate();
	private MultiplyGate mulGate2 = new MultiplyGate();
	private AddGate addGate1 = new AddGate();
	private AddGate addGate2 = new AddGate();
	private SigmoidGate sigGate1 = new SigmoidGate();
	
	public static void main(String[] args) {
		SingleNeuron newNeuron = new SingleNeuron();
		newNeuron.forwardPass();
		newNeuron.backwardPass();
		newNeuron.adjustInputs();
	}
	
	public void forwardPass() {
		// the following Units are written in order of operation, their names
		// correspond to what is actually happening in each calculation, e.g.
		// ax means a * x. the 'p' being used means plus, e.g. axpby which 
		// means ax + by
		Unit ax = mulGate1.forward(a, x); 
		Unit by = mulGate2.forward(b, y);
		Unit axpby = addGate1.forward(ax, by);
		Unit axpbypc = addGate2.forward(axpby, c); // this equals 2
		s = sigGate1.forward(axpbypc);	// this takes 2 and applies sigmoid
		System.out.println(s.value);
	}
	
	public void backwardPass() {
		// operations are written here exactly backwards compared to the way
		// they're presented in forward pass
		s.grad = 1f; // sets gradient to 1, this is like appling a force of 1
		sigGate1.backward(); // gives axpbypc its gradient
		addGate2.backward(); // gives axpby and c their gradients
		addGate1.backward(); // gives ax and by their gradients
		mulGate2.backward(); // gives b and y their gradients
		mulGate1.backward(); // gives a and x their gradients
	}
	
	public void adjustInputs() {
		float stepSize = 0.01f;
		// see what the inputs do when tugged by a force of 0.01
		a.value += stepSize * a.grad;
		b.value += stepSize * b.grad;
		c.value += stepSize * c.grad;
		x.value += stepSize * x.grad;
		y.value += stepSize * y.grad;
		
		forwardPass(); // this is in this method to allow for easier looping
		// the value forwardPass returns should be larger than before
	}
}
