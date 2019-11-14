package Presentation_Layer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Table {

    public Table()
    {

    }

    public static JTable createnewTable(List<Object> objectList,DefaultTableModel model)
    {


        JTable table;
         model=new DefaultTableModel();
        if(!objectList.isEmpty())
        {

            for(Field f :objectList.get(0).getClass().getDeclaredFields())
            {
                if(!f.getName().equals("serialVersionUID"))
                {
                    model.addColumn(f.getName());
                }
            }

        }

       for(Object object:objectList)
       {
        try{
            model.addRow((String[])object.getClass().getMethod("z",null).invoke(object,null));
        }catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       }

        table=new JTable(model);
        return table;


    }

    public TableModel getModel(JTable table,List<Object> objectList)
    {
        DefaultTableModel model= new DefaultTableModel();
        if(!objectList.isEmpty())
        {

            for(Field f :objectList.get(0).getClass().getDeclaredFields())
            {
                if(!f.getName().equals("serialVersionUID"))
                {
                    model.addColumn(f.getName());
                }
            }

        }

        for(Object object:objectList)
        {
            try{
                model.addRow((String[])object.getClass().getMethod("z",null).invoke(object,null));
            }catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return model;


    }

}
