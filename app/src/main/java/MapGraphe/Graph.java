package MapGraphe;

import java.util.ArrayList;

/**
 * Created by Antonin on 11/12/2014.
 * Graphe représentant la carte
 */
public class Graph{

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
        Node p7070 = new Node(0,"P1-7070",TypeNode.RoomClass,new Position(193,282));
        nodes.add(p7070);

        //7060
        Node p7060 = new Node(0,"P1-7060",TypeNode.RoomClass,new Position(186,424));
        nodes.add(p7060);

        //6280
        Node p6280 = new Node(0,"P1-6280",TypeNode.RoomClass,new Position(261,261));
        nodes.add(p6280);

        //7110
        Node p7110 = new Node(0,"P1-7110",TypeNode.RoomClass,new Position(258,125));
        nodes.add(p7110);

        //7120
        Node p7120 = new Node(0,"P1-7120",TypeNode.RoomClass,new Position(406,124));
        nodes.add(p7120);

        //7130
        Node p7130 = new Node(0,"P1-7130",TypeNode.RoomClass,new Position(617,122));
        nodes.add(p7130);

        //7140
        Node p7140 = new Node(0,"P1-7140",TypeNode.RoomClass,new Position(830,127));
        nodes.add(p7140);

        //5130
        Node p5130 = new Node(0,"P1-5130",TypeNode.RoomClass,new Position(1015,126));
        nodes.add(p5130);

        //5120
        Node p5120 = new Node(0,"P1-5120",TypeNode.RoomClass,new Position(1198,121));
        nodes.add(p5120);

        //5110
        Node p5110 = new Node(0,"P1-5110",TypeNode.RoomClass,new Position(1410,127));
        nodes.add(p5110);

        //5100
        Node p5100 = new Node(0,"P1-5100",TypeNode.RoomClass,new Position(1593,128));
        nodes.add(p5100);

        //5070
        Node p5070 = new Node(0,"P1-5070",TypeNode.RoomClass,new Position(1707,128));
        nodes.add(p5070);

        //5060
        Node p5060 = new Node(0,"P1-5060",TypeNode.RoomClass,new Position(1804,225));
        nodes.add(p5060);

        //5050
        Node p5050 = new Node(0,"P1-5050",TypeNode.RoomClass,new Position(1807,434));
        nodes.add(p5050);

        //5010
        Node p5010 = new Node(0,"P1-5010",TypeNode.RoomClass,new Position(1698,669));
        nodes.add(p5010);

        //5000
        Node p5000 = new Node(0,"P1-5000",TypeNode.RoomClass,new Position(1700,785));
        nodes.add(p5000);

        //6030
        Node p6030 = new Node(0,"P1-6030",TypeNode.RoomClass,new Position(1486,623));
        nodes.add(p6030);

        //6110
        Node p6110 = new Node(0,"P1-6110",TypeNode.RoomClass,new Position(1223,750));
        nodes.add(p6110);

        //6090
        Node p6090 = new Node(0,"P1-6090",TypeNode.RoomClass,new Position(1018,595));
        nodes.add(p6090);

        //6050
        Node p6050 = new Node(0,"P1-6050",TypeNode.RoomClass,new Position(1509,523));
        nodes.add(p6050);

        //6340
        Node p6340 = new Node(0,"P1-6340",TypeNode.RoomClass,new Position(1291,523));
        nodes.add(p6340);

        //6130
        Node p6130 = new Node(0,"P1-6130",TypeNode.RoomClass,new Position(1075,523));
        nodes.add(p6130);

        //6350
        Node p6350 = new Node(0,"P1-6350",TypeNode.RoomClass,new Position(1347,235));
        nodes.add(p6350);

        //6140
        Node p6140 = new Node(0,"P1-6140",TypeNode.RoomClass,new Position(875,594));
        nodes.add(p6140);

        //6150
        Node p6150 = new Node(0,"P1-6150",TypeNode.RoomClass,new Position(763,514));
        nodes.add(p6150);

        //6155
        Node p6155 = new Node(0,"P1-6155",TypeNode.RoomClass,new Position(559,523));
        nodes.add(p6155);

        //6220
        Node p6220 = new Node(0,"P1-6220",TypeNode.RoomClass,new Position(612,597));
        nodes.add(p6220);

        //7010
        Node p7010 = new Node(0,"P1-7010",TypeNode.RoomClass,new Position(314,758));
        nodes.add(p7010);

