package graph;

import java.util.List;

//We have a directed graph storing relationships between different objects, identify if there a cycle in a graph

/*
 * a->b<--c
|             ^
 \>d->e-|

vertices: {a, b, c, d, e}
edges: {{a, b}, {c, b}, {a, d}, {d, e}, {e, c}}
 */

public class Testing2 {
    class Vertex {
        String id;
    }

    class Edge {
        Vertex from, to;
    }

    class Graph {
        List<Vertex> vertices;
        List<Edge> edges;
    }

    public boolean isCyclic(Graph graph) {
        return true;
    }
}
