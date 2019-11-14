package Presentation_Layer;

import Business_Layer.MenuItem;
import Business_Layer.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import java.util.*;

public class AdminGUI  extends JFrame{
    private static final long serialVersionUID = 1251871597685051003L;


    private JFrame frame;
    public  JTable adminTable;

    private JLabel idsimple;
    private JTextField idsimpletext;

    private JLabel namesimple;
    private JTextField namesimpletext;

    private JLabel pricesimple;
    private JTextField pricesimpletext;

    private JLabel descriptionsimple;
    private JTextField desciptionsimpletext;

    private JLabel comp;
    private JTextField comptext;

    private Restaurant restaurant;

    private DefaultTableModel model;

    private JButton add;
    private JButton edit;
    private JButton delete;
    private JButton addComp;

    private JButton editComp;





    public AdminGUI(final Restaurant restaurant)
    {
        TreeSet<MenuItem> menuItems=new TreeSet<MenuItem>();

     this.restaurant=restaurant;

        frame=new JFrame("Administrator");
     final Table tableclass=new Table();

     adminTable=new JTable();

     model=new DefaultTableModel();

     adminTable=tableclass.createnewTable(restaurant.getMenuObj(),model);


    idsimple=new JLabel("Product id");
    idsimple.setBounds(10,200,80,20);
    frame.add(idsimple);

    idsimpletext=new JTextField();
    idsimpletext.setBounds(10,220,80,20);
    frame.add(idsimpletext);

    namesimple=new JLabel("Product name");
    namesimple.setBounds(10,240,80,20);
    frame.add(namesimple);

    namesimpletext=new JTextField();
    namesimpletext.setBounds(10,260,80,20);
    frame.add(namesimpletext);

    pricesimple=new JLabel("Product price");
    pricesimple.setBounds(10,280,80,20);
    frame.add(pricesimple);

    pricesimpletext=new JTextField();
    pricesimpletext.setBounds(10,300,80,20);
    frame.add(pricesimpletext);

    descriptionsimple=new JLabel("Description");
    descriptionsimple.setBounds(10,320,80,20);
    frame.add(descriptionsimple);

    desciptionsimpletext=new JTextField();
    desciptionsimpletext.setBounds(10,340,80,20);
    frame.add(desciptionsimpletext);

    comp=new JLabel("Composite prodcut id");
    comp.setBounds(10,360,150,20);
    frame.add(comp);

    comptext=new JTextField();
    comptext.setBounds(10,380,80,20);
    frame.add(comptext);


    add=new JButton("Add Base product");
    add.setBounds(180,220,180,30);
    frame.add(add);

    edit=new JButton("edit Base Product");
    edit.setBounds(180,260,180,30);
    frame.add(edit);

    delete=new JButton("Delete  product");
    delete.setBounds(180,300,180,30);
    frame.add(delete);

    addComp=new JButton("Add composite");
    addComp.setBounds(180,340,180,30);
    frame.add(addComp);


    add.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            restaurant.addBaseProduct(Integer.parseInt(idsimpletext.getText()),Float.parseFloat(pricesimpletext.getText()),namesimpletext.getText(),desciptionsimpletext.getText());
            adminTable.setModel(tableclass.getModel(adminTable,restaurant.getMenuObj()));

        }
    });

    edit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            restaurant.editBaseProduct(namesimpletext.getText(),Float.parseFloat(pricesimpletext.getText()),Integer.parseInt(idsimpletext.getText()),desciptionsimpletext.getText());
            adminTable.setModel(tableclass.getModel(adminTable,restaurant.getMenuObj()));
        }
    });

    delete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(adminTable.getModel().getValueAt(adminTable.getSelectedRow(),0).toString());
            restaurant.deleteMenuItem(id);
            adminTable.setModel(tableclass.getModel(adminTable,restaurant.getMenuObj()));

        }
    });

    addComp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int []items =new int[2];
            int i=0;
            Scanner dis=new Scanner(comptext.getText());
            System.out.println(comptext.getText());
            dis.useDelimiter("\\,");
            while(i<2)
            {
                items[i]=dis.nextInt();
                i++;
            }
            dis.close();
            restaurant.addCompositeProduct(Integer.parseInt(idsimpletext.getText()),namesimpletext.getText(),items);
            adminTable.setModel(tableclass.getModel(adminTable,restaurant.getMenuObj()));


        }
    });

    editComp=new JButton("Edit Comp product");
    editComp.setBounds(180,380,180,30);
    frame.add(editComp);

    editComp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int []items =new int[2];
            int i=0;
            Scanner dis=new Scanner(comptext.getText());
            System.out.println(comptext.getText());
            dis.useDelimiter("\\,");
            while(i<2)
            {
                items[i]=dis.nextInt();
                i++;
            }
            dis.close();

            restaurant.editCompositeProduct(Integer.parseInt(idsimpletext.getText()),namesimpletext.getText(),items);
            adminTable.setModel(tableclass.getModel(adminTable,restaurant.getMenuObj()));

        }
    });








     frame.setLayout(null);
     JScrollPane pane=new JScrollPane(adminTable);

     pane.setBounds(0,0,600,200);

     frame.add(pane);

     frame.setSize(900,500);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     frame.setVisible(true);












    }
}
