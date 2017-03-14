package expressivo;

import java.io.*;

import lib6005.parser.*;

public class ParserLibTest {
    public enum IntegerGrammar {
        ROOT, ADD, EXPRESSION, INTEGER, FLOAT, VARIABLE, TIMES, WHITESPACE
    }

    public static void main(String[] args) throws FileNotFoundException, UnableToParseException, IOException {
        Parser<IntegerGrammar> parser = GrammarCompiler.compile(new File("Expression.g"), IntegerGrammar.ROOT);
        ParseTree<IntegerGrammar> tree = parser.parse("5+2+3+21");
        visitAll(tree, "");
    }

    /**
     * Traverse a parse tree, indenting to make it easier to read.
     * 
     * @param node
     *            Parse tree to print.
     * @param indent
     *            Indentation to use.
     */
    public static void visitAll(ParseTree<IntegerGrammar> node, String indent) {
        if (node.isTerminal()) {
            System.out.println(indent + node.getName() + ":" + node.getContents());
        } else {
            System.out.println(indent + node.getName());
            for (ParseTree<IntegerGrammar> child : node) {
                visitAll(child, indent + "   ");
            }
        }
    }
}
