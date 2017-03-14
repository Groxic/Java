package expressivo;

import lib6005.parser.*;
import java.io.*;

/**
 * An immutable data type representing a polynomial expression of:
 *   + and *
 *   nonnegative integers and floating-point numbers
 *   variables (case-sensitive nonempty strings of letters)
 * 
 * <p>PS1 instructions: this is a required ADT interface.
 * You MUST NOT change its name or package or the names or type signatures of existing methods.
 * You may, however, add additional methods, or strengthen the specs of existing methods.
 * Declare concrete variants of Expression in their own Java source files.
 */
public interface Expression {
    enum ExpressionGrammar {
        ROOT, TIMES, ADD, EXPRESSION, INTEGER, FLOAT, VARIABLE, WHITESPACE
    };
    // Datatype definition
	// TODO
	
    /**
     * Parse an expression.
     * @param input expression to parse, as defined in the PS1 handout.
     * @return expression AST for the input
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Expression parse(String input) throws FileNotFoundException, IOException, UnableToParseException {
        Parser<ExpressionGrammar> parser = GrammarCompiler.compile(new File("IntegerExpression.g"),
                ExpressionGrammar.ROOT);
        ParseTree<ExpressionGrammar> tree = parser.parse(input);
        return buildAST(tree);
    }

    public static Expression buildAST(ParseTree<ExpressionGrammar> tree) {
        switch (tree.getName()) {
            case ROOT: {
                return buildAST(tree.childrenByName(ExpressionGrammar.EXPRESSION).get(0));
            }
            case EXPRESSION: {
                switch (tree.getName()) {
                    case INTEGER:
                        return buildAST(tree.childrenByName(ExpressionGrammar.INTEGER).get(0));
                    case FLOAT:
                        return buildAST(tree.childrenByName(ExpressionGrammar.FLOAT).get(0));
                    case VARIABLE:
                        return buildAST(tree.childrenByName(ExpressionGrammar.VARIABLE).get(0));
                    case TIMES:
                        return buildAST(tree.childrenByName(ExpressionGrammar.TIMES).get(0));
                    case ADD:
                        return buildAST(tree.childrenByName(ExpressionGrammar.ADD).get(0));
                    default:
                        break;
                }
            }
            case TIMES: {

            }
            case ADD: {

            }
            case INTEGER: {
                return new IntegerExpression(Integer.parseInt(tree.getContents()));
            }
            case FLOAT: {
                return new FloatExpression(Double.parseDouble(tree.getContents()));
            }
            case VARIABLE: {

            }
            case WHITESPACE: {
                throw new RuntimeException("You should never reach here:" + tree);
            }
        }
        throw new RuntimeException("You should never reach here:" + tree);
    }
    
    /**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override 
    public String toString();

    /**
     * @param thatObject any object
     * @return true if and only if this and thatObject are structurally-equal
     * Expressions, as defined in the PS1 handout.
     */
    @Override
    public boolean equals(Object thatObject);
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode();
    
    // TODO more instance methods
    
    /* Copyright (c) 2015-2017 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires permission of course staff.
     */
}
