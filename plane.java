import GLOOP.*;

/*
 * Klasse des Flugzeugs
 */
class Plane {
	private GLQuader body;
	private GLVektor position;
	// in welche Richtung zeigt, das Flugzeug
	private GLVektor heading;

	public Plane() {
		body = new GLQuader();
		position = new GLVektor(0,50,0);
		heading = new GLVektor(1,0,0);
	}

	public void headUp() {
		heading.addiere(new GLVektor(0, 0.5, 0));
		heading.skaliere(1.0);
	}
	public void headDown() {
		heading.addiere(new GLVektor(0, -0.5, 0));
		heading.skaliere(1.0);
	}

	public void headLeft() {
		heading.drehe(0, -0.5, 0);
		heading.skaliere(1.0);
	}
	public void headRight() {
		heading.drehe(0, -0.5, 0);
		heading.skaliere(1.0);
	}

	// GLVektor pitch() {}
	// GLVektor yaw() {}
	// GLVektor roll() {}

	public void run() {
		position.addiere(heading);
		body.setzePosition(position);
	}

	public void getCenter() {}
}
