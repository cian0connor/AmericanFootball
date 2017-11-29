import java.io.*;
import javax.swing.*;



/**
 * Created by t00196273 on 29/11/2017.
 */
public class SaveLoad {
    public static void saveTeam() throws Exception
    {
        File saveFile = new File("team.data");
        FileOutputStream saveFileStream = new FileOutputStream(saveFile);
        ObjectOutputStream saveStream = new ObjectOutputStream(saveFileStream);

        saveStream.writeObject(GUI.team);

        saveStream.close();
    }

    public static void loadTeam() throws Exception {
        File loadFile = new File("team.data");
        FileInputStream loadFileStream = new FileInputStream(loadFile);
        ObjectInputStream loadStream = new ObjectInputStream(loadFileStream);
        //Got Code from https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the
        Player[] team = (Player[]) loadStream.readObject();
        String display = "";
        for(Player p : team) {
            display += p.toString();
        }
        JOptionPane.showMessageDialog(null, display);
        loadStream.close();
    }
}
