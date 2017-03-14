package expressivo;

/**
 * An immutable data type representing a multiplication of two separate
 * expressions
 */
public class MultiplyExpression implements Expression {
	private Expression leftOp = null;
	private Expression rightOp = null;

	/**
	 * @param left
	 *            left Expression represented in this ADT
	 * @param right
	 *            right Expression represented in this ADT
	 */
	public MultiplyExpression(Expression left, Expression right) {
		leftOp = left;
		rightOp = right;
	}

	/**
	 * @return "(" + leftExpression.toString() + " * " +
	 *         rightExpression.toString + ")"
	 */
	@Override
	public String toString() {
		return "(" + leftOp.toString() + " * " + rightOp.toString() + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof MultiplyExpression))
			return false;
		MultiplyExpression cast = (MultiplyExpression) other;
		return (cast.leftOp.equals(this.leftOp) && cast.rightOp.equals(this.rightOp));
	}

	/**
	 * @return the addition of the hashcodes for the left and right expressions
	 */
	@Override
	public int hashCode() {
        return (31 * leftOp.hashCode() * 13 * rightOp.hashCode());
	}
}
