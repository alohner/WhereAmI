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
        links = new ArrayList<Link>();
        nodes = new ArrayList<Node>();
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
        //P1 7070
        Node salle = new Node(0,"P1-7070",TypeNode.RoomClass,new Position(193,282));
        nodes.add(salle);

        //7060
        salle = new Node(0,"P1-7060",TypeNode.RoomClass,new Position(186,424));
        nodes.add(salle);

        //6280
        salle = new Node(0,"P1-6280",TypeNode.RoomClass,new Position(261,261));
        nodes.add(salle);

        //7110
        salle = new Node(0,"P1-7110",TypeNode.RoomClass,new Position(258,125));
        nodes.add(salle);

        //7120
        salle = new Node(0,"P1-7120",TypeNode.RoomClass,new Position(406,124));
        nodes.add(salle);

        //7130
        salle = new Node(0,"P1-7130",TypeNode.RoomClass,new Position(617,122));
        nodes.add(salle);

        //7140
        salle = new Node(0,"P1-7140",TypeNode.RoomClass,new Position(830,127));
        nodes.add(salle);

        //5130
        salle = new Node(0,"P1-5130",TypeNode.RoomClass,new Position(1015,126));
        nodes.add(salle);

        //5120
        salle = new Node(0,"P1-5120",TypeNode.RoomClass,new Position(1198,121));
        nodes.add(salle);

        //5110
        salle = new Node(0,"P1-5110",TypeNode.RoomClass,new Position(1410,127));
        nodes.add(salle);

        //5100
        salle = new Node(0,"P1-5100",TypeNode.RoomClass,new Position(1593,128));
        nodes.add(salle);

        //5070
        salle = new Node(0,"P1-5070",TypeNode.RoomClass,new Position(1707,128));
        nodes.add(salle);

        //5060
        salle = new Node(0,"P1-5060",TypeNode.RoomClass,new Position(1804,225));
        nodes.add(salle);

        //5050
        salle = new Node(0,"P1-5050",TypeNode.RoomClass,new Position(1807,434));
        nodes.add(salle);

        //5010
        salle = new Node(0,"P1-5010",TypeNode.RoomClass,new Position(1698,669));
        nodes.add(salle);

        //5000
        salle = new Node(0,"P1-5000",TypeNode.RoomClass,new Position(1700,785));
        nodes.add(salle);

        //6030
        salle = new Node(0,"P1-6030",TypeNode.RoomClass,new Position(1486,623));
        nodes.add(salle);

        //6110
        salle = new Node(0,"P1-6110",TypeNode.RoomClass,new Position(1223,750));
        nodes.add(salle);

        //6090
        salle = new Node(0,"P1-6090",TypeNode.RoomClass,new Position(1018,595));
        nodes.add(salle);

        //6050
        salle = new Node(0,"P1-6050",TypeNode.RoomClass,new Position(1509,523));
        nodes.add(salle);

        //6340
        salle = new Node(0,"P1-6340",TypeNode.RoomClass,new Position(1291,523));
        nodes.add(salle);

        //6130
        salle = new Node(0,"P1-6130",TypeNode.RoomClass,new Position(1075,523));
        nodes.add(salle);

        //6350
        salle = new Node(0,"P1-6350",TypeNode.RoomClass,new Position(1347,235));
        nodes.add(salle);

        //6140
        salle = new Node(0,"P1-6140",TypeNode.RoomClass,new Position(875,594));
        nodes.add(salle);

        //6150
        salle = new Node(0,"P1-6150",TypeNode.RoomClass,new Position(763,514));
        nodes.add(salle);

        //6155
        salle = new Node(0,"P1-6150",TypeNode.RoomClass,new Position(559,523));
        nodes.add(salle);

        //6220
        salle = new Node(0,"P1-6220",TypeNode.RoomClass,new Position(612,597));
        nodes.add(salle);

        //7010
        salle = new Node(0,"P1-7010",TypeNode.RoomClass,new Position(314,758));
        nodes.add(salle);

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
