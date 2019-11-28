package Model;


import processing.core.PApplet;
import processing.core.PImage;

public abstract class Organismo implements Runnable {

	float x;
	float y;
	String estado;
	int edad;
	String sexo;
	int velocidad;
	int direccionX;
	int direccionY;
	PApplet app;
	PImage imagen;

	public Organismo(PApplet app, String estado, int edad, String sexo, int vel) {
		this.app = app;
		this.estado = estado;
		this.edad = edad;
		this.sexo = sexo;	
		this.velocidad = vel;
		this.x = app.random(100, this.app.width - 100);
		this.y = app.random(100, this.app.height - 100);
		this.direccionX = 1;
		this.direccionY = 1;

	}
	
	@Override
	public int hashCode() {
		int result  = (int)(this.x + this.y);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public void run() {
		
		while(this.getEstado().equals("vivo")) {
			try {
				
				this.x += this.velocidad*this.direccionX;
				this.y += this.velocidad*this.direccionY;
				
				if(this.x <= 0 || this.x >= this.app.width-40 ) {
					this.direccionX *= -1;
				}
				
				if(this.y <= 0 || this.y >= this.app.height-40) {
					this.direccionY *= -1;				
				}
				
				Thread.sleep(100);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public abstract void pintar();
	
		
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

	public String isEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String isSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public String getEstado() {
		return estado;
	}

	public String getSexo() {
		return sexo;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	
	


}
