import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

// https://docs.oracle.com/javase/tutorial/2d/advanced/user.html
//TODO: Codereview from other people

@SuppressWarnings("serial")
public class CubeHandler extends Canvas { // implements MouseListener, MouseMotionListener {
	RubiksCube cube;
	private static int SIZE_MOD = 40;
	private static Color BACK_GND = Color.BLACK;
	// private Point mousePt;

	public CubeHandler() {
		cube = new RubiksCube(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		setBackground(BACK_GND);
		RectFace face = (RectFace) cube.get(0);
		face.paint(g2d, 3 * SIZE_MOD, 0, SIZE_MOD);
		for (int i = 1; i < 6; i++) {
			face = (RectFace) cube.get(i);
			face.paint(g2d, SIZE_MOD * 3 * (i - 1), 3 * SIZE_MOD, SIZE_MOD);
		}
		face = (RectFace) cube.get(5);
		face.paint(g2d, 3 * SIZE_MOD, 6 * SIZE_MOD, SIZE_MOD);
	}

	/*@Override
	public void mouseDragged(MouseEvent e) {
		/*int dx = (int) (e.getX() - mousePt.getX());
		int dy = (int) (e.getY() - mousePt.getY());
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
		/*mousePt = e.getPoint();
		Object cR = e.getSource();
		if (cR instanceof ColorRect) {
			System.out.println("yes");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}*/

	public static void main(String[] args) {
		CubeHandler h = new CubeHandler();
		RubiksCube cube = h.cube;
		JFrame f = new JFrame("Rubik's Cube");
		f.add(h);
		f.setResizable(false);
		f.setSize(12 * SIZE_MOD, 13 * SIZE_MOD);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		Scanner console = RubiksCube.intro(cube);
		String s = console.nextLine();
		while (s.length() > 0)
		{
			cube.rotateFace(s);
			h.repaint();
			cube.print();
			s = console.nextLine();
		}
		console.close();
	}
}
