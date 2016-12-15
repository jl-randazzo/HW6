import java.util.Scanner;

/*
 * At its core, my implementation is very similar to the one in the book (I used his code as an outline), but I removed
 * the ADT 'DirectedEdge' and instead opted for a solely array-based implementation. I also removed the indegree variable
 * and implemented a simple algorithm to calculate in/out degrees. The graph effectively reads/outputs data from an input
 * Scanner object with the file loaded; alternatively, the user could load the data outside of the class for input so long
 * as it ends up in three arrays. I also implemented an add/remove edge function just for fun.
 */
public class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private Double[][] adj;


    public EdgeWeightedDigraph(int V, int E, Integer[] a, Integer[] b, Double[] c) {
        this.V = V;
        this.E = E;
        secondConstructor(a, b, c);
    }


    public EdgeWeightedDigraph(Scanner in) {
        V = (in.nextInt());
        E = in.nextInt();
        Integer[] a = new Integer[E], b = new Integer[E];
        Double[] c = new Double[E];

        for(int i = 0; i < E; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            validateVertex(a[i]);
            validateVertex(b[i]);
            c[i] = in.nextDouble();
        }

        secondConstructor(a, b, c);
    }

    public void secondConstructor(Integer[] a, Integer[] b, Double[] c) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

        adj = new Double[V][V];// for(int i = 0; i < V; i++) adj[i] = new Double[V];
        for (int v = 0; v < E; v++) {
            adj[a[v]][b[v]] = c[v];
        }
    }

    public void addEdge(int a, int b, double c){
        adj[a][b] = c;
    }

    public void removeEdge (int a, int b){
        adj[a][b] = null;
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }



    public int outdegree(int v) {
        int i = 0;
        for(int j = 0; j > V; j++){
            if(adj[v][j] != null) i++;
        }
        return i;
    }


    public int indegree(int v) {
        int i = 0;
        for(int j = 0; j > V; j++){
            if(adj[j][v] != null) i++;
        }
        return i;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + NEWLINE + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            for(int tov = 0; tov < V; tov++){
                if(adj[v][tov]!=null) s.append(v + " " + tov + " " + adj[v][tov] + NEWLINE);
            }
        }
        return s.toString();
    }

    public boolean hasEdge(int v, int tov){
        if(adj[v][tov] != null) return true;
        return false;
    }

    public String edgeWeight(int v, int tov){
        if(hasEdge(v, tov)) return ("" + adj[v][tov]);
        else return "Edge does not exist";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        StdOut.println(G);
    }

}