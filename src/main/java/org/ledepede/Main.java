package org.ledepede;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        new GUI();

    }

    static ActionListener openFile = e -> {
        JFileChooser j = new JFileChooser("d:");

        // Open the save dialog
        j.showOpenDialog(null);

        try {
            String content = new String(Files.readAllBytes(Paths.get(j.getSelectedFile().getPath())));
            GUI.textArea.setText(content); // Sets the text of the opened file
        } catch (IOException ex) {
            // Do nothing just because it will spam some shit in the console
        }
    };

    static ActionListener saveToFile = e -> {
        GUI.success.setVisible(false);

        JFileChooser j = new JFileChooser("d:");

        // Open the save dialog
        j.showSaveDialog(null);
        try {
            saveFile(GUI.textArea.getText(), j.getSelectedFile().getAbsolutePath());
        } catch (Exception er) {
            // Do nothing just because it will spam some shit in the console
        }
    };
    public static void saveFile(String text, String path) {
        File pathToCurrentFile = new File(path);

        try {
            FileWriter fw = new FileWriter(path);

            if (path.isEmpty()) {
                fw.flush();
                fw.write(text);
            } else {
                pathToCurrentFile.delete();
                fw.write(text);
            }

            fw.close();
        }
        catch (Exception er) {
            er.getStackTrace();
        }

        GUI.success.setVisible(true);

    }
}
