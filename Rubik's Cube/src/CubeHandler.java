import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

// https://docs.oracle.com/javase/tutorial/2d/advanced/user.html

@SuppressWarnings("serial")
public class CubeHandler extends Canvas implements MouseListener, MouseMotionListener {
	public static RubiksCube cube = new RubiksCube();
	public static int SIZE_MOD = 40;
	public static Color BACK_GND = Color.BLACK;

	public CubeHandler() {

	}

	@Override
	public void paint(Graphics g) {
		setBackground(BACK_GND);
		cube.get(0).paint(g, 3 * SIZE_MOD, 0, SIZE_MOD);
		for (int i = 1; i < 6; i++) {
			cube.get(i).paint(g, SIZE_MOD * 3 * (i - 1), 3 * SIZE_MOD, SIZE_MOD);
		}
		cube.get(5).paint(g, 3 * SIZE_MOD, 6 * SIZE_MOD, SIZE_MOD);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public static void main(String[] args) {
		CubeHandler h = new CubeHandler();
		JFrame f = new JFrame();
		f.add(h);
		f.setResizable(false);
		f.setSize(12 * SIZE_MOD, 13 * SIZE_MOD);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}