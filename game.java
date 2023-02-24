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
		cam = new GLSchwenkkamera();
		light = new GLLicht();
		keyboard = new GLTastatur();
		plane = new Plane();
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
			cam.setzeBlickpunkt(plane.getCenter());
			Sys.warte(17);
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
			GLVektor ringPos = rings[i].getCenter();
			ringPos.subtrahiere(planePos);
			// wie weit ist das Flugzeug vom Mittelpunkt eines Rings entfernt
			distance = Math.sqrt(ringPos.gibX() * ringPos.gibX() + ringPos.gibY() * ringPos.gibY() + ringPos.gibZ() * ringPos.gibZ());

			if(distance < 5) {
				rings[i].loesche();
				rings[i] = new Ring(2000, 100, 2000);
				score++;
			}
		}
	}
}


