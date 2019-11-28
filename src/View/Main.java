package View;

import Model.Logica;
import processing.core.PApplet;

public class Main extends PApplet {

	Logica logica;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(800, 600);
	}

	public void setup() {
		logica = new Logica(this);
		logica.pintar();

	}

	public void draw() {
		background(232, 248, 255);
		logica.pintar();

	}

	public void keyPressed() {
		

	}
}
