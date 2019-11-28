package Model;

import processing.core.PApplet;

public class Tipo1 extends Organismo {

	public Tipo1(PApplet app, boolean estado, int edad, boolean sexo, float x, float y) {

		super(app, estado, edad, sexo, x, y);

	}

	public void pintar() {

		super.app.fill(100, 0, 0);
		super.app.ellipse(super.x, super.y, 20, 20);

	}

}
