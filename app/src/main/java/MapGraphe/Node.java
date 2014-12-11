package MapGraphe;

/**
 * Created by Antonin on 11/12/2014.
 */

/****
 * Un noeud est un point spécifique et unique sur la carte
 * Il est définit par un id, un nom, un type, et un emplacement
 */
public class Node {

    final private int ID;
    final private String name;
    final private TypeNode type;
    final private Position position;

    public Node(int id,String name,TypeNode type,Position pos) {
        ID = id;
        this.name = name;
        this.type = type;
        this.position = pos;
    }


    ///////////////// GETTER / SETTER /////////////////////////////////

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public TypeNode getType()
    {
        return type;
    }

    public Position getPosition()
    {
        return position;
    }

    ////////////////////////////////////////////////////////////////////

    @Override
    public String toString()
    {
        return name;
    }

    /****
     * Test l'égalité entre deux noeuds
     * @param node
     * @return egal si l id est identique
     */
    public boolean equal(Node node)
    {
        return name.equals(node.getName());
    }
}
