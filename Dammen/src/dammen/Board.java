/*
 * Board.java
 * This contains a ten-by-ten array representing the tiles and pieces on the gameboard.
 */
package dammen;

/**
 *
 * @author AlexAnders
 */
public class Board {

    Tiles boardFields[][] = new Tiles[10][10];

    /*
    * This constructor will create a board with the default empty tiles.
     */
    Board() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (((x + y) & 1) == 0) {
                    boardFields[x][y] = new Tiles(ColorNames.black, ColorNames.empty, x, y);
                } else {
                    boardFields[x][y] = new Tiles(ColorNames.white, ColorNames.empty, x, y);
                }
            }

        }
    }

    /*
     * Return the color of the tile on the board.
     */
    public ColorNames getcolorTile(int x, int y) {
        return (boardFields[x][y].getcolorTile());
    }

    /*
     * Return the color of the piece on the board.
     */
    public ColorNames getcolorPiece(int x, int y) {
        return (boardFields[x][y].getcolorPiece());
    }
    
    public void setcolorPiece(int x, int y, ColorNames colorPiece) {
       boardFields[x][y].setcolorPiece(colorPiece); 

    }

}

