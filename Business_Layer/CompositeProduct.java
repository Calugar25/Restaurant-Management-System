package Business_Layer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {


    int id;
    String name ;
    float price ;
    String description;
    ArrayList<MenuItem> products;
    private static final long serialVersionUID = -7247474119816195677L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        float price=0;
        for(MenuItem m : products)
        {
            price+=m.getPrice();
        }
        return price ;
    }


    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    public String getDescription()
    {   String s="";
        for(int i=0;i<products.size();i++)
        {
            s+=products.get(i).getName()+",";
        }
        return s;
    }

    public void setDescription(String description)
    {
        description=description;
    }

    public CompositeProduct(int id, String name, ArrayList<MenuItem> products) {

        this.id = id;
        this.name = name;
        this.products = products;
        this.price=this.getPrice();

        this.description=getDescription();

    }

    public CompositeProduct(int id,String name,float price)
    {
        this.id=id;
        this.name=name;
        this.price=price;

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(MenuItem item)
    {
        products.add(item);
    }

    public void removeProduct(int id)
    {
        int index=0;
        for(MenuItem m: products)
        {
            if (m.getId()==id)
            {
                products.remove(index);
            }
            index++;
        }
    }

    public void display()
    {
        System.out.println("this is the product with id "+id+"and has "+products.size()+"products and the price is "+getPrice()+"asta e desc"+getDescription());
    }


    public String[] z()
    {
        String []temp=new String[4];

        temp[0]=Integer.toString(id);
        temp[1]=name;
        temp[2]=Float.toString(getPrice());

        temp[3]=description;
        return temp;
    }



}
