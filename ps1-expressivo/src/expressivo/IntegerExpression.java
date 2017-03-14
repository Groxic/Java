package expressivo;

/**
 * An immutable data type representing the simplest form of an expression as an
 * integer
 */

public class IntegerExpression implements Expression {
	private int integer;

	/**
	 * @param value
	 *            integer value to be represented by this object
	 */
	public IntegerExpression(int value) {
		integer = value;
	}

	/**
	 * @return the integer expression represented by this object as a string
	 */
	@Override
	public String toString() {
		return "" + integer;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof IntegerExpression))
			return false;
		return ((IntegerExpression) other).integer == this.integer;
	}

	/**
	 * @return hashcode equal to the integer being represented
	 */
	@Override
	public int hashCode() {
        return integer;
	}
}
