package com.enestesea.ideplugin.Gui;

import com.enestesea.ideplugin.project.DanilaService;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.ui.JBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Danila extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel image;

    public Danila() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        BufferedImage tempImage;

        tempImage = ApplicationManager.getApplication().getService(DanilaService.class).getRandomDanilaImage();

        image = new JLabel(new ImageIcon(tempImage));
        image.setForeground(JBColor.LIGHT_GRAY);
        image.setBackground(JBColor.LIGHT_GRAY);
        image.setOpaque(true);
        this.contentPane.add(image);
        this.validate();
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JPanel getContent(){
        return contentPane;
    }

    public static void main(String[] args) {
        Danila dialog = new Danila();
        BufferedImage tempImage;
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
