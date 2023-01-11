package org.LoneWolfProductions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HelperFrame {

    Canvas myCanvas;
    JFrame helperFrame = new JFrame("Mondrianer helper");

    private static int helperFrameWidth = 300;
    private static int helperFrameHeight = 600;

    private JLabel movementLabel;
    private JLabel paintClearLabel;
    private JButton colorSelectButton;
    private JButton clearButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton reSizeButton;

    private JColorChooser colorChooser;
    private static int itemCounter = 0;

    public HelperFrame(Canvas myCanvas) {

        this.myCanvas = myCanvas;

        //Create & add labels...
        movementLabel();
        paintClearLabel();

        //Create & add buttons...
        selectColorButton();
        clearButton();
        saveButton();
        loadButton();
        reSizeButton();

        helperFrame.setLayout(new GridLayout(itemCounter, 1));
        helperFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helperFrame.setSize(helperFrameWidth, helperFrameHeight);
        helperFrame.setVisible(true);

    }

    private void movementLabel() {
        movementLabel = new JLabel("Move cursor" + " - WASD");
        itemCounter++;

        movementLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movementLabel.setVisible(true);

        helperFrame.add(movementLabel);

    }

    private void paintClearLabel() {
        paintClearLabel = new JLabel("Toggle Paint / Clear mode" + " - space");
        itemCounter++;

        paintClearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paintClearLabel.setVisible(true);

        helperFrame.add(paintClearLabel);

    }

    private void selectColorButton() {
        colorSelectButton = new JButton("Select color");
        itemCounter++;

        colorChooser = new JColorChooser();

        colorSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(colorChooser, "Select Color", Color.RED);
                colorSelectButton.setBackground(color);



                //TODO
                //Cursor.setSelectedColor(color);

            }
        });

        colorSelectButton.setBackground(Color.RED);

        colorSelectButton.setBorderPainted(false);
        colorSelectButton.setOpaque(true);
        colorSelectButton.setVisible(true);

        helperFrame.add(colorSelectButton);
    }

    private void clearButton() {
        clearButton = new JButton("Clear");
        itemCounter++;

        clearButton.setSize(50, 50);
        clearButton.setVisible(true);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCanvas.clear();
            }
        });

        helperFrame.add(clearButton);
    }

    private void saveButton() {
        saveButton = new JButton("save");
        itemCounter++;

        saveButton.setSize(50, 50);
        saveButton.setVisible(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               myCanvas.save();
            }
        });

        helperFrame.add(saveButton);
    }

    private void loadButton() {
        loadButton = new JButton("load");
        itemCounter++;

        loadButton.setSize(50, 50);
        loadButton.setVisible(true);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myCanvas.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        helperFrame.add(loadButton);
    }

    public void reSizeButton() {
        reSizeButton = new JButton("re-Size");
        itemCounter++;

        reSizeButton.setSize(50, 50);
        reSizeButton.setVisible(true);

        reSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        helperFrame.add(reSizeButton);
    }


}
