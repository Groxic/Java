import java.util.ArrayList;

public class Face<E> {
	public ArrayList<ArrayList<E>> face;
	private Face<E> aboveFace;
	private Face<E> belowFace;
	private Face<E> leftFace;
	private Face<E> rightFace;

	public Face() {}

	public Face(E c) {
		face = new ArrayList<ArrayList<E>>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				face.get(i).set(j, c);
			}
		}
	}

	public void setAbove(Face<E> f) {
		aboveFace = f;
	}

	public void setBelow(Face<E> f) {
		belowFace = f;
	}

	public void setLeft(Face<E> f) {
		leftFace = f;
	}

	public void setRight(Face<E> f) {
		rightFace = f;
	}

	public void rotateClockWise() {
		E temp = face.get(0).get(0);
		E temp2 = face.get(1).get(0);
		face.get(0).set(0, face.get(2).get(0));
		face.get(1).set(0, face.get(2).get(1));
		face[2][0] = face[2][2];
		face[2][1] = face[1][2];
		face[2][2] = face[0][2];
		face[1][2] = face[0][1];
		face[0][2] = temp;
		face[0][1] = temp2;

		switch ((char) face[1][1]) {
			case 'w': {
				E[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', leftFace.getSide('r'), true);
				leftFace.setSide('r', belowFace.getSide('t'), false);
				belowFace.setSide('t', rightFace.getSide('l'), true);
				rightFace.setSide('l', tempArr, false);
				break;
			}
			case 'y': {
				E[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', leftFace.getSide('r'), false);
				leftFace.setSide('r', belowFace.getSide('b'), true);
				belowFace.setSide('b', rightFace.getSide('l'), false);
				rightFace.setSide('l', tempArr, true);
				break;
			}
			case 'g': {
				E[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', leftFace.getSide('t'), false);
				leftFace.setSide('t', belowFace.getSide('t'), false);
				belowFace.setSide('t', rightFace.getSide('t'), false);
				rightFace.setSide('t', tempArr, false);
				break;
			}
			case 'b': {
				E[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', leftFace.getSide('b'), false);
				leftFace.setSide('b', belowFace.getSide('b'), false);
				belowFace.setSide('b', rightFace.getSide('b'), false);
				rightFace.setSide('b', tempArr, false);
				break;
			}
			case 'o': {
				E[] tempArr = aboveFace.getSide('l');
				aboveFace.setSide('l', leftFace.getSide('r'), true);
				leftFace.setSide('r', belowFace.getSide('l'), true);
				belowFace.setSide('l', rightFace.getSide('l'), false);
				rightFace.setSide('l', tempArr, false);
				break;
			}
			case 'r': {
				E[] tempArr = aboveFace.getSide('r');
				aboveFace.setSide('r', leftFace.getSide('r'), false);
				leftFace.setSide('r', belowFace.getSide('r'), false);
				belowFace.setSide('r', rightFace.getSide('l'), true);
				rightFace.setSide('l', tempArr, true);
				break;
			}
		}
	}

	public void rotateCounterClockWise() {
		E temp = face[0][0];
		E temp2 = face[0][1];
		face[0][0] = face[0][2];
		face[0][1] = face[1][2];
		face[0][2] = face[2][2];
		face[1][2] = face[2][1];
		face[2][2] = face[2][0];
		face[2][1] = face[1][0];
		face[2][0] = temp;
		face[1][0] = temp2;

		switch ((char) face[1][1]) {
			case 'w': {
				E[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', rightFace.getSide('l'), false);
				rightFace.setSide('l', belowFace.getSide('t'), true);
				belowFace.setSide('t', leftFace.getSide('r'), false);
				leftFace.setSide('r', tempArr, true);
				break;
			}
			case 'y': {
				E[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', rightFace.getSide('l'), true);
				rightFace.setSide('l', belowFace.getSide('b'), false);
				belowFace.setSide('b', leftFace.getSide('r'), true);
				leftFace.setSide('r', tempArr, false);
				break;
			}
			case 'g': {
				E[] tempArr = aboveFace.getSide('t');
				aboveFace.setSide('t', rightFace.getSide('t'), false);
				rightFace.setSide('t', belowFace.getSide('t'), false);
				belowFace.setSide('t', leftFace.getSide('t'), false);
				leftFace.setSide('t', tempArr, false);
				break;
			}
			case 'b': {
				E[] tempArr = aboveFace.getSide('b');
				aboveFace.setSide('b', rightFace.getSide('b'), false);
				rightFace.setSide('b', belowFace.getSide('b'), false);
				belowFace.setSide('b', leftFace.getSide('b'), false);
				leftFace.setSide('b', tempArr, false);
				break;
			}
			case 'o': {
				E[] tempArr = aboveFace.getSide('l');
				aboveFace.setSide('l', rightFace.getSide('l'), false);
				rightFace.setSide('l', belowFace.getSide('l'), false);
				belowFace.setSide('l', leftFace.getSide('r'), true);
				leftFace.setSide('r', tempArr, true);
				break;
			}
			case 'r': {
				E[] tempArr = aboveFace.getSide('r');
				aboveFace.setSide('r', rightFace.getSide('l'), true);
				rightFace.setSide('l', belowFace.getSide('r'), true);
				belowFace.setSide('r', leftFace.getSide('r'), false);
				leftFace.setSide('r', tempArr, false);
				break;
			}
		}
	}

	public void print(String prefix) {
		for (ArrayList<E> r : face) {
			System.out.print(prefix);
			for (E c : r) {
				System.out.print(c + " ");
			}
			if (!r.equals(face.get(2)))
			{
				System.out.println();
			}
		}
	}

	public void printRow(int rNum) {
		for (E c : face.get(rNum))
		{
			System.out.print(c + " ");
		}
	}

	public void setSide(char side, ArrayList<E> to, boolean reverse) {
		if (reverse)
		{
			int size = 3;
			for (int i = 0; i < size / 2; i++)
			{
				E temp = to.get(i);
				to.set(i, to.get(size - 1 - i));
				to.set(size - 1 - i, temp);
			}
		}
		switch (side) {
			case 't': {
				face.set(0, to);
				break;
			}
			case 'b': {
				face.set(2, to);
				break;
			}
			case 'l': {
				int i = 0;
				for (E c : to)
				{
					face.get(i).set(0, c);
					i++;
				}
				break;
			}
			case 'r': {
				int i = 0;
				for (E c : to)
				{
					face.get(i).set(2, c);
					i++;
				}
				break;
			}
			default:
				break;
		}
	}

	public ArrayList<E> getSide(char s) {
		switch (s) {
			case 't': {
				return new ArrayList<E>(face.get(0));
			}
			case 'b': {
				return new ArrayList<E>(face.get(2));
			}
			case 'l': {
				ArrayList<E> arr = new ArrayList<E>(3);
				for (int r = 0; r < 3; r++)
				{
					arr.set(r, face.get(r).get(0));
				}
				return arr;

			}
			case 'r': {
				ArrayList<E> arr = new ArrayList<E>(3);
				for (int r = 0; r < 3; r++)
				{
					arr.set(r, face.get(r).get(2));
				}
				return arr;
			}
		}
		return null;
	}
}
