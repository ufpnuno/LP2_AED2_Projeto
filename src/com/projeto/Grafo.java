package com.projeto;


import java.util.ArrayList;

public class Grafo {
    public Grafo(ArrayList<Ways> edges, ArrayList<Nodes> vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }
    //OLA DANIEL

    public ArrayList<Ways> edges;

    public ArrayList<Nodes> vertices;


    @Override
    public String toString() {
        return "Grafo{" +
                "edges=" + edges +
                ", vertices=" + vertices +
                '}' + "\n";
    }

    public ArrayList<Ways> getEdges() {

        return edges;
    }

    public void setEdges(Ways edges) {
        this.edges.add(edges);
    }

    public ArrayList<Nodes> getVertices() {
        return vertices;
    }

    public void setVertices(Nodes vertices) {
        this.vertices.add(vertices);
    }
}