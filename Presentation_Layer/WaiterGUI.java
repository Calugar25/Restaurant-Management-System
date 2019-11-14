package Presentation_Layer;

import Business_Layer.MenuItem;
import Business_Layer.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class WaiterGUI extends JFrame implements Observer {
    private static final long serialVersionUID = 6875684033579188152L;


    private Restaurant restaurant;
    private JFrame frame;
    private JTable orderTable;

    private JLabel orderId;
    private JTextField orderIdtext;

    private JLabel orderTableId;
    private JTextField orderTableIdtext;

    private JLabel products;
    private JTextField productstext;

    private DefaultTableModel model;

    private JButton addOrder;
    Table table;



    public WaiterGUI(final Restaurant restaurant)
    {
       Observable chef=new Observable();
        table=new Table();
        this.restaurant=restaurant;
        frame=new JFrame("WAITER");

        restaurant.setWaiter(this);

        orderTable=new JTable();

        model=new DefaultTableModel();

        orderTable=table.createnewTable(restaurant.getOrderObj(),model);

        orderId=new JLabel("Order Id");
        orderId.setBounds(10,150,50,30);
        frame.add(orderId);

        orderIdtext=new JTextField();
        orderIdtext.setBounds(10,190,50,30);
        frame.add(orderIdtext);

        orderTableId=new JLabel("Table id");
        orderTableId.setBounds(10,230,50,30);
        frame.add(orderTableId);

        orderTableIdtext=new JTextField();
        orderTableIdtext.setBounds(10,270,50,30);
        frame.add(orderTableIdtext);

        products=new JLabel("Id of products");
        products.setBounds(10,300,80,30);
        frame.add(products);

        productstext=new JTextField();
        productstext.setBounds(10,340,50,30);
        frame.add(productstext);

        addOrder=new JButton("New Order");
        addOrder.setBounds(150,300,150,40);
        frame.add(addOrder);


        addOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            if(restaurant.getOrders()!=null)
            {
                int []items =new int[3];
                int i=0;
                Scanner dis=new Scanner(productstext.getText());

                dis.useDelimiter("\\,");
                while(i<3)
                {
                    items[i]=dis.nextInt();
                    i++;
                }
                dis.close();

                ArrayList<MenuItem> menuOrder=new ArrayList<MenuItem>();
                for( i=0;i<3;i++)
                {
                    menuOrder.add(restaurant.getMenuItem(items[i]));
                }
                restaurant.createOrder(Integer.parseInt(orderIdtext.getText()),Integer.parseInt(orderTableIdtext.getText()),items);
                orderTable.setModel(table.getModel(orderTable,restaurant.getOrderObj()));



            }else
            {
                int []items =new int[3];
                int i=0;
                Scanner dis=new Scanner(productstext.getText());

                dis.useDelimiter("\\,");
                while(i<3)
                {
                    items[i]=dis.nextInt();
                    i++;
                }
                dis.close();

                ArrayList<MenuItem> menuOrder=new ArrayList<MenuItem>();
                for( i=0;i<3;i++)
                {
                    menuOrder.add(restaurant.getMenuItem(items[i]));

                }
                System.out.println("asta vreau"+restaurant.getpriceofItems(items));
                restaurant.createOrder(Integer.parseInt(orderIdtext.getText()),Integer.parseInt(orderTableIdtext.getText()),items);
                orderTable=table.createnewTable(restaurant.getOrderObj(),model);



            }
            restaurant.generateBill(Integer.valueOf(orderIdtext.getText()));

            }
        });

        frame.setLayout(null);

        JScrollPane pane=new JScrollPane(orderTable);

        pane.setBounds(0,0,600,150);
        frame.add(pane);

        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);



    }

    public void update(Observable o, Object arg) {

    }
}
