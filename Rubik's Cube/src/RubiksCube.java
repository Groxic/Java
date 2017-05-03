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
	// private int orient = 2; // which side is up
	// #0
	private Face G = new Face('g');
	// #1
	private Face O = new Face('o');
	// #2
	private Face W = new Face('w');
	// #3
	private Face R = new Face('r');
	// #4
	private Face Y = new Face('y');
	// #5
	private Face B = new Face('b');

	private Face[] cube = { G, O, W, R, Y, B };

	public RubiksCube() {

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

	/*
	 * public void rotateFaceClock(int f) {
	 * char[][] face = getFaceByNum(f);
	 * 
	 * // use 3D cube above to access other sides for rotating them
	 * char temp = face[0][0];
	 * char temp2 = face[1][0];
	 * face[0][0] = face[2][0];
	 * face[1][0] = face[2][1];
	 * face[2][0] = face[2][2];
	 * face[2][1] = face[1][2];
	 * face[2][2] = face[0][2];
	 * face[1][2] = face[0][1];
	 * face[0][2] = temp;
	 * face[0][1] = temp2;
	 * 
	 * char[][] faceAbove = null;
	 * char[][] faceBelow = null;
	 * char[][] faceLeft = null;
	 * char[][] faceRight = null;
	 * if (face == G)
	 * {
	 * faceAbove = Y;
	 * faceBelow = W;
	 * faceLeft = O;
	 * faceRight = R;
	 * }
	 * else if (face == B)
	 * {
	 * faceAbove = W;
	 * faceBelow = Y;
	 * faceLeft = O;
	 * faceRight = R;
	 * }
	 * else if (face == Y)
	 * {
	 * faceAbove = G;
	 * faceBelow = B;
	 * faceLeft = R;
	 * faceRight = O;
	 * }
	 * else if (face == W)
	 * {
	 * faceAbove = G;
	 * faceBelow = B;
	 * faceLeft = O;
	 * faceRight = R;
	 * }
	 * else if (face == O)
	 * {
	 * faceAbove = G;
	 * faceBelow = B;
	 * faceLeft = Y;
	 * faceRight = W;
	 * }
	 * else if (face == R)
	 * {
	 * faceAbove = G;
	 * faceBelow = B;
	 * faceLeft = W;
	 * faceRight = Y;
	 * }
	 * char[] tempRow = Arrays.copyOf(faceAbove[2], 3);
	 * faceAbove[2][0] = faceLeft[2][2];
	 * faceAbove[2][1] = faceLeft[1][2];
	 * faceAbove[2][2] = faceLeft[0][2];
	 * faceLeft[2][2] = faceBelow[0][2];
	 * faceLeft[1][2] = faceBelow[0][1];
	 * faceLeft[0][2] = faceBelow[0][0];
	 * faceBelow[0][2] = faceRight[0][0];
	 * faceBelow[0][1] = faceRight[0][1];
	 * faceBelow[0][0] = faceRight[0][2];
	 * faceRight[0][0] = tempRow[0];
	 * faceRight[1][0] = tempRow[1];
	 * faceRight[2][0] = tempRow[2];
	 * }
	 */

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
		cube.print();
	}
}
