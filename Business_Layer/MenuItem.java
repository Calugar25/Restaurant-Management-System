package Business_Layer;
import java.io.Serializable;

public abstract  class MenuItem  implements Serializable{


    private static final long serialVersionUID = -9159472245803619366L;


    public float getPrice()
    {
        throw new UnsupportedOperationException();

    }

    public String getName()
    {
        throw new UnsupportedOperationException();
    }

    public int getId()
    {
        throw new UnsupportedOperationException();
    }
    public void addProduct(MenuItem item)
    {
        throw new UnsupportedOperationException();
    }

    public void removeProduct(int  id )
    {
        throw new UnsupportedOperationException();
    }
    public void display()
    {
        throw new UnsupportedOperationException();
    }

    public String[] z()
    {
        throw new UnsupportedOperationException();
    }

    public String getDescription()
    {
        throw new UnsupportedOperationException();
    }
}
