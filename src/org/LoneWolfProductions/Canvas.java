package org.LoneWolfProductions;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;


public class Canvas {

    Cell[][] canvasGrid;

    public static int CELL_SIZE_PX;
    public static int COL_AMOUNT;
    public static int ROW_AMOUNT;


    Canvas(int cellSizeInPx, int rowAmount, int colAmount) throws FileNotFoundException {

        //Properties initialization...
        CELL_SIZE_PX = cellSizeInPx;
        ROW_AMOUNT = rowAmount;
        COL_AMOUNT = colAmount;

        // +1 needed as min row/col index is = 1
        canvasGrid = new Cell[ROW_AMOUNT + 1][COL_AMOUNT + 1];

        createGrid();

        Cursor myCursor = new Cursor(this);

        HelperFrame helper = new HelperFrame(this);
    }

    public void createGrid() {

        for (int i = 1; i <= ROW_AMOUNT; i++) {
            for (int j = 1; j <= COL_AMOUNT; j++) {

                canvasGrid[i][j] = new Cell(CELL_SIZE_PX, i, j);
            }
        }
    }


    public void paintCell(int row, int column, Color color) {

        canvasGrid[row][column].setColor(color);
        canvasGrid[row][column].fill();

        canvasGrid[row][column].setPainted(true);
        canvasGrid[row][column].setCellColor(color);
    }

    public void clearCell(int row, int column) {

        canvasGrid[row][column].setColor(Color.BLACK);
        canvasGrid[row][column].draw();

        canvasGrid[row][column].setPainted(false);
        canvasGrid[row][column].setCellColor(Color.BLACK);
    }


    public void clear() {
        for (int i = 1; i <= ROW_AMOUNT; i++) {
            for (int j = 1; j <= COL_AMOUNT; j++) {

                Cell myCell = canvasGrid[i][j];

                if (myCell.isPainted()) {
                    clearCell(i, j);
                }
            }
        }
    }

    public void save() {
        String myLastDrawing = "";

        System.out.println(ROW_AMOUNT);
        System.out.println(COL_AMOUNT);


        for (int i = 1; i <= ROW_AMOUNT; i++) {
            for (int j = 1; j <= COL_AMOUNT; j++) {
                System.out.println("c-"+j+" r-" +i);
                myLastDrawing += canvasGrid[i][j].toString();
            }
            myLastDrawing += "\n";
        }
        System.out.println(myLastDrawing);

        try {

            String filePath = "Resources/saves/mySave.txt";
            FileWriter fWriter = new FileWriter(filePath);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(myLastDrawing);
            bWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() throws IOException {

        String myLastDrawing = "";

        try {

            String filePath = "Resources/saves/mySave.txt";
            FileReader fReader = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(fReader);

            String line = "";

            while ((line = bReader.readLine()) != null) {
                myLastDrawing += line;
                //myLastDrawing += "\n";
            }
            System.out.println(myLastDrawing);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] cells = myLastDrawing.split(":");

        System.out.println(cells.length);

        int column = 1;
        int row = 1;

        for (int i = 0; i < ROW_AMOUNT * COL_AMOUNT; i++) {

            System.out.println("c-"+column+" r-" +row);

            if(cells[i].equals("RGB(0,0,0)")){
                paintCell(row,column,Color.BLACK);
            }
            column++;
            if(column>COL_AMOUNT){
                column =1;
                row ++;

            }

        }
    }

}
