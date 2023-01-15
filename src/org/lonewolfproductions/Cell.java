package org.lonewolfproductions;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cell  extends Rectangle {

    private boolean isPainted = false;
    private Color cellColor = Color.WHITE;

    public Cell(int cellSizePx, int cursorRowPosition, int cursorColumnPosition) {

        super(cursorColumnPosition * cellSizePx, cursorRowPosition * cellSizePx, cellSizePx, cellSizePx);
        super.draw();

    }


    public  String toString(){
        String result = "";

        if(isPainted){
            result += "RGB("+cellColor.getRed()+","+cellColor.getGreen()+","+cellColor.getBlue()+"):";
        }else{
            result += "FALSE:";
        }



        return result;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) { isPainted = painted; }

    public Color getCellColor() {
        return cellColor;
    }

    public void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

}
