import java.awt.Color;
import java.util.Arrays;

// TODO: Codereview
public class Face {
	protected final int SIZE = 3;
	public char[][] face = new char[SIZE][SIZE];
	private Face aboveFace;
	private Face belowFace;
	private Face leftFace;
	private Face rightFace;

	public Face(char c) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				face[i][j] = c;
			}
		}
	}

	public static Color getColor(char c) {
		switch (c) {
			case 'g': {
				return Color.GREEN;
			}
			case 'o': {
				return Color.ORANGE;
			}
			case 'w': {
				return Color.WHITE;
			}
			case 'r': {
				return Color.RED;
			}
			case 'y': {
				return Color.YELLOW;
			}
			case 'b': {
				return Color.BLUE;
			}
			default: {
				return Color.WHITE;
			}
		}
	}

	public void setAbove(Face f) {
		aboveFace = f;
	}

	public void setBelow(Face f) {
		belowFace = f;
	}

	public void setLeft(Face f) {
		leftFace = f;
	}

	public void setRight(Face f) {
		rightFace = f;
	}

	public void rotateClockWise() {
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

		switch (face[1][1]) {
			case 'w': {
				char[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', leftFace.getSide('r'), true);
				leftFace.setSide('r', belowFace.getSide('t'), false);
				belowFace.setSide('t', rightFace.getSide('l'), true);
				rightFace.setSide('l', tempArr, false);
				break;
			}
			case 'y': {
				char[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', leftFace.getSide('r'), false);
				leftFace.setSide('r', belowFace.getSide('b'), true);
				belowFace.setSide('b', rightFace.getSide('l'), false);
				rightFace.setSide('l', tempArr, true);
				break;
			}
			case 'g': {
				char[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', leftFace.getSide('t'), false);
				leftFace.setSide('t', belowFace.getSide('t'), false);
				belowFace.setSide('t', rightFace.getSide('t'), false);
				rightFace.setSide('t', tempArr, false);
				break;
			}
			case 'b': {
				char[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', leftFace.getSide('b'), false);
				leftFace.setSide('b', belowFace.getSide('b'), false);
				belowFace.setSide('b', rightFace.getSide('b'), false);
				rightFace.setSide('b', tempArr, false);
				break;
			}
			case 'o': {
				char[] tempArr = aboveFace.getSide('l');
				aboveFace.setSide('l', leftFace.getSide('r'), true);
				leftFace.setSide('r', belowFace.getSide('l'), true);
				belowFace.setSide('l', rightFace.getSide('l'), false);
				rightFace.setSide('l', tempArr, false);
				break;
			}
			case 'r': {
				char[] tempArr = aboveFace.getSide('r');
				aboveFace.setSide('r', leftFace.getSide('r'), false);
				leftFace.setSide('r', belowFace.getSide('r'), false);
				belowFace.setSide('r', rightFace.getSide('l'), true);
				rightFace.setSide('l', tempArr, true);
				break;
			}
		}
	}

	public void rotateCounterClockWise() {
		char temp = face[0][0];
		char temp2 = face[0][1];
		face[0][0] = face[0][2];
		face[0][1] = face[1][2];
		face[0][2] = face[2][2];
		face[1][2] = face[2][1];
		face[2][2] = face[2][0];
		face[2][1] = face[1][0];
		face[2][0] = temp;
		face[1][0] = temp2;

		switch (face[1][1]) {
			case 'w': {
				char[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', rightFace.getSide('l'), false);
				rightFace.setSide('l', belowFace.getSide('t'), true);
				belowFace.setSide('t', leftFace.getSide('r'), false);
				leftFace.setSide('r', tempArr, true);
				break;
			}
			case 'y': {
				char[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', rightFace.getSide('l'), true);
				rightFace.setSide('l', belowFace.getSide('b'), false);
				belowFace.setSide('b', leftFace.getSide('r'), true);
				leftFace.setSide('r', tempArr, false);
				break;
			}
			case 'g': {
				char[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', rightFace.getSide('t'), false);
				rightFace.setSide('t', belowFace.getSide('t'), false);
				belowFace.setSide('t', leftFace.getSide('t'), false);
				leftFace.setSide('t', tempArr, false);
				break;
			}
			case 'b': {
				char[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', rightFace.getSide('b'), false);
				rightFace.setSide('b', belowFace.getSide('b'), false);
				belowFace.setSide('b', leftFace.getSide('b'), false);
				leftFace.setSide('b', tempArr, false);
				break;
			}
			case 'o': {
				char[] tempArr = aboveFace.getSide('l');
				aboveFace.setSide('l', rightFace.getSide('l'), false);
				rightFace.setSide('l', belowFace.getSide('l'), false);
				belowFace.setSide('l', leftFace.getSide('r'), true);
				leftFace.setSide('r', tempArr, true);
				break;
			}
			case 'r': {
				char[] tempArr = aboveFace.getSide('r');
				aboveFace.setSide('r', rightFace.getSide('l'), true);
				rightFace.setSide('l', belowFace.getSide('r'), true);
				belowFace.setSide('r', leftFace.getSide('r'), false);
				leftFace.setSide('r', tempArr, false);
				break;
			}
		}
	}

	public void print(String prefix) {
		for (char[] r : face) {
			System.out.print(prefix);
			for (char c : r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public void printRow(int rNum) {
		for (char c : face[rNum])
		{
			System.out.print(c + " ");
		}
	}

	public void setSide(char side, char[] to, boolean reverse) {
		if (reverse)
		{
			for (int i = 0; i < to.length / 2; i++)
			{
				char temp = to[i];
				to[i] = to[to.length - 1 - i];
				to[to.length - 1 - i] = temp;
			}
		}
		switch (side) {
			case 't': {
				face[0] = to;
				break;
			}
			case 'b': {
				face[SIZE - 1] = to;
				break;
			}
			case 'l': {
				int i = 0;
				for (char c : to)
				{
					face[i][0] = c;
					i++;
				}
				break;
			}
			case 'r': {
				int i = 0;
				for (char c : to)
				{
					face[i][SIZE - 1] = c;
					i++;
				}
				break;
			}
			default:
				break;
		}
	}

	public char[] getSide(char s) {
		switch (s) {
			case 't': {
				return Arrays.copyOf(face[0], face[0].length);
			}
			case 'b': {
				return Arrays.copyOf(face[SIZE - 1], face[0].length);
			}
			case 'l': {
				char[] arr = new char[SIZE];
				for (int r = 0; r < SIZE; r++)
				{
					arr[r] = face[r][0];
				}
				return arr;

			}
			case 'r': {
				char[] arr = new char[SIZE];
				for (int r = 0; r < SIZE; r++)
				{
					arr[r] = face[r][SIZE - 1];
				}
				return arr;
			}
		}
		return null;
	}
}
