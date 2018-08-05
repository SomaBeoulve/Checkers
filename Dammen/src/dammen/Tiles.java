/* Tiles.java
 * This is the object for the board tiles. 
 * It can contain a piece, with all its attributes.
 * 
 */
package dammen;

/**
 *
 * @author AlexAnders
 */
public class Tiles {

    private int xPos;
    private int yPos;
    private ColorNames tileColor;
    private ColorNames pieceColor;
    private boolean dam;

    /*
    * This constructor initializes the tile, with all its attributes.
    */
    Tiles(ColorNames colorTile, ColorNames colorPiece, int positionX, int positionY) {

        tileColor = colorTile;
        pieceColor = colorPiece;
        yPos = positionY;
        xPos = positionX;
        dam = false;
    }

    public int getY() {
        return (yPos);
    }

    public int getX() {
        return (xPos);
    }

    public ColorNames getcolorTile() {
        return (tileColor);
    }

    public ColorNames getcolorPiece() {
        return (pieceColor);
    }

    public void setcolorPiece(ColorNames colorPiece) {
        pieceColor = colorPiece;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setX(int x) {
        xPos = x;
    }

    public boolean isDam() {
        return (dam);
    }

    public ColorNames Color() {
        return (pieceColor);
    }

    public void isDam(boolean d) {
        dam = d;
    }

}
