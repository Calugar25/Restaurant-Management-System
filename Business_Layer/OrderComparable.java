package Business_Layer;

import java.util.Comparator;

public class OrderComparable implements Comparator<Order> {


    public int compare(Order order1, Order order2)
    {
        if(order1.getOrderId()==order2.getOrderId())
        {
            return 0;
        }else
        {
            if(order1.getOrderId()>order2.getOrderId())
            {
                return 1 ;
            }else
            {
                return -1;
            }
        }
    }
}
