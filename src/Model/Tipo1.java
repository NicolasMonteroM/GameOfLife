package Model;

import processing.core.PApplet;

public class Tipo1 extends Organismo {
	
	private int tipo;

	public Tipo1(PApplet app, String estado, int edad, String sexo, int velocidad) {
		super(app, estado, edad, sexo,velocidad);		
		if(sexo.equals("F")) {
			super.imagen = super.app.loadImage("images/Tipo1F.png");
		}else if(sexo.equals("M")) {
			super.imagen = super.app.loadImage("images/Tipo1M.png");
		}
		this.tipo = 1;
	}

	public void pintar() {
		app.image(super.imagen, super.x, super.y,30,15);
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
