import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class FaceRect extends Face<ColorRect> {

	public void paint(Graphics g, int x, int y, int STEP) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				g2d.setColor(face.get(r).get(c).getColor());
				g2d.fillRect(x + STEP * c + 1, y + r * STEP + 1, STEP - STEP / 5, STEP - STEP / 5);
			}
		}
	}

	public FaceRect(Color color, int x, int y, int SIZE_MOD) {
		int size = face.size();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < 3; c++) {
				face.get(2).set(c, new ColorRect(x + c * SIZE_MOD, y + r * SIZE_MOD, SIZE_MOD, color));
			}
		}
	}
}
