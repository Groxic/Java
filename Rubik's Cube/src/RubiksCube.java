// consider shifting array "cube" to orient cube and rename Faces: "one" ... "six" then assign connected faces to the face for modular implementation of rotation, not hardcoded
public class RubiksCube {
	/*
	 *		 G G G
	 * 		 G 0 G
	 * 		 G G G
	 * O O O W W W R R R Y Y Y
	 * O 1 O W 2 W R 3 R Y 4 Y
	 * O O O W W W R R R Y Y Y
	 *		 B B B
	 *		 B 5 B
	 *		 B B B
	 */
	// public int orient = 2; // which side is up
	// #0
	public Face G = new Face('g');
	// #1
	public Face O = new Face('o');
	// #2
	public Face W = new Face('w');
	// #3
	public Face R = new Face('r');
	// #4
	public Face Y = new Face('y');
	// #5
	public Face B = new Face('b');

	public Face[] cube = { G, O, W, R, Y, B };

	public RubiksCube() {
		G.setAbove(Y);
		G.setBelow(W);
		G.setLeft(O);
		G.setRight(R);
		O.setAbove(G);
		O.setBelow(B);
		O.setLeft(Y);
		O.setRight(W);
		W.setAbove(G);
		W.setBelow(B);
		W.setLeft(O);
		W.setRight(R);
		R.setAbove(G);
		R.setBelow(B);
		R.setLeft(W);
		R.setRight(Y);
		Y.setAbove(G);
		Y.setBelow(B);
		Y.setLeft(R);
		Y.setRight(O);
		B.setAbove(W);
		B.setBelow(Y);
		B.setLeft(O);
		B.setRight(R);
	}

	public void print() {
		G.print("      ");
		System.out.println();
		for (int i = 0; i < 3; i++)
		{
			O.printRow(i);
			W.printRow(i);
			R.printRow(i);
			Y.printRow(i);
			System.out.println();
		}
		B.print("      ");
		System.out.println();
	}

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
		cube.print();
		System.out.println();
		for (Face f : cube.cube)
		{
			f.rotateClockWise();
			cube.print();
			System.out.println();
		}
		System.out.println();
	}
}
