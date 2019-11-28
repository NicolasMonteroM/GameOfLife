package Model;

import processing.core.PApplet;

public class Organismo implements Runnable {

	float x;
	float y;
	boolean estado;
	int edad;
	boolean sexo;
	int velocidad;
	int direccion;
	PApplet app;

	public Organismo(PApplet app, boolean estado, int edad, boolean sexo, float x, float y) {
		this.app = app;
		this.x = 4;
		this.y = 3;
		

	}

	public float getPosX() {
		return x;
	}

	public void setPosX(float x) {
		this.x = x;
	}

	public float getPosY() {
		return y;
	}

	public void setPosY(float y) {
		this.y = y;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void comer(Organismo a, Organismo b) {
		
		

	}

	public void nacer() {

	}
	
	public void pintar() {
		
		
	}

	
	public void run() {
		// TODO Auto-generated method stub

	}

}
