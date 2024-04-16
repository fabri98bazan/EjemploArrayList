package ar.edu.unju.ar.model;

public class Taxi {
	private Chofer chofer;
	private String matricula;
	
	
	public Taxi() {
		// TODO Auto-generated constructor stub
	}


	public Taxi(Chofer chofer, String matricula) {
		this.chofer = chofer;
		this.matricula = matricula;
	}


	public Chofer getChofer() {
		return chofer;
	}


	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return "Taxi [chofer=" + chofer + ", matricula=" + matricula + "]";
	}
	
	
}
