package MapGraphe;

/**
 * Created by Antonin on 11/12/2014.
 * Un link est un lien entre deux noeuds dans le graphe
 */
public class Link {

    private int ID;
    private Node source;
    private Node destination;
    private int weight;

    /***
     * Un lien relie deux noeuds
     * @param id son identifiant
     * @param s le noeud source
     * @param d le noeud destination
     * @param w le poids du lien
     */
    public Link(int id, Node s, Node d, int w)
    {
        ID = id;
        source = s;
        destination = d;
        weight = w;
    }

    public int getID() {
        return ID;
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
