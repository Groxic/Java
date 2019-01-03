import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RectFace extends Face {
	public ColorRect[][] rectFace = new ColorRect[SIZE][SIZE];

	public void paint(Graphics2D g2d, int x, int y, int STEP) {
		// Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ColorRect colR;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				colR = rectFace[r][c];
				g2d.setColor(colR.getColor());
				g2d.fillRect(x + STEP * c + 1, y + r * STEP + 1, STEP - STEP / 5, STEP - STEP / 5);
			}
		}
	}

	@Override
	public void rotateClockWise() {
		super.rotateClockWise();
		updateAllFaces();
	}

	@Override
	public void rotateCounterClockWise() {
		super.rotateCounterClockWise();
		updateAllFaces();
	}

	private void updateAllFaces() {
		updateFace();
		((RectFace) aboveFace).updateFace();
		((RectFace) belowFace).updateFace();
		((RectFace) rightFace).updateFace();
		((RectFace) leftFace).updateFace();
	}
	
	public void updateFace() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				rectFace[i][j].setColor(getColor(face[i][j]));
			}
		}
	}

	public RectFace(char c, int x, int y, int SIZE_MOD) {
		super(c);
		Color color = getColor(c);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				rectFace[i][j] = new ColorRect(x + c * SIZE_MOD, y + i * SIZE_MOD, SIZE_MOD, color);
			}
		}
	}
}
