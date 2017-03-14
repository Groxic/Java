package expressivo;

/**
 * An immutable data type representing the simplest form of an expression as a
 * character variable
 */

public class VariableExpression implements Expression {
	private char id;

	/**
	 * @param id
	 *            character to be represented as a variable for this object
	 */
	public VariableExpression(char id) {
		this.id = id;
	}

	/**
	 * @return returns the ID of this variable representation as a string
	 */
	@Override
	public String toString() {
		return "" + id;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof IntegerExpression))
			return false;
		return ((VariableExpression) other).id == this.id;
	}

	/**
	 * @return hashcode as the integer value of the variable character ID being
	 *         represented
	 */
	@Override
	public int hashCode() {
		return id;
	}
}
