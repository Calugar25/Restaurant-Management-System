package Data_Layer;

import Business_Layer.MenuItem;
import Business_Layer.Order;

import java.io.*;
import java.util.TreeSet;

public class RestaurantSerializator {

    public static void Serialize(TreeSet<MenuItem> menu)
    {
        try{
            FileOutputStream fileOut=new FileOutputStream("Menu.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(menu);
            out.close();
            fileOut.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void Serialize2(TreeSet<Order> menu)
    {
        try{
            FileOutputStream fileOut=new FileOutputStream("Order.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(menu);
            out.close();
            fileOut.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static TreeSet<MenuItem> DeSerialize()
    {
        TreeSet<MenuItem> items =null;

        try {
            FileInputStream fileIn = new FileInputStream("Menu.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            items = (TreeSet<MenuItem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();

        }
        return items;
    }


    public static TreeSet<Order> DeSerialize2()
    {
        TreeSet<Order> items =null;

        try {
            FileInputStream fileIn = new FileInputStream("Order.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            items = (TreeSet<Order>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();

        }
        return items;
    }




/*
    public static void main(String[] args)
    {
        TreeSet<MenuItem> menu = new TreeSet<MenuItem>(new MenuComparable());

        MenuItem fries = new BaseProduct("fries", 3, 1,"salted");
        BaseProduct pui = new BaseProduct("chicken",10,2,"cripsy");
        BaseProduct inghetata=new BaseProduct("icecream",6,3,"sweet");


        BaseProduct suc=new BaseProduct("juice",5,4,"300ml");
        BaseProduct sandwish=new BaseProduct("sandwish",11,5,"bread,cheese");

        ArrayList<MenuItem> bigmacksimplu=new ArrayList<MenuItem>();
        ArrayList<MenuItem>bigmackfsimplu=new ArrayList<MenuItem>();


        bigmacksimplu.add(suc);
        bigmacksimplu.add(sandwish);
        CompositeProduct bigmack=new CompositeProduct(6,"bigmack",bigmacksimplu);


        bigmackfsimplu.add(bigmack);
        bigmackfsimplu.add(fries);

        CompositeProduct bigmackf=new CompositeProduct(7,"doubleBigMack",bigmackfsimplu);

        menu.add(fries);
        menu.add(pui);
        menu.add(inghetata);
        menu.add(bigmack);
        menu.add(bigmackf);

        Serialize(menu);


        TreeSet<MenuItem> menu2 =new TreeSet<MenuItem>();
        menu2=DeSerialize();
        for(MenuItem m: menu2)
        {
            m.display();
        }
    }
*/
}
