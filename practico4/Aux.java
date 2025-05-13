package practico4;

public class Aux {
	private String color;
	private int TI;
	private int TF;
	public Aux(String color,int TI,int TF) {
		this.color = color;
		this.TI = TI;
		this.TF =TF;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getTI() {
		return TI;
	}
	public void setTI(int tI) {
		TI = tI;
	}
	public int getTF() {
		return TF;
	}
	public void setTF(int tF) {
		TF = tF;
	}
    @Override
    public String toString() {
        return "[color=" + color + ", TI=" + TI + ", TF=" + TF + "]";
    }
}
