import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	public void fixUnderwater() {
		Pixel[] pixels = this.getPixels();
		for (Pixel obj : pixels) {
			obj.setRed(obj.getRed() * 4);
		}
	}

	public void grayscale() {
		Pixel[] pixels = this.getPixels();
		int average = 0;
		for (Pixel obj : pixels) {
			average = (obj.getRed() + obj.getGreen() + obj.getBlue()) / 3;
			obj.setColor(new Color(average, average, average));
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel obj : row) {
				obj.setRed(255 - obj.getRed());
				obj.setGreen(255 - obj.getGreen());
				obj.setBlue(255 - obj.getGreen());
			}
		}
	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel obj : row) {
				obj.setRed(0);
				obj.setGreen(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}
	
	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel top = null;
		Pixel bot = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++) {
			for (int row = 0; row < height / 2; row++) {
				top = pixels[row][col];
				bot = pixels[height - 1 - row][col];
				bot.setColor(top.getColor());
			}
		}
	}
	
	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel top = null;
		Pixel bot = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++) {
			for (int row = 0; row < height / 2; row++) {
				top = pixels[row][col];
				bot = pixels[height - 1 - row][col];
				top.setColor(bot.getColor());
			}
		}
	}
	
	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel top = null;
		Pixel bot = null;

		int max = pixels.length;
		if (pixels[0].length < max) {
			max = pixels[0].length;
		}

		for (int row = 0; row < max; row++) {
			for (int col = 0; col < pixels.length; col++) {
				top = pixels[row][col];
				bot = pixels[col][row];
				top.setColor(bot.getColor());
			}
		}
	}

	public void mirrorDiagonalFlipped() {
		Pixel[][] pixels = this.getPixels2D();

		Pixel top = null;
		Pixel bot = null;

		int max = pixels.length;
		if (pixels[0].length < max) {
			max = pixels[0].length;
		}

		for (int row = 0; row < max; row++) {
			for (int col = 0; col < pixels.length; col++) {
				top = pixels[row][col];
				bot = pixels[col][row];
				bot.setColor(top.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		// int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		int count = 0;

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.println(count);
	}

	public void mirrorArms() {
		Pixel topPixel = null;
		Pixel botPixel = null;

		Pixel[][] pixels = this.getPixels2D();

		for (int row = 159; row < 191; row++) {
			for (int col = 105; col < 170; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[191 - row + 191][col];
				botPixel.setColor(topPixel.getColor());
			}
		}

		for (int row = 172; row < 196; row++) {
			for (int col = 239; col < 294; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[196 - row + 189][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		Pixel left = null;
		Pixel right = null;

		Pixel[][] pixels = this.getPixels2D();

		for (int row = 235; row < 320; row++) {
			for (int col = 238; col < 344; col++) {
				left = pixels[row][col];
				right = pixels[row][344 - col + 344];
				right.setColor(left.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/**
	 * 
	 * @param fromPic
	 *            pic to copy from
	 * @param startRow
	 *            row to copy to
	 * @param startCol
	 *            col to copy to
	 * @param fromRow
	 *            row to copy from fromPic
	 * @param fromCol
	 *            col to copy from fromPic
	 * @param endRow
	 *            end row to copy from
	 * @param endCol
	 *            end col to copy from
	 */
	public void copy(Picture fromPic, int startRow, int startCol, int row, int col, int endRow, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = row, toRow = startRow; fromRow < endRow
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = col, toCol = startCol; fromCol < endCol
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		// this.write("collage.jpg");
	}

	public void tripleCollage() {
		Picture person1 = new Picture("jenny-red.jpg");
		Picture person2 = new Picture("blue-mark.jpg");
		Picture person3 = new Picture("barbaraS.jpg");
		person2 = person2.scale(0.75, 0.75);
		this.copy(person1, 0, 0);
		this.copy(person2, this.getHeight() / 3, 0);
		this.copy(person3, this.getHeight() / 3 * 2, 0);
		person1.negate();
		person2.keepOnlyBlue();
		person3.fixUnderwater();
		this.copy(person1, 0, 100);
		this.copy(person2, this.getHeight() / 3, 100);
		this.copy(person3, this.getHeight() / 3 * 2, 100);
		this.mirrorVertical();
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void edgeDetection2(int edgeDist) {
		Pixel top = null;
		Pixel bot = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				top = pixels[row][col];
				bot = pixels[row + 1][col];
				if (top.colorDistance(bot.getColor()) > edgeDist) {
					top.setColor(Color.BLACK);
				}
				else {
					top.setColor(Color.WHITE);
				}
			}
		}
	}
} // this } is the end of class Picture, put all new methods before this
