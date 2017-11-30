import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GUI extends JFrame implements ActionListener {
    //Setting required variable to build my GUI
    private JFrame menu = new JFrame();
    private JFrame gameScreen = new JFrame();
    private JFrame touchdownScreen = new JFrame();
    private JFrame interceptionScreen = new JFrame();
    private ImageIcon gamePic;
    private ImageIcon pic;
    private ImageIcon touchPic;
    private ImageIcon interPic;
    private JLabel imgLable;
    private JLabel gameImgLable;
    private JLabel touchLable;
    private JLabel interLable;
    private JMenuBar topMenu = new JMenuBar();
    private JMenuBar playMenu = new JMenuBar();
    private JMenu gameMenu;
    private JMenu playingMenu;


    public static void main(String[] args) {
        new GUI();
        //Building my GUI
    }

    public GUI()
    {

        menu.setTitle("American Football");
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setSize(1024,768);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
        //taken from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        //Opens GUI in the middle of any screen
        menu.setJMenuBar(topMenu);
        menu.setLayout(new FlowLayout());
        pic = new ImageIcon("src//images//pic.jpg");
        //Grabs background from local images folder
        imgLable = new JLabel(pic);
        menu.add(imgLable);
        createGameMenu();
        topMenu.add(gameMenu);
        menu.setVisible(true);



        gameScreen.setTitle("American Football");
        gameScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameScreen.setSize(933,700);
        Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
        gameScreen.setLocation(dimen.width/2-menu.getSize().width/2, dimen.height/2-menu.getSize().height/2);
        //taken from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        //Opens GUI in the middle of any screen
        gameScreen.setJMenuBar(playMenu);
        gameScreen.setLayout(new FlowLayout());
        gamePic = new ImageIcon("src//images//playing.jpg");
        //Grabs background from local images folder
        gameImgLable = new JLabel(gamePic);
        gameScreen.add(gameImgLable);
        createPlayMenu();
        playMenu.add(playingMenu);
        gameScreen.setVisible(false);




        touchdownScreen.setTitle("Touchdown!");
        touchdownScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        touchdownScreen.setSize(1000,600);
        Dimension dimens = Toolkit.getDefaultToolkit().getScreenSize();
        touchdownScreen.setLocation(dimens.width/2-menu.getSize().width/2, dimens.height/2-menu.getSize().height/2);
        //taken from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        //Opens GUI in the middle of any screen
        touchdownScreen.setLayout(new FlowLayout());
        touchPic = new ImageIcon("src//images//touchdown.jpg");
        //Grabs background from local images folder
        touchLable = new JLabel(touchPic);
        touchdownScreen.add(touchLable);
        touchdownScreen.setVisible(false);




        interceptionScreen.setTitle("Interception!");
        interceptionScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interceptionScreen.setSize(1000,600);
        Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
        interceptionScreen.setLocation(dimensi.width/2-menu.getSize().width/2, dimensi.height/2-menu.getSize().height/2);
        //taken from https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        //Opens GUI in the middle of any screen
        interceptionScreen.setLayout(new FlowLayout());
        interPic = new ImageIcon("src//images//interception.jpg");
        //Grabs background from local images folder
        interLable = new JLabel(interPic);
        interceptionScreen.add(interLable);
        interceptionScreen.setVisible(false);

    }
    private void createGameMenu()
    {
        // create the menu
        gameMenu = new JMenu("Game");
        // declare a menu item (re-usable)
        JMenuItem item;
        item = new JMenuItem("New Game");
        item.addActionListener(this);
        gameMenu.add(item);
        item = new JMenuItem("Load Team Details");
        item.addActionListener(this);
        gameMenu.add(item);
        gameMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        gameMenu.add(item);
    }

    private void createPlayMenu()
    {
        // create the menu
        playingMenu = new JMenu("Game");
        // declare a menu item (re-usable)
        JMenuItem item;
        item = new JMenuItem("Save Team Details");
        item.addActionListener(this);
        playingMenu.add(item);
        playingMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        playingMenu.add(item);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals ("Quit"))
        {
            menu.setVisible(false);
            JOptionPane.showMessageDialog(null,"Goodbye");
            System.exit(0);
        }
        else if (e.getActionCommand().equals("New Game"))
        {
            menu.setVisible(false);
            gameScreen.setVisible(true);
            playGame();
        }

        else if (e.getActionCommand().equals("Save Team Details"))
        {
            try {
                SaveLoad.saveTeam();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }

        else if (e.getActionCommand().equals("Load Team Details"))
        {
            try {
                SaveLoad.loadTeam();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }


    }


    static ArrayList<Player> team = new ArrayList<>();

    public void playGame() {
        int DefScore = 0;
        int OffScore = 0;
        int plays = 0;
        int QBChoice;
        int WRChoice;
        int CBChoice;
        int save;
        boolean saveAsked = false;
        String QBChoiceAsString;
        String WRChoiceAsString;
        String CBChoiceAsString;



        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                boolean validChoice = false;

                while (!validChoice) {


                    QBChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n");

                    while(QBChoiceAsString == null)
                    {
                        QBChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n");
                    }

                    while (!QBChoiceAsString.equals("1") && !QBChoiceAsString.equals("2") && !QBChoiceAsString.equals("3") && !QBChoiceAsString.equals("4") && !QBChoiceAsString.equals("5"))
                    {

                        JOptionPane.showMessageDialog(null, "Invalid input");

                        QBChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n");


                    }

                    QBChoice = Integer.parseInt(QBChoiceAsString);

                    if (QBChoice == 1) {
                        team.add( new QB("Aaron Rodgers", new Team("Green Bay Packers"), 33, 1.88, 10, 10));
                        validChoice = true;

                    } else if (QBChoice == 2) {
                        team.add( new QB("Tom Brady", new Team("New England Patriots"), 40, 1.93, 8, 10));
                        validChoice = true;

                    } else if (QBChoice == 3) {
                        team.add(new QB("Eli Manning", new Team("New York Giants"), 36, 1.93, 7, 6));
                        validChoice = true;

                    } else if (QBChoice == 4) {
                        team.add(new QB("Carson Wentz", new Team("Philadelphia Eagles"), 24, 1.96, 7, 8));
                        validChoice = true;

                    } else if (QBChoice == 5) {
                        team.add(new QB("Matt Stafford", new Team("Philadelphia Eagles"), 24, 1.96, 7, 8));
                        validChoice = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }

                }
            } else if (j == 1) {
                boolean validChoice = false;
                while (!validChoice) {
                    WRChoiceAsString = JOptionPane.showInputDialog("Please select your Receiver\n\n" + "1.Antonio Brown\n" + "2.Julio Jones\n" + "3.Odell Beckham Jr.\n" + "4.A.J. Green\n" + "5.Dez Bryant\n");

                    while(WRChoiceAsString == null)
                    {
                        WRChoiceAsString = JOptionPane.showInputDialog("Please select your Receiver\n\n" + "1.Antonio Brown\n" + "2.Julio Jones\n" + "3.Odell Beckham Jr.\n" + "4.A.J. Green\n" + "5.Dez Bryant\n");
                    }
                    while (!WRChoiceAsString.equals("1") && !WRChoiceAsString.equals("2") && !WRChoiceAsString.equals("3") && !WRChoiceAsString.equals("4") && !WRChoiceAsString.equals("5"))
                    {

                        JOptionPane.showMessageDialog(null, "Invalid input");

                        WRChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n");

                    }

                    WRChoice = Integer.parseInt(WRChoiceAsString);

                    if (WRChoice == 1) {
                        team.add(new receiver("Antonio Brown", new Team("Pittsburgh Steelers"), 29, 1.78, 10, 8));
                        validChoice = true;
                    } else if (WRChoice == 2) {
                        team.add(new receiver("Julio Jones", new Team("Atlanta Falcons"), 28, 1.91, 9, 9));
                        validChoice = true;
                    } else if (WRChoice == 3) {
                        team.add(new receiver("Odell Beckham Jr.", new Team("New York Giants"), 25, 1.8, 10, 9));
                        validChoice = true;
                    } else if (WRChoice == 4) {
                        team.add(new receiver("A.J. Green", new Team("Cincinnati Bengals"), 29, 1.93, 9, 8));
                        validChoice = true;
                    } else if (WRChoice == 5) {
                        team.add(new receiver("Dez Bryant", new Team("Dallas Cowboys"), 29, 1.87, 10, 7));
                        validChoice = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            } else if (j == 2) {
                boolean validChoice = false;
                while (!validChoice) {
                    CBChoiceAsString = JOptionPane.showInputDialog("Please select your Defender\n\n" + "1.Patrick Peterson\n" + "2.Richard Sherman\n" + "3.Janoris Jenkins\n" + "4.Aqib Talib\n" + "5.Chris Harris Jr.\n");

                    while(CBChoiceAsString == null)
                    {
                        CBChoiceAsString = JOptionPane.showInputDialog("Please select your Receiver\n\n" + "1.Antonio Brown\n" + "2.Julio Jones\n" + "3.Odell Beckham Jr.\n" + "4.A.J. Green\n" + "5.Dez Bryant\n");
                    }
                    while (!CBChoiceAsString.equals("1") && !CBChoiceAsString.equals("2") && !CBChoiceAsString.equals("3") && !CBChoiceAsString.equals("4") && !CBChoiceAsString.equals("5"))
                    {

                        JOptionPane.showMessageDialog(null, "Invalid input");

                        CBChoiceAsString = JOptionPane.showInputDialog("Please select your QB\n\n" + "1.Aaron Rodgers\n" + "2.Tom Brady\n" + "3.Eli Manning\n" + "4.Carson Wentz\n" + "5.Matt Stafford\n");

                    }

                    CBChoice = Integer.parseInt(CBChoiceAsString);
                    if (CBChoice == 1) {
                        team.add(new defender("Patrick Peterson", new Team("Arizona Cardinals"), 27, 1.85, 8, 8));
                        validChoice = true;
                    } else if (CBChoice == 2) {
                        team.add(new defender("Richard Sherman", new Team("Seattle Seahawks"), 29, 1.91, 9, 7));
                        validChoice = true;
                    } else if (CBChoice == 3) {
                        team.add(new defender("Janoris Jenkins", new Team("New York Giants"), 29, 1.78, 7, 8));
                        validChoice = true;
                    } else if (CBChoice == 4) {
                        team.add(new defender("Aqib Talib", new Team("Denver Broncos"), 31, 1.85, 8, 7));
                        validChoice = true;
                    } else if (CBChoice == 5) {
                        team.add(new defender("Chris Harris Jr.", new Team("Denver Broncos"), 28, 1.78, 10, 8));
                        validChoice = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            }

        }

        while (OffScore < 5 && DefScore < 5) {

            int offSkill = team.get(0).getOffSkill(team.get(1));
            int defSkill = team.get(2).getDefSkill();
            gameScreen.setVisible(true);
            interceptionScreen.setVisible(false);
            touchdownScreen.setVisible(false);
            int reply = JOptionPane.showConfirmDialog(null, "Would you like to run a play?", "Run Play", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.NO_OPTION) {
                save = JOptionPane.showConfirmDialog(null,"Would you like to save your team details?","Save Team?",JOptionPane.YES_NO_OPTION);
                saveAsked = true;
                if (save == JOptionPane.NO_OPTION)
                {
                    gameScreen.setVisible(false);
                    menu.setVisible(true);
                    break;
                }
                else
                {
                    try {
                        SaveLoad.saveTeam();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error!");
                    }

                    break;
                }
            } else {
                plays++;
                if (offSkill > defSkill) {

                    if ((int) ((Math.random() * 10) + 1) > 2) {
                        gameScreen.setVisible(false);
                        touchdownScreen.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    } else {
                        gameScreen.setVisible(false);
                        interceptionScreen.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    }
                } else if (offSkill < defSkill) {
                    if ((int) ((Math.random() * 10) + 1) > 2) {
                        gameScreen.setVisible(false);
                        interceptionScreen.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    } else {
                        gameScreen.setVisible(false);
                        touchdownScreen.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    }
                } else if (offSkill == defSkill) {
                    gameScreen.setVisible(false);
                    interceptionScreen.setVisible(true);
                    if ((int) ((Math.random() * 10) + 1) > 5) {
                        JOptionPane.showMessageDialog(null, "Interception!");
                        DefScore++;
                    } else {
                        gameScreen.setVisible(false);
                        touchdownScreen.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Touchdown!");
                        OffScore++;
                    }
                }

                JOptionPane.showMessageDialog(null, "\tScore\nOffense " + OffScore + " - " + DefScore + " Defense");
            }
        }

        touchdownScreen.setVisible(false);
        interceptionScreen.setVisible(false);

        JOptionPane.showMessageDialog(null, team.get(0).toString() + "\n\n" + team.get(1).toString() + "\n\n" + team.get(2).toString() + "\n\nNo. of Plays:  "+ plays +"\n\n\tFinal Score\nOffense " + OffScore + " - " + DefScore + " Defense");
        if(!saveAsked)
        {
            save = JOptionPane.showConfirmDialog(null, "Would you like to save your team details?", "Save Team?", JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.NO_OPTION)
            {
                gameScreen.setVisible(false);
                menu.setVisible(true);
            }

            else
            {
                try {
                    SaveLoad.saveTeam();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error Saving!");
                }
                gameScreen.setVisible(false);
                menu.setVisible(true);
            }

        }

        else
        {
            gameScreen.setVisible(false);
            menu.setVisible(true);
        }


    }



}
