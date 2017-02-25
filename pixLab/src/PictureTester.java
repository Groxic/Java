/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public static void testKeepOnlyBlue() {
		Picture pic = new Picture("beach.jpg");
		pic.explore();
		pic.keepOnlyBlue();
		pic.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("butterfly1.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	public static void testTripleCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.tripleCollage();
		canvas.explore();
		// canvas.write("tripleCollage.jpg");
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture pic = new Picture("barbaraS.jpg");
		pic.edgeDetection(15);
		pic.explore();
		pic = new Picture("blue-mark.jpg");
		pic.edgeDetection(15);
		pic.explore();
		pic = new Picture("jenny-red.jpg");
		pic.edgeDetection(15);
		pic.explore();
	}

	public static void testEdgeDetection2() {
		Picture pic1 = new Picture("beach.jpg");
		Picture pic2 = new Picture(pic1);
		pic1.explore();
		pic1.edgeDetection(15);
		pic1.explore();
		pic2.edgeDetection2(15);
		pic2.explore();
	}

	public static void testNegate() {
		Picture pic = new Picture("beach.jpg");
		pic.explore();
		pic.negate();
		pic.explore();
	}

	public static void testGrayscale() {
		Picture pic = new Picture("water.jpg");
		pic.explore();
		pic.grayscale();
		pic.explore();
	}

	public static void testFixUnderwater() {
		Picture pic = new Picture("water.jpg");
		pic.explore();
		pic.fixUnderwater();
		pic.explore();
	}

	public static void testMirrorVerticalRightToLeft() {
		Picture pic = new Picture("butterfly1.jpg");
		pic.explore();
		pic.mirrorVerticalRightToLeft();
		pic.explore();
	}
	
	public static void testMirrorHorizontal() {
		Picture pic = new Picture("butterfly1.jpg");
		pic.explore();
		pic.mirrorHorizontal();
		pic.explore();
	}
	
	public static void testMirrorHorizontalBotToTop() {
		Picture pic = new Picture("butterfly1.jpg");
		pic.explore();
		pic.mirrorHorizontalBotToTop();
		pic.explore();
	}
	
	public static void testMirrorDiagonal() {
		Picture pic = new Picture("beach.jpg");
		pic.explore();
		pic.mirrorDiagonal();
		pic.explore();
		testMirrorDiagonalFlipped();
	}

	public static void testMirrorDiagonalFlipped() {
		Picture pic = new Picture("beach.jpg");
		pic.mirrorDiagonalFlipped();
		pic.explore();
	}

	public static void testMirrorArms() {
		Picture snowman = new Picture("snowman.jpg");
		// snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}

	public static void testMirrorGull() {
		Picture gull = new Picture("seagull.jpg");
		gull.explore();
		gull.mirrorGull();
		gull.explore();
	}

	public static void testCopy() {
		Picture pic = new Picture("beach.jpg");
		pic.copy(new Picture("flower1.jpg"), 100, 100, 0, 0, 60, 60);
		pic.copy(new Picture("flower2.jpg"), 200, 200, 50, 50, 80, 80);
		pic.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testMirrorDiagonal();
		// testMirrorDiagonalFlipped();
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorHorizontal();
		// testMirrorHorizontalBotToTop();
		// testMirrorVertical();
		// testMirrorVerticalRightToLeft();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
		// testTripleCollage();
		// testCopy();
		// testEdgeDetection();
		testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
}