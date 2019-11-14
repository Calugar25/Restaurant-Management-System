package Business_Layer;

import java.util.ArrayList;
import java.util.TreeSet;

public interface RestaurantProcessing {

    public void addBaseProduct(int id ,float price, String name,String description);

    public MenuItem getMenuItem(int id);

    public TreeSet<MenuItem> getMenu();

    public void addCompositeProduct(int id ,String name,int[] items);

    public void deleteMenuItem(int id);

    public void editBaseProduct(String name,float price,int id,String description);

    public void editCompositeProduct(int id,String name,int [] itemsId);

    public void createOrder(int id,int table,int[] itemsId);

    public void deleteOrder(int id);

    public void generateBill(int id);

    public ArrayList<MenuItem> getOrderItems(Order order);


}
