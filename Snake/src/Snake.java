import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Snake extends JPanel {
	private static final int SIZE = 30;
	private static final int SIZE_MOD = 20;
	private static final int FRAME_SIZE = SIZE * SIZE_MOD;
	private static ArrayList<Point> snakeSegments = new ArrayList<Point>();
	private static Point fruit;
	private static Random rand = new Random();
	private int dir	= 0;
	private static int sleepTime = 100;
	private static final Color bckGrnd = new Color(0, 0, 75);

	public Snake() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				moveSnake(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					escape();
				}
			}
		});
		setFocusable(true);
	}

	private void escape() {
		System.exit(0);
	}

	private boolean snakeCheck() throws InterruptedException {
		Point head = snakeSegments.get(0);
		int x = (int) head.getX();
		int y = (int) head.getY();
		if (x > FRAME_SIZE || x < 0 || y < 0 || y > FRAME_SIZE) {
			initialize();
			return true;
		}
		for (int i = 1; i < snakeSegments.size(); i++) {
			Point p = snakeSegments.get(i);
			if (p.equals(head)) {
				initialize();
				return true;
			}
		}
		return true;
	}

	private void checkEat() {
		if (snakeSegments.get(0).equals(fruit)) {
			snakeSegments.add(new Point(-SIZE_MOD, -SIZE_MOD));
			sleepTime -= 2;
			makeFruit();
		}
	}

	private static int getScore() {
		return snakeSegments.size();
	}

	private void moveSnake(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dir++;
				break;
			case KeyEvent.VK_RIGHT:
				dir--;
				break;
		}
	}

	private void moveSnake() {
		for (int i = snakeSegments.size() - 1; i > 0; i--) {
			snakeSegments.set(i, snakeSegments.get(i - 1).getLocation());
		}
		if (dir < 0) {
			dir = 3;
		}
		else if (dir > 3) {
			dir = 0;
		}
		Point p = snakeSegments.get(0);
		switch (dir) {
			case 0:
				p.translate(0, -SIZE_MOD);
				break;
			case 1:
				p.translate(-SIZE_MOD, 0);
				break;
			case 2:
				p.translate(0, SIZE_MOD);
				break;
			case 3:
				p.translate(SIZE_MOD, 0);
				break;
		}
	}

	private static void drawObjects(Graphics2D g) {
		g.setStroke(new BasicStroke(SIZE_MOD / 10));
		for (Point p : snakeSegments) {
			int x = (int) p.getX();
			int y = (int) p.getY();
			g.setColor(Color.RED);
			g.fillRect(x, y, SIZE_MOD, SIZE_MOD);
			g.setColor(bckGrnd);
			g.drawRect(x, y, SIZE_MOD, SIZE_MOD);
		}
		g.setColor(Color.GREEN);
		g.fillRect((int) fruit.getX(), (int) fruit.getY(), SIZE_MOD, SIZE_MOD);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		drawObjects(g2d);

		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Verdana", Font.BOLD, SIZE_MOD));
		g2d.drawString("" + getScore(), FRAME_SIZE - SIZE_MOD - 10, FRAME_SIZE - 20 - SIZE_MOD);

	}

	private static void makeFruit() {
		fruit = new Point((rand.nextInt(SIZE - 2) + 1)* SIZE_MOD, (rand.nextInt(SIZE - 2) + 1) * SIZE_MOD);
	}

	private void initialize() throws InterruptedException {
		makeFruit();
		snakeSegments.clear();
		snakeSegments.add(new Point((rand.nextInt(SIZE - 5) + 4) * SIZE_MOD, (rand.nextInt(SIZE - 5) + 4) * SIZE_MOD));
		sleepTime = 100;
		Thread.sleep(sleepTime * 10);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Snake Game");
		Snake game = new Snake();
		frame.add(game);
		frame.setSize(FRAME_SIZE + SIZE_MOD, FRAME_SIZE + SIZE_MOD * 2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setBackground(bckGrnd);
		game.initialize();
		while (game.snakeCheck()) {
			game.moveSnake();
			game.repaint();
			game.checkEat();
			Thread.sleep(sleepTime);
		}
	}
}
