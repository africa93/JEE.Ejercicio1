package restApi;

public class Fraccion {
	private int dividendo;
	private int divisor;
	public Fraccion() {
	}
	public Fraccion(int dividendo, int divisor) {
		super();
		this.dividendo = dividendo;
		this.divisor = divisor;
	}
	public int getDividendo() {
		return dividendo;
	}
	public void setDividendo(int dividendo) {
		this.dividendo = dividendo;
	}
	public int getDivisor() {
		return divisor;
	}
	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}
	@Override
	public String toString() {
		return "Fraccion [dividendo=" + dividendo + ", divisor=" + divisor + "]";
	}

}
