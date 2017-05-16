import java.util.ArrayList;
import java.util.Scanner;

// consider shifting array "cube" to orient cube and rename Faces: "one" ... "six" then assign connected faces to the face for modular implementation of rotation, not hardcoded
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

	// public int orient = 2; // which side is up
	// #0
	public Face<Character> G = new Face<>();
	// #1
	public Face<Character> O = new Face<>();
	// #2
	public Face<Character> W = new Face<>();
	// #3
	public Face<Character> R = new Face<>();
	// #4
	public Face<Character> Y = new Face<>();
	// #5
	public Face<Character> B = new Face<>();

	public ArrayList<Face<Character>> cube = new ArrayList<>();

	// public Face<Character>[] cube = (Face<Character>[]) new Object[] { G, O,
	// W, R, Y, B };

	public RubiksCube() {
		cube.add(G);
		cube.add(O);
		cube.add(W);
		cube.add(R);
		cube.add(Y);
		cube.add(B);
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
		System.out.println();
	}

	public void rotateFace(String s) {
		char end = s.charAt(s.length() - 1);
		int faceNum = getIndexFromCenter(s.charAt(0));
		if (end == '\'')
		{
			cube.get(faceNum).rotateCounterClockWise();
		}
		else
		{
			cube.get(faceNum).rotateClockWise();
		}
	}

	public Face<Character> get(int i) {
		return cube.get(i);
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
