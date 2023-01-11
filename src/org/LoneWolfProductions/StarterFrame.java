package org.LoneWolfProductions;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.URL;


//Used to input the values with which the Canvas is to be created with
public class StarterFrame {

    private JFrame starterFrame = new JFrame("Select properties");
    private int cellSizeInPx = 20;
    private int rowAmount = 50;
    private int columnAmount = 50;
    private JSlider cellSizeSlider;
    private JSlider rowAmountSlider;
    private JSlider columnAmountSlider;


    public StarterFrame() {
        cellSizeSelector();
        rowAmountSelector();
        columnAmountSelector();
        startButton();

        loadMacOSTrayIcon();

        starterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        starterFrame.setLayout(new GridLayout(7, 1));
        starterFrame.setSize(700, 400);
        starterFrame.setLocationRelativeTo(null);
        starterFrame.setVisible(true);

    }


    private void cellSizeSelector() {

        JLabel cellSizeLabel = new JLabel("Select cell size in Px", SwingConstants.CENTER);

        starterFrame.add(cellSizeLabel);
        cellSizeSlider = new JSlider(JSlider.HORIZONTAL, 5, 40, cellSizeInPx);

        cellSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cellSizeInPx = cellSizeSlider.getValue();
            }
        });

        cellSizeSlider.setMinorTickSpacing(1);
        cellSizeSlider.setMajorTickSpacing(10);
        cellSizeSlider.setPaintTicks(true);
        cellSizeSlider.setPaintLabels(true);
        cellSizeSlider.setSnapToTicks(true);
        cellSizeSlider.setVisible(true);
        starterFrame.add(cellSizeSlider);

    }

    private void rowAmountSelector() {

        JLabel rowAmountLabel = new JLabel("Select amount of rows", SwingConstants.CENTER);

        starterFrame.add(rowAmountLabel);
        rowAmountSlider = new JSlider(JSlider.HORIZONTAL, 10, 200, rowAmount);

        rowAmountSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rowAmount = rowAmountSlider.getValue();
            }
        });

        rowAmountSlider.setMinorTickSpacing(5);
        rowAmountSlider.setMajorTickSpacing(30);
        rowAmountSlider.setPaintTicks(true);
        rowAmountSlider.setPaintLabels(true);
        rowAmountSlider.setSnapToTicks(true);
        rowAmountSlider.setVisible(true);
        starterFrame.add(rowAmountSlider);
    }

    private void columnAmountSelector() {

        JLabel columnAmountLabel = new JLabel("Select amount of columns", SwingConstants.CENTER);

        starterFrame.add(columnAmountLabel);
        columnAmountSlider = new JSlider(JSlider.HORIZONTAL, 10, 350, columnAmount);

        columnAmountSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                columnAmount = columnAmountSlider.getValue();
            }
        });

        columnAmountSlider.setMinorTickSpacing(5);
        columnAmountSlider.setMajorTickSpacing(30);
        columnAmountSlider.setPaintTicks(true);
        columnAmountSlider.setPaintLabels(true);
        columnAmountSlider.setSnapToTicks(true);
        columnAmountSlider.setVisible(true);
        starterFrame.add(columnAmountSlider);
    }

    private void startButton() {
        JButton startButton = new JButton("Start");

        startButton.setVisible(true);
        starterFrame.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    starterFrame.setVisible(false);

                    if (!cellSizeSlider.getValueIsAdjusting()
                            && !rowAmountSlider.getValueIsAdjusting()
                            && !columnAmountSlider.getValueIsAdjusting()) {

                        new Canvas(cellSizeInPx, rowAmount,columnAmount);
                    }

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    private void loadMacOSTrayIcon(){

        //loading an image from a file
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final URL imageResource = Main.class.getClassLoader().getResource("images/icon128*128.png");
        final Image image = defaultToolkit.getImage(imageResource);

        //this is new since JDK 9
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            //set icon for macOS (and other systems which do support this method)
            taskbar.setIconImage(image);

        } catch (final UnsupportedOperationException e) {
            System.out.println("The OS does not support: 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }
    }

}
