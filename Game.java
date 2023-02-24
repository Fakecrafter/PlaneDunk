import GLOOP.*;
import java.util.Random;

class Game {
	private Random rand;
	private GLKamera cam;
	private GLLicht light;
	private int score;
	private GLTastatur keyboard;
	private Plane plane;
	private Ring[] rings;
	private GLBoden floor;
	private GLHimmel sky;

	public Game() {
		rand = new Random();
		floor = new GLBoden("textures/boden.png");
		sky = new GLHimmel("textures/himmel.jpg");
		plane = new Plane();
		cam = new GLSchwenkkamera();
		cam.setzePosition(plane.getOptimalCameraPosition());
		cam.setzeBlickpunkt(plane.getCenter());
		light = new GLLicht();
		keyboard = new GLTastatur();
		rings = new Ring[10];
		score = 0;
		for(int i=0; i<10; i++) {
			rings[i] = new Ring(8000, 1000, 8000);
		}
	}
	public void main() {
		// game loop
		while (true) {
			checkCollision();
			checkKeyboard();
			plane.run();
			cam.setzePosition(plane.getOptimalCameraPosition());
			cam.setzeBlickpunkt(plane.getCenter());
			Sys.warte(10);
		}
	}
	// ueberprueft die Tastatureingaben
	private void checkKeyboard() {
		if (keyboard.oben()){plane.headUp();}
		if (keyboard.unten()){plane.headDown();}
		if (keyboard.links()){plane.headLeft();}
		if (keyboard.rechts()){plane.headRight();}
	}
	private void checkCollision() {
		double distance;
		GLVektor planePos = plane.getCenter();
		// Kollision mit allen Ringen ueberpruefen
		for(int i=0; i<rings.length; i++) {
			GLVektor tmp = rings[i].getCenter();
			tmp.subtrahiere(planePos);
			// wie weit ist das Flugzeug vom Mittelpunkt eines Rings entfernt
			distance = Math.sqrt(tmp.gibX() * tmp.gibX() + tmp.gibY() * tmp.gibY() + tmp.gibZ() * tmp.gibZ());

			if(distance < 40) {
				//rings[i].setzeSichtbarkeit(false);
				rings[i].loesche();
				rings[i] = new Ring(8000, 1000, 8000);
				score++;
			}
		}
	}
}


