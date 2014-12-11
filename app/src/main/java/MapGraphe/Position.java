package MapGraphe;

/**
 * Created by Antonin on 11/12/2014.
 */
public class Position {

    private int x;
    private int y;

    public Position()
    {
        x= 0;
        y= 0;
    }

    public Position(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public String toString()
    {
        return "Position : " + x + " , "+ y;
    }
}
