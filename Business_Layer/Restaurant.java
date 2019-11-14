package Business_Layer;



import java.io.PrintWriter;
import java.util.*;


public class Restaurant extends Observable implements RestaurantProcessing {



   private TreeSet<MenuItem> menu;
   private HashMap<Order,ArrayList<MenuItem>> ordersMap;
   private TreeSet<Order> orders;

   Observer waiter;
   Observer chef;


   public Restaurant(TreeSet<MenuItem> menu)
   {
       ordersMap=new HashMap<Order, ArrayList<MenuItem>>();
      if(menu==null)
      {
          menu = new TreeSet<MenuItem>(new MenuComparable());
      }else
      {
          this.menu=menu;
      }
      orders=new TreeSet<Order>(new OrderComparable());

      assert wellFormed()==1 :"The restaurant has base products that dont have name";


    }


    public Restaurant()
    {

    }

    public TreeSet<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(TreeSet<MenuItem> menu) {
        this.menu = menu;
    }

    public Observer getWaiter() {
        return waiter;
    }

    public TreeSet<Order> getOrders() {
        return orders;
    }

    public ArrayList<Object> getOrderObj()
    {
        if(orders!=null)
        {
            return new ArrayList< Object> (orders);
        }
        else
            return new ArrayList<Object>();
    }
    public ArrayList<Object> getMenuObj()
    {
        if(menu!=null)
        {
            return new ArrayList< Object> (menu);
        }
        else
            return new ArrayList<Object>();
    }

    public void setWaiter(Observer waiter) {
        this.waiter = waiter;
    }

    public Observer getChef() {
        return chef;
    }

    public void setChef(Observer chef) {
        this.chef = chef;
    }

    public int  wellFormed()
    {
        for(MenuItem m: menu)
        {
            if(m.getName().equals(""))
            {
                return 0;
            }
        }
        return 1 ;
    }


    public void addBaseProduct(int id ,float price, String name,String description)
    {
        assert id!=0 : "Id must have a value";
        assert price>0 : "the product must have a price";
        assert !name.equals(""): "the product must have a name";

        menu.add(new BaseProduct(name,price,id,description));

        if(waiter!=null)
        {
            waiter.update(this,null);
        }
    }

    public MenuItem getMenuItem(int id)
    {
        for(MenuItem m: menu)
        {
            if(m.getId()==id)
            {
                return  m;
            }
        }
        return null;
    }

    public void SetMenuItem(int id)
    {
        for(MenuItem m:menu)
        {
            if(m.getId()==id)
            {
                m=getMenuItem(id);
            }
        }
    }


    public void addCompositeProduct(int id ,String name,int[] items)
    {
        assert id!=0 : "id must have a valid value";
        assert !name.equals(""): " product must have a name";
        assert items.length>=2:" must have at least 2 items";

        ArrayList<MenuItem> tempItems=new ArrayList<MenuItem>();
        for(int i=0;i<items.length;i++)
        {
            tempItems.add(getMenuItem(items[i]));
        }

       menu.add(new CompositeProduct(id,name,tempItems));

        if(waiter!=null)
        {
            waiter.update(this,null);
        }


    }


    public void deleteMenuItem(int id)
    {
        assert id!=0: "The product must have a valid id";
        MenuItem m=getMenuItem(id);

        menu.remove(m);

        if(waiter!=null){
            waiter.update(this,null);
        }
    }

    public void editBaseProduct(String name,float price,int id,String description)
    {
        assert id!=0:"the product must have a valid id";
        assert price>0:"The price must be positive";

        BaseProduct b=(BaseProduct) getMenuItem(id);

        assert b!=null:"the base product does not exist";

        if(!b.getName().equals(name))
        {
            b.setName(name);
        }
        if(!(b.getPrice()==price))
        {
            b.setPrice(price);
        }

        if(waiter!=null)
        {
            waiter.update(this,null);
        }


    }

    public void editCompositeProduct(int id,String name,int [] itemsId)
    {
        assert id!=0:"Product must have a valid id";

        ArrayList<MenuItem>items=new ArrayList<MenuItem>();

        for(int i=0;i<itemsId.length;i++)
        {
            items.add(getMenuItem(itemsId[i]));
        }
        //CompositeProduct compositeProduct=new CompositeProduct(id,name,itemsId);

        CompositeProduct c=(CompositeProduct)getMenuItem(id);

        if(!c.getName().equals(name))
        {
            c.setName(name);
        }

        if(!c.getProducts().equals(items))
        {
            c.setProducts(items);
        }
        c.setDescription(getMenuItem(id).getDescription());

        if(waiter!=null)
        {
            waiter.update(this,null);
        }

    }

    public float getpriceofItems(int[]items)
    {
        float price=0;
        for(int i=0;i<items.length;i++)
        {
            price+=getMenuItem(items[i]).getPrice();
            System.out.println(price);
        }
        return price;
    }


    public void createOrder(int id,int table,int[] itemsId)
    {
        assert id!=0:"The order must have a valid id";
        assert itemsId.length>=2:"must have at least 2 products";

        ArrayList<MenuItem> items=new ArrayList<MenuItem>();


        for(int i=0;i<itemsId.length;i++)
        {
            items.add(getMenuItem(itemsId[i]));
        }

        Order o=new Order(id,table,getpriceofItems(itemsId));

        orders.add(o);

        ordersMap.put(o,items);

        if(chef!=null)
        {
            chef.update(this,o);
        }

    }


    public void deleteOrder(int id)
    {   Order temp=new Order();
        for(Order o:orders)
        {
            if (o.getOrderId()==id)
            {
                 temp=o;
            }
        }
        orders.remove(temp);
        ordersMap.remove(temp);

    }

    public float getPriceofOrder(int id)
    {
        Order temo=new Order();
        ArrayList<MenuItem>items=new ArrayList<MenuItem>();
        float price=0;

        for(Order o:orders)
        {
            if(o.getOrderId()==id)
            {
                temo=o;
            }
        }
        items=ordersMap.get(temo);
        for(MenuItem m:items)
        {
            price+=m.getPrice();
        }

        return price;
    }



    public void generateBill(int id)
    {
        Order o=new Order();
        ArrayList<MenuItem> items=new ArrayList<MenuItem>();

        for(Order order:orders)
        {
            if(order.getOrderId()==id)
            {   items=ordersMap.get(order);
                order=o;

            }
        }

        try{
            PrintWriter writer = new PrintWriter("Bill"+id+".txt", "UTF-8");
            writer.println("this is the order with id"+id);
            writer.println("this order contains"+items.size()+"menu items");
            writer.println("this order costs"+getPriceofOrder(id)+"$");
            writer.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public ArrayList<MenuItem> getOrderItems(Order order)
    {
        return ordersMap.get(order);
    }









}
