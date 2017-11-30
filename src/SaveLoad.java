import java.io.*;
import java.util.ArrayList;
import javax.swing.*;




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
        ArrayList<Player> team = (ArrayList<Player>) loadStream.readObject();
        String display = "";
        for(Player p : team) {
            display += p.toString();
            display += "\n\n";
        }
        JOptionPane.showMessageDialog(null, display);
        loadStream.close();
    }
}
