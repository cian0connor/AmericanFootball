import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.util.*;


public class GUI extends JFrame {

    private JFrame frame = new JFrame();
    private JButton newGame;
    private JPanel menuPanel;


    public static void main(String[] args) {
        new GUI();


    }
//src//images/menuPic
    public GUI()
    {
        frame.setVisible(true);
        frame.setTitle("American Football");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLocation(100,0);
        frame.setLayout(new FlowLayout());
        menuPanel = new JPanel(new FlowLayout());
        newGame = new JButton("New Game");
        menuPanel.add(newGame);
        frame.add(newGame);
        frame.add(menuPanel);

    }

}
