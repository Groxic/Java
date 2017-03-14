package expressivo;

/**
 * An immutable data type representing an addition of two separate expressions
 */
public class AddExpression implements Expression {
	private Expression leftOp = null;
	private Expression rightOp = null;

	/**
	 * @param left
	 *            left Expression represented in this ADT
	 * @param right
	 *            right Expression represented in this ADT
	 */
	public AddExpression(Expression left, Expression right) {
		leftOp = left;
		rightOp = right;
	}

	/**
	 * @return "(" + leftExpression.toString() + " + " +
	 *         rightExpression.toString + ")"
	 */
	@Override
	public String toString() {
		return "(" + leftOp.toString() + " + " + rightOp.toString() + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AddExpression))
			return false;
		AddExpression cast = (AddExpression) other;
		return (cast.leftOp.equals(this.leftOp) && cast.rightOp.equals(this.rightOp));
	}

	/**
	 * @return hashcode representation equal to the hashcode of the left + right
	 *         expressions
	 */
	@Override
	public int hashCode() {
        return (13 * leftOp.hashCode() + 31 * rightOp.hashCode());
	}
}
