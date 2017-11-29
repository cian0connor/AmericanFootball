import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.util.*;


public class GUI extends JFrame implements ActionListener {

    private JFrame menu = new JFrame();
    private ImageIcon pic;
    private JLabel imgLable;
    private JMenuBar topMenu = new JMenuBar();
    private JMenu fileMenu;


    public static void main(String[] args) {
        new GUI();


    }

    public GUI()
    {

        menu.setTitle("American Football");
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setSize(600,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
        //taken from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        menu.setJMenuBar(topMenu);
        menu.setLayout(new FlowLayout());
        pic = new ImageIcon("src//images//American-Football.jpg");
        imgLable = new JLabel(pic);
        menu.add(imgLable);
        createFileMenu();
        topMenu.add(fileMenu);


        menu.setVisible(true);

    }
    private void createFileMenu()
    {
        // create the menu
        fileMenu = new JMenu("File");
        // declare a menu item (re-usable)
        JMenuItem item;
        item = new JMenuItem("New Game");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("Save");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("Load");
        item.addActionListener(this);
        fileMenu.add(item);
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals ("Quit"))
        {
            JOptionPane.showMessageDialog(null,"Goodbye");
            System.exit(0);
        }
        else if (e.getActionCommand().equals("New Game"))
        {
            playGame();
        }

    }

    public void playGame() {
        int DefScore = 0;
        int OffScore = 0;
        int plays;
        int QBChoice;
        int WRChoice;
        int CBChoice;
        String QBChoiceAsString;
        String WRChoiceAsString;
        String CBChoiceAsString;

        Player[] team = new Player[3];

        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                boolean validChoice = false;
                //boolean validEntry = false;
                while (!validChoice) {
                    QBChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n"));
                    //while (!validEntry)
                    //{
                    // QBChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford");
                    //if (!Character.isDigit(QBChoiceAsString.charAt(0)))
                    //{
                    // JOptionPane.showMessageDialog(null, "Invalid input");
                    //}
                    // else
                    //{
                    //QBChoice = Integer.parseInt(QBChoiceAsString);
                    //validEntry = true;
                    //}
                    //}
                    if (QBChoice == 1) {
                        team[j] = new QB("Aaron Rodgers", new Team("Green Bay Packers"), 33, 1.88, 10, 10);
                        validChoice = true;

                    } else if (QBChoice == 2) {
                        team[j] = new QB("Tom Brady", new Team("New England Patriots"), 40, 1.93, 8, 10);
                        validChoice = true;

                    } else if (QBChoice == 3) {
                        team[j] = new QB("Eli Manning", new Team("New York Giants"), 36, 1.93, 7, 6);
                        validChoice = true;

                    } else if (QBChoice == 4) {
                        team[j] = new QB("Carson Wentz", new Team("Philadelphia Eagles"), 24, 1.96, 7, 8);
                        validChoice = true;

                    } else if (QBChoice == 5) {
                        team[j] = new QB("Matt Stafford", new Team("Philadelphia Eagles"), 24, 1.96, 7, 8);
                        validChoice = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }

                }
            } else if (j == 1) {
                boolean validChoice = false;
                while (!validChoice) {
                    WRChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select your Receiver\n\n" + "1.Antonio Brown\n" + "2.Julio Jones\n" + "3.Odell Beckham Jr.\n" + "4.A.J. Green\n" + "5.Dez Bryant\n"));
                    if (WRChoice == 1) {
                        team[j] = new receiver("Antonio Brown", new Team("Pittsburgh Steelers"), 29, 1.78, 10, 8);
                        validChoice = true;
                    } else if (WRChoice == 2) {
                        team[j] = new receiver("Julio Jones", new Team("Atlanta Falcons"), 28, 1.91, 9, 9);
                        validChoice = true;
                    } else if (WRChoice == 3) {
                        team[j] = new receiver("Odell Beckham Jr.", new Team("New York Giants"), 25, 1.8, 10, 9);
                        validChoice = true;
                    } else if (WRChoice == 4) {
                        team[j] = new receiver("A.J. Green", new Team("Cincinnati Bengals"), 29, 1.93, 9, 8);
                        validChoice = true;
                    } else if (WRChoice == 5) {
                        team[j] = new receiver("Dez Bryant", new Team("Dallas Cowboys"), 29, 1.87, 10, 7);
                        validChoice = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            } else if (j == 2) {
                boolean validChoice = false;
                while (!validChoice) {
                    CBChoice = Integer.parseInt(JOptionPane.showInputDialog("Please select your Defender\n\n" + "1.Patrick Peterson\n" + "2.Richard Sherman\n" + "3.Janoris Jenkins\n" + "4.Aqib Talib\n" + "5.Chris Harris Jr.\n"));
                    if (CBChoice == 1) {
                        team[j] = new defender("Patrick Peterson", new Team("Arizona Cardinals"), 27, 1.85, 8, 8);
                        validChoice = true;
                    } else if (CBChoice == 2) {
                        team[j] = new defender("Richard Sherman", new Team("Seattle Seahawks"), 29, 1.91, 9, 7);
                        validChoice = true;
                    } else if (CBChoice == 3) {
                        team[j] = new defender("Janoris Jenkins", new Team("New York Giants"), 29, 1.78, 7, 8);
                        validChoice = true;
                    } else if (CBChoice == 4) {
                        team[j] = new defender("Aqib Talib", new Team("Denver Broncos"), 31, 1.85, 8, 7);
                        validChoice = true;
                    } else if (CBChoice == 5) {
                        team[j] = new defender("Chris Harris Jr.", new Team("Denver Broncos"), 28, 1.78, 10, 8);
                        validChoice = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            }
        }

        while (OffScore < 5 && DefScore < 5) {
            plays = 0;
            int offSkill = team[0].getOffSkill(team[1]);
            int defSkill = team[2].getDefSkill();
            int reply = JOptionPane.showConfirmDialog(null, "Would you like to run a play?", "Run Play", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.NO_OPTION) {
                break;
            } else {
                plays++;
                if (offSkill > defSkill) {

                    if ((int) ((Math.random() * 10) + 1) > 2) {
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    }
                } else if (offSkill < defSkill) {
                    if ((int) ((Math.random() * 10) + 1) > 2) {
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    }
                } else if (offSkill == defSkill) {
                    if ((int) ((Math.random() * 10) + 1) > 5) {
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    }
                }

                JOptionPane.showMessageDialog(null, "\tScore\nOffense " + OffScore + " - " + DefScore + " Defense");
            }
        }

        JOptionPane.showMessageDialog(null, team[0].toString() + "\n\n" + team[1].toString() + "\n\n" + team[2].toString() + "\n\n\tFinal Score\nOffense " + OffScore + " - " + DefScore + " Defense");
    }



}
