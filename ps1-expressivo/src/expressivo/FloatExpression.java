package expressivo;

/**
 * An immutable data type representing the simple form of an expression as a
 * double
 */

public class FloatExpression implements Expression {
	private double num;

	/**
	 * @param num
	 *            double to be represented by this object
	 */
	public FloatExpression(double num) {
		this.num = num;
	}

	/**
	 * @return a string version of the double represented
	 */
	@Override
	public String toString() {
		return "" + num;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof FloatExpression))
			return false;
		return ((FloatExpression) other).num == this.num;
	}

	/**
	 * @return hashcode equal to the double represented
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(num);
	}
}
