import  javax.swing.*;
import java.awt.event.*;
import  java.util.*;


public class GUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setVisible(true);
    }

    public GUI()
    {
        setTitle("American Football");
        setSize(600,400);
        setLocation(500,500);
    }

}
