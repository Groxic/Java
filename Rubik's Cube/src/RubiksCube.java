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

	public Face[] cube = new Face[] { G, O, W, R, Y, B };

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
				"Enter the center letter of the face you want to rotate clockwise (include \"\'\" to reverse rotation, enter to exit)");
		return new Scanner(System.in);
	}

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
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
