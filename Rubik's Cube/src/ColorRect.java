import java.awt.Color;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class ColorRect extends Rectangle {
	public final Color COLOR;

	public Color getColor() {
		return COLOR;
	}

	public ColorRect(int x, int y, int size, Color c) {
		super(x, y, size, size);
		COLOR = c;
	}
}