        //Intersection en face de la 5130
        Node i5130 = new Node(0,"i5130",TypeNode.Intersection,new Position(939,99));
        nodes.add(i5130);
        //Intersection en dessous de la 7060
        Node i7060 = new Node(0,"i7060",TypeNode.Intersection,new Position(222,558));
        nodes.add(i7060);
        //Intersection a gauche de la 6155
        Node i6155 = new Node(0,"i6155",TypeNode.Intersection,new Position(373,565));
        nodes.add(i6155);
        //Intersection en bas de la 7010
        Node i7010 = new Node(0,"i7010",TypeNode.Intersection,new Position(373,962));
        nodes.add(i7010);
        //Intersection a gauche escalier gauche
        Node iEscaGauche = new Node(0,"iEscaGauche",TypeNode.Intersection,new Position(731,945));
        nodes.add(iEscaGauche);
        //Intersection en dessous de 6150
        Node i6150 = new Node(0,"i6150",TypeNode.Intersection,new Position(739,567));
        nodes.add(i6150);
        //Intersection en face de 6140
        Node i6140 = new Node(0,"i6140",TypeNode.Intersection,new Position(943,555));
        nodes.add(i6140);
        //intersection en face de 6440
        Node i6340 = new Node(0,"i6340",TypeNode.Intersection,new Position(1172,567));
        nodes.add(i6340);
        //intersection esca droite
        Node iEscaDroite = new Node(0,"EscaDroite",TypeNode.Intersection,new Position(1159,940));
        nodes.add(iEscaDroite);
        //Intersection en dessous de 5°000
        Node i5000 = new Node(0,"i5000",TypeNode.Intersection,new Position(1596,932));
        nodes.add(i5000);
        //Intersection en face de 6030
        Node i6030 = new Node(0,"i6030",TypeNode.Intersection, new Position(1589,565));
        nodes.add(i6030);
        //Intersection en dessous 5050
        Node i5050 = new Node(0,"i5050",TypeNode.Intersection,new Position(1739,548));
        nodes.add(i5050);


        //Ajout des liens entre les noeuds
        Link l= new Link(p7110,p7120,1);
        addLinkTwoWay(l);
        l=new Link(p7120,p7130,1);
        addLinkTwoWay(l);
        l=new Link(p7130,p7140,1);
        addLinkTwoWay(l);
        l=new Link(p7140,p5130,1);
        addLinkTwoWay(l);
        l=new Link(p7140,i5130,1);
        addLinkTwoWay(l);
        l=new Link(p5130,i5130,1);
        addLinkTwoWay(l);
        l=new Link(p5120,p5130,1);
        addLinkTwoWay(l);
        l=new Link(p5120,p5110,1);
        addLinkTwoWay(l);
        l=new Link(p5110,p5100,1);
        addLinkTwoWay(l);
        l=new Link(p5100,p5050,1);
        addLinkTwoWay(l);
        l= new Link(p5050,p5060,1);
        addLinkTwoWay(l);
        l=new Link(p5060,p5050,1);
        addLinkTwoWay(l);
        l=new Link(p5050,i5050,1);
        addLinkTwoWay(l);
        l=new Link(i5050,i6030,1);
        addLinkTwoWay(l);
        l=new Link(i6030,p6050,1);
        addLinkTwoWay(l);
        l= new Link(i6030,p5010,1);
        addLinkTwoWay(l);
        l=new Link(i6030,p6030,1);
        addLinkTwoWay(l);
        l=new Link(i6030,p6050,1);
        addLinkTwoWay(l);
        l = new Link(p5010,p5000,1);
        addLinkTwoWay(l);
        l =new Link(p6030,p5000,2);
        addLinkTwoWay(l);
        l= new Link(p6050,p6340,1);
        addLinkTwoWay(l);
        l = new Link(p6340,i6340,1);
        addLinkTwoWay(l);
        l=new Link(i6340,p6130,1);
        addLinkTwoWay(l);
        l=new Link(i6340,p6110,2);
        addLinkTwoWay(l);
        l=new Link(p6110,iEscaDroite,1);
        addLinkTwoWay(l);
        l = new Link(iEscaDroite,iEscaGauche,2);
        addLinkTwoWay(l);
        l=new Link(p6130,p6090,1);
        addLinkTwoWay(l);
        l=new Link(p6090,i6140,1);
        addLinkTwoWay(l);
        l=new Link(i6140,p6140,1);
        addLinkTwoWay(l);
        l=new Link(i5130,i6140,3);
        addLinkTwoWay(l);
        l=new Link(p6140,p6150,1);
        addLinkTwoWay(l);
        l=new Link(p6150,i6150,1);
        addLinkTwoWay(l);
        l=new Link(i6150,iEscaGauche,2);
        addLinkTwoWay(l);
        l = new Link(i6150,p6220,1);
        addLinkTwoWay(l);
        l=new Link(p6220,p6155,1);
        addLinkTwoWay(l);
        l=new Link(p6155,i6155,1);
        addLinkTwoWay(l);
        l=new Link(i6155,i7060,1);
        addLinkTwoWay(l);
        l=new Link(i6155,p7010,1);
        addLinkTwoWay(l);
        l=new Link(i6155,i7010,2);
        addLinkTwoWay(l);
        l=new Link(i7060,p7060,1);
        addLinkTwoWay(l);
        l=new Link(p7060,p7070,1);
        addLinkTwoWay(l);
        l=new Link(p7070,p6280,0);
        addLinkTwoWay(l);
        l=new Link(p5120,p6350,0);
        addLinkTwoWay(l);
        l=new Link(p5110,p6350,0);
        addLinkTwoWay(l);
        l=new Link(p7070,p7110,1);
        addLinkTwoWay(l);
        l=new Link(i7010,iEscaGauche,1);
        addLinkTwoWay(l);
        l=new Link(iEscaDroite,i5000,1);
        addLinkTwoWay(l);

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
            if (n.getType()==TypeNode.RoomClass)
            {
                if (n.getName().equals(name))
                {
                    return n;
                }
            }
        }
        return null;
    }

    public void addLinkTwoWay(Link l)
    {
        links.add(l);
        Link l2 = new Link(l.getDestination(),l.getSource(),l.getWeight());
        links.add(l2);
    }
}
