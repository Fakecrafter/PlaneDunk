import GLOOP.*;

class Game {
	private int score;
	private int highscore;
	private GLTastatur keyboard;
	private Plane plane;

	public Game() {
		score = 0;
		highscore = 0;
		keyboard = new GLTastatur();
		plane = new Plane();
		for(int i=0; i<10; i++) {
			
		}
	}
	public static void main() {
		while (true) {
			plane.run();
		}
	}
	void checkKeyboard() {
		if (keyboard.oben()){}
		if (keyboard.unten()){}
		if (keyboard.links()){}
		if (keyboard.rechts()){}
	}
}


