import GLOOP.*;

class Ring {
	GLTorus body;
	GLVektor position;
	
	public Ring(int x, int y, int z) {
		position = new GLVektor(x,y,z);
		body = new GLTorus(position, 50, 7);
	}
	public GLVektor getPosition() {}
}
