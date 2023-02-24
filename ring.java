import GLOOP.*;

class Ring {
	GLTorus body;
	GLVektor position;
	
	public Ring(int x, int y, int z) {
		position = new GLVektor(Math.random() * x,20 + Math.random() * y,Math.random() * z);
		body = new GLTorus(position, 40, 4);
		body.setzeSelbstleuchten(1,1,1);
		body.setzeFarbe(0.81, 0.33, 0.0);
	}
	public GLVektor getCenter() {
		return position;
	}
	public void loesche() {
		body.loesche();
	}
}
