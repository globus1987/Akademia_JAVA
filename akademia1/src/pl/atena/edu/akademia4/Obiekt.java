package pl.atena.edu.akademia4;

public class Obiekt implements IObiekt{

	public Obiekt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void przedstawSie() {
		System.out.println("jestem bazowy");
	}

	@Override
	public String toString() {
		return String.format("Obiekt []");
	}

}
