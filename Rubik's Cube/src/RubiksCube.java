
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
	private final int SIZE = 3;
	// #0
	private char[][] G = {
			{ 'g', 'g', 'g' },
			{ 'g', 'g', 'g' },
			{ 'g', 'g', 'g' }
	};
	// #1
	private char[][] O = {
			{ 'o', 'o', 'o' },
			{ 'o', 'o', 'o' },
			{ 'o', 'o', 'o' }
	};
	// #2
	private char[][] W = {
			{ 'R', 'H', 'w' },
			{ 'w', 'w', 'w'},
			{ 'w', 'w', 'G' }
	};
	// #3
	private char[][] R = {
			{ 'r', 'r', 'r' },
			{ 'r', 'r', 'r' },
			{ 'r', 'r', 'r' }
	};
	// #4
	private char[][] Y = {
			{'y', 'y', 'y'},
			{'y', 'y', 'y'},
			{'y', 'y', 'y'}
	};
	// #5
	private char[][] B = {
			{'b', 'b', 'b'},
			{'b', 'b', 'b'},
			{'b', 'b', 'b'}
	};
	/*
	 * private char[][][] cube = {
	 * G, O, W, R, Y, B
	 * };
	 */

	public RubiksCube() {

	}

	public void print() {
		printFace(G, "      ");
		for (int i = 0; i < SIZE; i++)
		{
			printLayer(O, i);
			printLayer(W, i);
			printLayer(R, i);
			printLayer(Y, i);
			System.out.println();
		}
		printFace(B, "      ");
	}

	private void printLayer(char[][] face, int l) {
		for (char ch : face[l])
		{
			System.out.print(ch + " ");
		}
	}

	private void printFace(char[][] face, String prefix) {
		for (int i = 0; i < SIZE; i++)
		{
			System.out.print(prefix);
			printLayer(face, i);
			System.out.println();
		}
	}

	public void rotateFaceClock(int f) {
		char[][] face;
		switch (f) {
			case 0:
				face = G;
				break;
			case 1:
				face = O;
				break;
			case 2:
				face = W;
				break;
			case 3:
				face = R;
				break;
			case 4:
				face = Y;
				break;
			case 5:
				face = B;
				break;
			default:
				face = null;
				break;
		} // use 3D cube above to access other sides for rotating them
		char temp = face[0][0];
		char temp2 = face[1][0];
		face[0][0] = face[2][0];
		face[1][0] = face[2][1];
		face[2][0] = face[2][2];
		face[2][1] = face[1][2];
		face[2][2] = face[0][2];
		face[1][2] = face[0][1];
		face[0][2] = temp;
		face[0][1] = temp2;
	}

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
		cube.print();
		cube.rotateFaceClock(2);
		cube.print();
		cube.rotateFaceClock(2);
		cube.print();
	}
}
