package Business_Layer;

public class BaseProduct extends MenuItem {


   int id;
   String name;
   float price;
   String description;

    private static final long serialVersionUID = -2385357209048149290L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BaseProduct(String name, float price, int id,String description) {

        this.name = name;
        this.price = price;
        this.id = id;
        this.description=description;
    }
    public void display()
    {
        System.out.println("Id :"+id+"with name "+name+"has price"+price+"asta e desc"+description);
    }

    public String[] z()
    {
        String []temp=new String[4];

       temp[0]=Integer.toString(id);
       temp[1]=name;
       temp[2]=Float.toString(getPrice());
        System.out.println(description);
       temp[3]=description;
       return temp;
    }
}
