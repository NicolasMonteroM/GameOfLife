package Model;

import processing.core.PApplet;

public class Tipo2 extends Organismo{
	
	private int tipo;
	
	public Tipo2(PApplet app, String estado, int edad, String sexo, int velocidad) {
		super(app, estado, edad, sexo,velocidad);
		if(sexo.equals("F")) {
			super.imagen = app.loadImage("images/Tipo2F.png");
		}else if(sexo.equals("M")) {
			super.imagen = app.loadImage("images/Tipo3M.png");
		}
		this.tipo = 2;
	}
	
	public void pintar() {
		app.image(super.imagen, super.x, super.y,50,50);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
