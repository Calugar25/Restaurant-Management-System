package Business_Layer;

import java.io.Serializable;
import java.util.Comparator;

public class MenuComparable implements Comparator<MenuItem> ,Serializable {

    private static final long serialVersionUID = 6083173253460645924L;

    public int compare(MenuItem item1, MenuItem item2)
    {
        if(item1.getId()==item2.getId())
        {
            return 0;
        }else
        {
            if(item1.getId()>item2.getId())
            {
                return 1 ;
            }else
            {
                return -1;
            }
        }
    }
}
