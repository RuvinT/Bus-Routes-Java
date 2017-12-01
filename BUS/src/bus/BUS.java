/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

/**
 *
 * @author Ruvin Thulana
 */
// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class BUS
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            vertexQueue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            vertexQueue.add(v);
        }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertex A = new Vertex("Dehiwala");
        
        Vertex B = new Vertex("Kohuwala");
        Vertex C = new Vertex("SBC");
        Vertex D = new Vertex("Nugegoda");
        Vertex E = new Vertex("Borella Cemetry");
        Vertex F = new Vertex("Wellawatta");
        Vertex G = new Vertex("Horton place");
        Vertex H = new Vertex("Public library");
        Vertex I = new Vertex("Boralla");
        Vertex J = new Vertex("Gangarama");
        Vertex K = new Vertex("Slave island");
          
        Vertex L = new Vertex("Town Hall");
        Vertex M = new Vertex("Kirulapane");
        Vertex N = new Vertex("Pamankada");
        Vertex O = new Vertex("Narahempita");
        Vertex P = new Vertex("Thibirigasyaya");
        Vertex Q = new Vertex("Bambalapitiya");
        Vertex R = new Vertex("Kollupitiya");
        Vertex S = new Vertex("Galle Face");
        Vertex T = new Vertex("Town Hall");
        Vertex U = new Vertex("Pettah");
        Vertex V = new Vertex("Matrdana");
        Vertex W = new Vertex("Fort");
        Vertex X = new Vertex("Gamini Hall");
        Vertex Z = new Vertex("Colombo Campus");

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(F, 2.6) };
        F.adjacencies = new Edge[]{ new Edge(N, 1.3) };
        F.adjacencies = new Edge[]{ new Edge(Q, 2.3) };
        F.adjacencies = new Edge[]{ new Edge(K, 23) };
        K.adjacencies = new Edge[]{ new Edge(O, 40) };
        J.adjacencies = new Edge[]{ new Edge(K, 25) };
        M.adjacencies = new Edge[]{ new Edge(R, 8) };
        O.adjacencies = new Edge[]{ new Edge(K, 40) };
        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
        R.adjacencies = new Edge[]{ new Edge(P, 15) };
        Z.adjacencies = new Edge[]{ new Edge(P, 18) };


        computePaths(M); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + R.minDistance);
        List<Vertex> path = getShortestPathTo(R);
        System.out.println("Path: " + path);
    }
}