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

	public void headUp() {}
	public void headDown() {}
	public void headLeft() {}
	public void headRight() {}

	public void run() {
		position.addiere(heading);
		body.setzePosition(position);
	}

	public void getCenter() {}
}
