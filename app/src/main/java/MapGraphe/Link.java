package MapGraphe;

/**
 * Created by Antonin on 11/12/2014.
 * Un link est un lien entre deux noeuds dans le graphe
 */
public class Link {

    private Node source;
    private Node destination;
    private int weight;

    /***
     * Un lien relie deux noeuds
     * @param s le noeud source
     * @param d le noeud destination
     * @param w le poids du lien
     */
    public Link( Node s, Node d, int w)
    {
        source = s;
        destination = d;
        weight = w;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String toString()
    {
        return source.toString() + " --> " + destination.toString();
    }
}
