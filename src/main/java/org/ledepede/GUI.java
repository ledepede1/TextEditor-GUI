package org.ledepede;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public static final JFrame jframe = new JFrame("Text Editor");
    public static final JTextArea textArea = new JTextArea();
    public static final JButton saveButton = new JButton("Save as");
    public static final JButton openButton = new JButton("Open");
    public static final JLabel success = new JLabel("Successfully saved");
    public static final JLabel madeby = new JLabel("Made by github.com/ledepede1");

    public GUI(){
        // GUI
        jframe.setResizable(false);
        jframe.setLayout(null);

        madeby.setBounds(10,547,180,20);
        madeby.setFont(new Font("Consolas", Font.PLAIN, 12));
        madeby.setSize(280,20);
        madeby.setForeground(Color.lightGray);
        jframe.add(madeby);

        success.setBounds(230,3,180,30);
        success.setForeground(Color.lightGray);
        success.setVisible(false);
        jframe.add(success);

        openButton.setBounds(120,10,90,20);
        openButton.setFocusPainted(false);
        openButton.setBackground(Color.DARK_GRAY);
        openButton.setBorderPainted(false);
        openButton.setForeground(Color.WHITE);
        openButton.setSize(90,20);
        openButton.setFont(new Font("Consolas", Font.PLAIN, 12));
        openButton.addActionListener(Main.openFile);
        jframe.add(openButton);


        saveButton.setBounds(10,10,90,20);
        saveButton.setFocusPainted(false);
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setBorderPainted(false);
        saveButton.setForeground(Color.WHITE);
        saveButton.setSize(90,20);
        saveButton.setFont(new Font("Consolas", Font.PLAIN, 12));
        jframe.add(saveButton);

        textArea.setSize(150, 500);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        jframe.add(textArea);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10,50,365,500);
        jframe.add(scroll);

        saveButton.addActionListener(Main.saveToFile);


        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400,600);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

    }

}
