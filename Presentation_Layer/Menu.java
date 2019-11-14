package Presentation_Layer;

import Business_Layer.MenuItem;
import Business_Layer.Restaurant;
import Data_Layer.RestaurantSerializator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TreeSet;

public class Menu extends JFrame {

    private static final long serialVersionUID = -579482311864618877L;

    private JFrame frame;
    private JButton admin;
    private JButton waiter;
    private JButton chef;

    private JPanel panel;

    private Restaurant restaurant;


    class WindowEventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent evt) {
            RestaurantSerializator.Serialize(restaurant.getMenu());
        }
    }

    public Menu(final Restaurant restaurant)
    {

        frame=new JFrame("Order Manegement");

        frame.addWindowListener(new WindowEventHandler());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800,700);

        TreeSet<MenuItem> menu=new TreeSet<MenuItem>();
        menu=restaurant.getMenu();

        this.restaurant=restaurant;

        //frame.setLayout(new FlowLayout());
        panel=new JPanel(new GridLayout(1,3));
        admin=new JButton("ADMIN");
        admin.setPreferredSize(new Dimension(150,150));
        panel.add(admin);
        // clients.setBounds(10,10,200,200);
        waiter=new JButton("WAITER");
        waiter.setPreferredSize(new Dimension(150,150));
        panel.add(waiter);
        chef=new JButton("CHEF");
        chef.setPreferredSize(new Dimension(150,150));
        panel.add(chef);

        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminGUI(restaurant);
            }
        });

        waiter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new WaiterGUI(restaurant);
            }
        });

        chef.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChefGUI(restaurant);
            }
        });

        frame.setContentPane(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}
