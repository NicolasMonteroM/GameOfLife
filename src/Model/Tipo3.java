package Model;

import processing.core.PApplet;

public class Tipo3 extends Organismo {
	
	private int tipo;
	
	public Tipo3(PApplet app, String estado, int edad, String sexo, int velocidad) {
		super(app, estado, edad, sexo, velocidad);
		if(sexo.equals("F")) {
			super.imagen = app.loadImage("images/Tipo3F.png");
		}else if(sexo.equals("M")) {
			super.imagen = app.loadImage("images/Tip3M.png");
		}
		this.tipo = 3;
	}

	public void pintar() {
		app.image(super.imagen, super.x, super.y,60,60);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}	
}
