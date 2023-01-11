package org.LoneWolfProductions;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.io.IOException;

public class Cursor implements KeyboardHandler {

    Cell myCursor;
    private final Canvas myCanvas;

    private int RowPosition;
    private int ColumnPosition;

    private boolean isPaintingOn = false;

    //TODO
    private Color selectedColor = Color.BLACK;

    Cursor(Canvas myCanvas) {

        this.myCanvas = myCanvas;
        new Keyboard(this);

        this.RowPosition = Canvas.ROW_AMOUNT / 2;
        this.ColumnPosition = Canvas.COL_AMOUNT / 2;

        //Correct initial position for odd numbered rows or Columns
        //if (Canvas.ROW_AMOUNT % 2 != 0) this.cursorXPositionPX -= Canvas.CELL_SIZE_PX / 2;
        //if (Canvas.COL_AMOUNT % 2 != 0) this.cursorYPositionPX -= Canvas.CELL_SIZE_PX / 2;

        myCursor = new Cell(Canvas.CELL_SIZE_PX, this.RowPosition, this.ColumnPosition);
        myCursor.fill();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:

                if (this.RowPosition > 1) {
                    myCursor.translate(0, -Canvas.CELL_SIZE_PX);
                    this.RowPosition -= 1;

                    if (isPaintingOn) {
                        myCanvas.paintCell(RowPosition, ColumnPosition, selectedColor);
                    } else {
                        myCanvas.clearCell(RowPosition, ColumnPosition);
                    }
                }
                break;

            case KeyboardEvent.KEY_A:

                if (this.ColumnPosition > 1) {
                    myCursor.translate(-Canvas.CELL_SIZE_PX, -0);
                    this.ColumnPosition -= 1;

                    if (isPaintingOn) {
                        myCanvas.paintCell(RowPosition, ColumnPosition, selectedColor);
                    } else {
                        myCanvas.clearCell(RowPosition, ColumnPosition);
                    }
                }
                break;


            case KeyboardEvent.KEY_S:

                if (this.RowPosition < Canvas.ROW_AMOUNT) {
                    myCursor.translate(0, Canvas.CELL_SIZE_PX);
                    this.RowPosition += 1;

                    if (isPaintingOn) {
                        myCanvas.paintCell(RowPosition, ColumnPosition, selectedColor);
                    } else {
                        myCanvas.clearCell(RowPosition, ColumnPosition);
                    }

                }
                break;


            case KeyboardEvent.KEY_D:

                if (this.ColumnPosition < Canvas.COL_AMOUNT) {
                    myCursor.translate(Canvas.CELL_SIZE_PX, 0);
                    this.ColumnPosition += 1;

                    if (isPaintingOn) {
                        myCanvas.paintCell(RowPosition, ColumnPosition, selectedColor);
                    } else {
                        myCanvas.clearCell(RowPosition, ColumnPosition);
                    }

                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (isPaintingOn) {
                    isPaintingOn = false;
                    System.out.println("painting off");
                } else {
                    myCanvas.paintCell(this.RowPosition,this.ColumnPosition,selectedColor);
                    isPaintingOn = true;
                    System.out.println("painting on");
                }
                break;

            case KeyboardEvent.KEY_C:
                myCanvas.clear();
                break;

            case KeyboardEvent.KEY_P:
                myCanvas.save();
                break;

            case KeyboardEvent.KEY_L:
                try {
                    myCanvas.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

}

