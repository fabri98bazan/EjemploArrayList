package ar.edu.unju.ar.model;

public class Chofer {
	private int cod;
	private String nombre;
	
	public Chofer() {
		// TODO Auto-generated constructor stub
	}

	public Chofer(int cod, String nombre) {
		this.cod = cod;
		this.nombre = nombre;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Chofer [cod=" + cod + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
