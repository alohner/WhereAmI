package MapGraphe;

import java.util.ArrayList;

/**
 * Created by Antonin on 11/12/2014.
 * Graphe représentant la carte
 */
public class Graph {

    private ArrayList<Link> links;
    private ArrayList<Node> nodes;

    public Graph()
    {
        autoInit();
    }

    public Graph(ArrayList<Link> l,ArrayList<Node> n)
    {
        links=l;
        nodes=n;
    }


    public ArrayList<Link> getLinks() {
        return links;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addLink(Link l)
    {
        links.add(l);
    }

    public void addNode(Node n)
    {
        nodes.add(n);
    }

    /**
     * Permet d'initialiser le graphe avec les données de la carte
     * Note :il faudrait mettre une lecture d'un fichier xml à l avenir
     */
    private void autoInit()
    {
        nodes = new ArrayList<Node>();
        //Ajout des points d'intérêts
        //P1 1010
        Node salle1 = new Node(0,"P1-1010",TypeNode.RoomClass,new Position(100,100));
        nodes.add(salle1);
    }

    /****
     * Permet d'obtenir un noeud dans la carte si il existe avec son nom
     * @param name nom du point sur la carte
     * @return null si n'existe pas, le noeud sinon
     */
    public Node getNodeWithName(String name)
    {
        //parcours de la map
        for (Node n : nodes)
        {
            if (n.getName().equals(name))
            {
                return n;
            }
        }
        return null;
    }
}
