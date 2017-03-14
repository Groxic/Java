// Variation of GoNorthEast that produces a dot file for graphviz

import java.util.*;
import java.io.*;

public class MakeDot5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Target x and y location? ");
        int x = console.nextInt();
        int y = console.nextInt();
        System.out.println();
        solve(x, y);
        console.close();
    }

    private static void explore(int currX, int currY, int x, int y,
                                String path, 
                                PrintStream output, String oldDot, 
                                String indent) {
        String coords = "(" + currX + ", " + currY + ")";
        String newDot;
        if (oldDot.isEmpty()) {
            newDot = "\"start\\n(0, 0)\"";
        } else {
            newDot = "\"" + path.trim() + "\\n" + coords + "\"";
            output.println(indent + oldDot + " -> " + newDot);
            indent += "    ";
        }
        if (currX == x && currY == y) {
	    System.out.println(path);
            output.println(newDot + " [color=blue fontcolor=red]");
	} else if (currX <= x && currY <= y) {
	    explore(currX, currY + 1, x, y,
                    path + " N", output, newDot, indent);
	    explore(currX + 1, currY, x, y,
                    path + " E", output, newDot, indent);
	    explore(currX + 1, currY + 1,  x, y,
                    path + " NE", output, newDot, indent);
	}
    }

    public static void solve(int x, int y) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("ne5.dot"));
        output.println("digraph {");
	System.out.println("solutions:");
        explore(0, 0, x, y, "", output, "", "    ");
        output.println("}");
    }
}