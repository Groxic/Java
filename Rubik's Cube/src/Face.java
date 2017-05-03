// TODO: add communication between faces
public class Face {
	public char[][] face;
	private Face aboveFace;
	private Face belowFace;
	private Face leftFace;
	private Face rightFace;

	public Face(char c) {
		face = new char[][] {
			{ c, c, c },
			{ c, c, c },
			{ c, c, c }
		};
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

	}

	public void print(String prefix) {
		for (char[] r : face) {
			System.out.print(prefix);
			for (char c : r) {
				System.out.print(c + " ");
			}
			if (r != face[2])
			{
				System.out.println();
			}
		}
	}

	public void printRow(int rNum) {
		for (char c : face[rNum])
		{
			System.out.print(c + " ");
		}
	}

	/*private void setSide(char side, char[] to) {
		switch (side) {
			case 't': {
				face[0] = to;
				break;
			}
			case 'b': {
				face[face.length - 1] = to;
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
					face[i][face.length - 1] = c;
					i++;
				}
				break;
			}
			default:
				break;
		}
	}
	 */

	/*private char[] getSide(char s) {
		switch (s) {
			case 't': {
				return Arrays.copyOf(face[0], face[0].length);
			}
			case 'b': {
				return Arrays.copyOf(face[face.length - 1], face[0].length);
			}
			case 'l': {
				char[] arr = new char[face.length];
				for (int r = 0; r < face.length; r++)
				{
					arr[r] = face[r][0];
				}
				return arr;

			}
			case 'r': {
				char[] arr = new char[3];
				for (int r = 0; r < face.length; r++)
				{
					arr[r] = face[r][face.length - 1];
				}
				return arr;
			}
		}
		return null;
	}*/

	public static void main(String[] args) {
		Face f = new Face('c');
		f.print("");
		f.rotateClockWise();
		f.print("\t");
		f.rotateCounterClockWise();
		f.print("\t\t");
		f.rotateCounterClockWise();
		f.print("\t\t\t");
	}
}