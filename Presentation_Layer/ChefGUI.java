package Presentation_Layer;

import Business_Layer.Order;
import Business_Layer.Restaurant;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ChefGUI extends JFrame implements Observer {
    private static final long serialVersionUID = 8483588034162152530L;
    private JLabel text;
    private JFrame frame;


    public ChefGUI(Restaurant restaurant)
    {
        frame=new JFrame("CHEF");


        frame.setLayout(null);
        restaurant.setChef(this);
        text=new JLabel();
        text.setText("WAITING FOR ORDERS");
        text.setBounds(35,35,170,170);

        frame.add(text);

        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);



    }


    public void update(Observable o, Object arg) {
       text.setText("We have to make order id"+((Order)arg).getOrderId());

    }
}
