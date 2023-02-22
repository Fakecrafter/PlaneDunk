import GLOOP.*;

/*
 * Klasse des Flugzeugs
 */
class Plane {
	private GLQuader body;
	private GLVektor position;
	// in welche Richtung zeigt das Flugzeug
	private GLVektor heading;
	private double speed;

	public Plane() {
		body = new GLQuader();
		position = new GLVektor(0,50,0);
		heading = new GLVektor(1,0,0);
	}

	// bewege Flugzeug nach oben
	public void headUp() {
		heading.addiere(new GLVektor(0, 0.5, 0));
		heading.skaliere(1.0);
	}
	// bewege Flugzeug nach unten
	public void headDown() {
		heading.addiere(new GLVektor(0, -0.5, 0));
		heading.skaliere(1.0);
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
		position.addiere(heading);
		body.setzePosition(position);
	}

	public GLVektor getCenter() {
		return position;
	}
	public GLVektor getOptimalCameraPosition() {}
}
