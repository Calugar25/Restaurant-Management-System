package Presentation_Layer;

import Business_Layer.MenuItem;
import Business_Layer.Restaurant;
import Data_Layer.RestaurantSerializator;

import javax.swing.*;
import java.util.TreeSet;

public class GUI extends JFrame {


    private static final long serialVersionUID = 4702442269486483163L;


    public static void main(String[] args) {
       TreeSet<MenuItem> menu = RestaurantSerializator.DeSerialize();

        Restaurant restaurant = new Restaurant(menu);
        Menu Meniu = new Menu(restaurant);

    }
}
