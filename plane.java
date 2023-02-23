import GLOOP.*;

/*
 * Klasse des Flugzeugs
 */
class Plane {
	private GLQuader body;
	private GLVektor position;
	// in welche Richtung zeigt das Flugzeug
	private GLVektor heading;
	private double speed ;

	// erstelle neues Flugzeug
	public Plane() {
		position = new GLVektor(0,50,0);
		body = new GLQuader(position,10,10,10);
		heading = new GLVektor(1,0,0);
	}

	// bewege Flugzeug nach oben
	public void headUp() {
		heading.addiere(new GLVektor(0, 0.5, 0));
		heading.skaliereAuf(1.0);
	}
	// bewege Flugzeug nach unten
	public void headDown() {
		heading.addiere(new GLVektor(0, -0.5, 0));
		heading.skaliereAuf(1.0);
	}

	// bewege Flugzeug nach links
	public void headLeft() {
		heading.drehe(0, -0.5, 0);
	}
	// bewege Flugzeug nach rechts
	public void headRight() {
		heading.drehe(0, -0.5, 0);
	}

	// jede Iteration muss sich das Flugzeug weiterbewegen
	public void run() {
		// ueberpruefen, ob das Flugzeug sich unter dem Boden befindet
		if(position.GibY() <= 10) {
			heading = new GLVektor(heading.gibX(), 0, heading.gibZ());
		}
		position.addiere(heading);
		body.setzePosition(position);
	}

	public GLVektor getCenter() {
		return position;
	}
	//public GLVektor getOptimalCameraPosition() {}
}
