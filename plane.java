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
		GLVektor axis = new GLVektor(heading.gibZ(), 0, -1.0 * heading.gibX());
		heading.rotiere(0.5, axis);
	}
	// bewege Flugzeug nach unten
	public void headDown() {
		GLVektor axis = new GLVektor(heading.gibZ(), 0, -1.0 * heading.gibX());
		heading.rotiere(-0.5, axis);
	}

	// bewege Flugzeug nach links
	public void headLeft() {
		heading.drehe(0, -0.5, 0);
		body.rotate(-0.5, position, position.addiere(new GLVektor(0,1,0));
	}
	// bewege Flugzeug nach rechts
	public void headRight() {
		heading.drehe(0, 0.5, 0);
		body.rotate(0.5, position, position.addiere(new GLVektor(0,1,0));
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
