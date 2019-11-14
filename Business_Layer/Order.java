package Business_Layer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



public class Order {
    private int orderId;
    private Date date;
    private int table;
    private float price;

    public Order(int orderId, int table,float price) {
        this.orderId = orderId;
        this.table = table;
        this.date=new Date();
        this.price=price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int hashCode()
    {
        return table+orderId;
    }

    public ArrayList<String> toStringArray()
    {
        ArrayList<String > s=new ArrayList<String>();
        s.add(Integer.toString(orderId));
        s.add(Integer.toString(table));
        s.add(date.toString());
        return s;
    }

    public String[] z()
    {

        String pater="MM/dd/yyyy : HH:mm:ss";
        DateFormat df=new SimpleDateFormat(pater);
        Date today=this.date;

        String todayasDate=df.format(today);

        String []s =new String[4];
        s[0]=String.valueOf(orderId);
        s[1]=todayasDate;
        s[2]=String.valueOf(table);
        s[3]=String.valueOf(price);

        return s;

    }

    public Order()
    {

    }
}
