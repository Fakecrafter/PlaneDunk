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
		position = new GLVektor(0,200,0);
		body = new GLQuader(position,30,10,10);
		heading = new GLVektor(1,0,0);
		speed = 40.0;
	}

	// bewege Flugzeug nach oben
	public void headUp() {
		GLVektor axis = new GLVektor(heading.gibZ(), 0, -1.0 * heading.gibX());
		heading.rotiere(-0.5, axis);
	}
	// bewege Flugzeug nach unten
	public void headDown() {
		GLVektor axis = new GLVektor(heading.gibZ(), 0, -1.0 * heading.gibX());
		heading.rotiere(0.5, axis);
	}

	// bewege Flugzeug nach links
	public void headLeft() {
		heading.drehe(0, 2.0, 0);
		//body.rotiere(-0.5, position, new GLVektor(0,1,0));
	}
	// bewege Flugzeug nach rechts
	public void headRight() {
		heading.drehe(0, -2.0, 0);
		//body.rotiere(0.5, position, new GLVektor(0,1,0));
	}

	// jede Iteration muss sich das Flugzeug weiterbewegen
	public void run() {
		// ueberpruefen, ob das Flugzeug sich unter dem Boden befindet
		if(position.gibY() <= 10) {
			heading = new GLVektor(heading.gibX(), 0, heading.gibZ());
			position.y = 10;
		}
		heading.skaliereAuf(speed);
		position.addiere(heading);
		body.setzePosition(position);
	}

	public GLVektor getCenter() {
		return position;
	}
	public GLVektor getOptimalCameraPosition() {
		GLVektor tmp = new GLVektor(position.gibX() - (heading.gibX() * 5), position.gibY() + 10, position.gibZ() - (heading.gibZ() * 5));
		return tmp;
	}
}
