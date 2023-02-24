import GLOOP.*;

class Ring {
	GLTorus body;
	GLVektor position;
	
	public Ring(int x, int y, int z) {
		position = new GLVektor(Math.random() * x,60 + Math.random() * y,Math.random() * z);
		body = new GLTorus(position, 60, 4);
		body.setzeFarbe(0.81, 0.33, 0.0);
	}
	public GLVektor getCenter() {
		return position;
	}
	public void loesche() {
		body.loesche();
	}
}
