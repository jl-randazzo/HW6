import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class HW6MainProgram {
    public static void main(String[] args) throws IOException {


    /*
    *  HW6
    *  4.1.4
    * Note: Used the code from the booksite and just appended on the desired method for this and the next problem.
     */
    File file = new File("tinyGex2.txt");
    Scanner sc = new Scanner(file);
    Graph graph = new Graph(sc.nextInt());
    int temp = sc.nextInt();

    for(int i = 0; i < temp; i++){
        graph.addEdge(sc.nextInt(), sc.nextInt());
    }

    sc.close();

    //here is my test client for this portion of the homework. The implementation is super simple. I did have to add a 'contains' method to Sedgwick's Bag class. Found that a bit odd, but oh well.
    System.out.println(graph.hasEdge(10, 3));
    System.out.println(graph.hasEdge(11, 1));
    System.out.println(graph.hasEdge(9, 11));
    System.out.println();

    /*
    *  HW6
    *  4.2.4
    *
     */

    file = new File("tinyDGex2.txt");
    sc = new Scanner(file);
    Digraph digraph = new Digraph(sc.nextInt());
    temp = sc.nextInt();

    for(int i = 0; i < temp; i++){
        digraph.addEdge(sc.nextInt(), sc.nextInt());
    }

    sc.close();

    //Really nothing different here. Modded the test client to make sure it was seeing that the paths only went one way. 10 and 3 are connected in both directions; 11 and 8 are not.
    System.out.println(digraph.hasEdge(10, 3));
    System.out.println(digraph.hasEdge(3, 10));
    System.out.println(digraph.hasEdge(11, 8));
    System.out.println(digraph.hasEdge(8, 11));
    System.out.println();


    /*
    *  HW6
    *  4.4.3
    * Note: Since you didn't specify which graph we should use for input, I used the edge-weighted DAG on page 658 as input
     */

    file = new File("tinyEWDAG.txt");
    sc = new Scanner(file);
    EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(sc);
    sc.close();

    //I wanted to output the list back into the input form. It's not in the same order, but it has the same values
    //saves to 'output.txt' in the root folder if you want to look at the output
    FileWriter fw = new FileWriter("output.txt");
    fw.write(ewd.toString());
    fw.close();

    System.out.println(ewd.edgeWeight(4, 0));
    System.out.println(ewd.edgeWeight(2, 3));
    System.out.println(ewd.edgeWeight(6, 2));
    System.out.println(ewd.edgeWeight(5, 4));
    }





}
