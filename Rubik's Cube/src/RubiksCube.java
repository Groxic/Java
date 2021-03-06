import java.util.Scanner;
// http://zetcode.com/

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
	// #0
	public Face G;
	// #1
	public Face O;
	// #2
	public Face W;
	// #3
	public Face R;
	// #4
	public Face Y;
	// #5
	public Face B;

	public Face[] cube = new Face[] { G, O, W, R, Y, B };

	public final int SIZE_MOD = 40;

	public RubiksCube(boolean useRectFace) {
		if (useRectFace) {
			G = new RectFace('g', 3, 0, SIZE_MOD);
			O = new RectFace('o', 0, 3, SIZE_MOD);
			W = new RectFace('w', 3, 3, SIZE_MOD);
			R = new RectFace('r', 6, 3, SIZE_MOD);
			Y = new RectFace('y', 9, 3, SIZE_MOD);
			B = new RectFace('b', 3, 6, SIZE_MOD);
		}
		else {
			G = new Face('g');
			O = new Face('o');
			W = new Face('w');
			R = new Face('r');
			Y = new Face('y');
			B = new Face('b');
		}
		linkSides();
		cube = new Face[] { G, O, W, R, Y, B };
	}

	private void linkSides() {
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
		System.out.println();
	}

	public void rotateFace(String s) {
		char end = s.charAt(s.length() - 1);
		int faceNum = getIndexFromCenter(s.charAt(0));
		if (end == '\'')
		{
			cube[faceNum].rotateCounterClockWise();
		}
		else
		{
			cube[faceNum].rotateClockWise();
		}
	}

	public Face get(int i) {
		return cube[i];
	}

	public int getIndexFromCenter(char c) {
		switch (c) {
			case 'g': {
				return 0;
			}
			case 'o': {
				return 1;
			}
			case 'w': {
				return 2;
			}
			case 'r': {
				return 3;
			}
			case 'y': {
				return 4;
			}
			case 'b': {
				return 5;
			}
			default: {
				return -1;
			}
		}
	}

	public static Scanner intro(RubiksCube cube) {
		cube.print();
		System.out.println(
				"Enter the center letter of the face you want to rotate clockwise (include ' to reverse rotation, enter to exit)");
		return new Scanner(System.in);
	}

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube(false);
		Scanner console = intro(cube);
		String s = console.nextLine();
		while (s.length() > 0)
		{
			cube.rotateFace(s);
			cube.print();
			s = console.nextLine();
		}
		console.close();
	}
}
