import GLOOP.*;

class Ring {
	GLTorus body;
	GLVektor position;
	
	//in welche Richtung wird er sich im naechsten Durchlauf bewegen
	GLVektor heading;
	
	public Ring(double x, double y, double z) {
		position = new GLVektor(x,y,z);
		body = new GLTorus(position, 50, 7);
	}
	//public void move() {}
}
