import GLOOP.*;
import java.util.Random;

class Game {
	private Random rand;
	private GLKamera cam;
	private GLLicht light;
	private int score;
	private int highscore;
	private GLTastatur keyboard;
	private Plane plane;
	private Ring[] rings;
	private GLBoden floor;
	private GLHimmel sky;

	public Game() {
		rand = new Random();
		floor = new GLBoden();
		sky = new GLHimmel();
		cam = new GLEntwicklerkamera(); // spaeter in Schwenkkamera aendern
		light = new GLLicht();
		keyboard = new GLTastatur();
		plane = new Plane();
		rings = new Ring[10];
		score = 0;
		highscore = 0;
		for(int i=0; i<10; i++) {
			rings[i] = new Ring(i*20, 50, i*20);
		}
	}
	public static void main() {
		while (true) {
			//checkCollision();
			checkKeyboard();
			plane.run();
			Sys.warte(17);
		}
	}
	// ueberprueft die Tastatureingaben
	void checkKeyboard() {
		if (keyboard.oben()){plane.up()}
		if (keyboard.unten()){plane.down()}
		if (keyboard.links()){plane.left()}
		if (keyboard.rechts()){plane.right()}
	}
}


