/*
 * CheckerGame.java
 * This is the game engine class. It will create a panel to display the graphics.
 * This will handle all the game objects and process all the user interaction.
 */
package dammen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author AlexAnders
 */
public class CheckerGame extends JPanel implements MouseListener {

    Board gameBoard;
    Color mywhite = new Color(221, 236, 255);
    Color brown = new Color(115, 61, 5);
    Color yellow = new Color(255, 255, 153);
    private boolean firstTileSelected = false;
    private int firstSelectedX;
    private int firstSelectedY;

    /*
    * This constructor creates a panel and initializes the board fields.
    * It adds the pieces to the board tiles.
     */
    CheckerGame() {

        gameBoard = new Board();

        setPreferredSize(new Dimension(400, 400));
        setLocation(100, 100);
        addMouseListener(this);
        gameBoard.boardFields[0][0].setcolorPiece(ColorNames.black);
        for (int y = 0; y < 4; y++) {               // Initialize pieces with color black
            for (int x = 0; x < 10; x++) {
                if (((x + y) & 1) == 0) {
                    gameBoard.boardFields[x][y].setcolorPiece(ColorNames.black);
                }
            }
        }
        for (int y = 9; y > 5; y--) {               // Initialize pieces with color white
            for (int x = 0; x < 10; x++) {
                if (((x + y) & 1) == 0) {
                    gameBoard.boardFields[x][y].setcolorPiece(ColorNames.white);
                }
            }
        }
    }

    /*
    * This will paint the complete board with all the tiles and pieces. 
     */
    @Override
    public void paint(Graphics g) {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                if (gameBoard.getcolorTile(x, y) == ColorNames.black) {
                    g.setColor(brown);
                } else {
                    g.setColor(yellow);
                }

                g.fillRect(45 + x * 50, 33 + y * 50, 50, 50);

                if (gameBoard.getcolorPiece(x, y) == ColorNames.black) {
                    g.setColor(Color.BLACK);
                    g.fillOval(45 + x * 50, 33 + y * 50, 50, 50);
                }
                if (gameBoard.getcolorPiece(x, y) == ColorNames.white) {
                    g.setColor(mywhite);
                    g.fillOval(45 + x * 50, 33 + y * 50, 50, 50);
                }
            }
        }
        if (firstTileSelected == true) {
            g.setColor(Color.RED);
            g.fillOval(63 + firstSelectedX * 50, 50 + firstSelectedY * 50, 15, 15);

        }

    }
            /*
            * Checks if the move is legal. If not, it will return false.
            * If move is legal it will execute the move and reset the flag. Repaints board.
             */
    private boolean checkAndExecuteMove(int x, int y){
        if (gameBoard.getcolorPiece(x, y) == ColorNames.empty) {
                if (gameBoard.getcolorTile(x, y) != ColorNames.white) {
                    if (gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) == ColorNames.white && y != firstSelectedY - 1) {
                        return false;
                    }
                    if (gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) == ColorNames.black && y != firstSelectedY + 1) {
                        return false;
                    }
                    firstTileSelected = false;
                    gameBoard.setcolorPiece(x, y, gameBoard.getcolorPiece(firstSelectedX, firstSelectedY));
                    gameBoard.setcolorPiece(firstSelectedX, firstSelectedY, ColorNames.empty);
                    repaint();
                    return true;
                }
            }
        return false;
    }
    
    
    /*
    * Check the conditions of capturing a piece in 4 different directions.
    * If true, move and capture the pieces. Return true.
    * Repaints board.
    * If one of the conditions is not met return false. 
    */
    private boolean checkAndCaptureStone(int x, int y) {
        if (gameBoard.getcolorPiece(x, y) == ColorNames.empty) {
            if (gameBoard.getcolorTile(x, y) != ColorNames.white) {
                if (y == firstSelectedY - 2 && x == firstSelectedX - 2) {
                    if (gameBoard.getcolorPiece(firstSelectedX - 1, firstSelectedY - 1) != ColorNames.empty && gameBoard.getcolorPiece(x, y) != gameBoard.getcolorPiece(firstSelectedX, firstSelectedY)&& gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) != gameBoard.getcolorPiece(firstSelectedX - 1, firstSelectedY - 1)) {
                        firstTileSelected = false;
                        gameBoard.setcolorPiece(x, y, gameBoard.getcolorPiece(firstSelectedX, firstSelectedY));
                        gameBoard.setcolorPiece(firstSelectedX, firstSelectedY, ColorNames.empty);
                        gameBoard.setcolorPiece(firstSelectedX - 1, firstSelectedY - 1, ColorNames.empty);
                        repaint();
                        return true;
                    }
                }
                if (y == firstSelectedY - 2 && x == firstSelectedX + 2) {
                    if (gameBoard.getcolorPiece(firstSelectedX + 1, firstSelectedY - 1) != ColorNames.empty && gameBoard.getcolorPiece(x, y) != gameBoard.getcolorPiece(firstSelectedX, firstSelectedY)&& gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) != gameBoard.getcolorPiece(firstSelectedX + 1, firstSelectedY - 1)) {
                        firstTileSelected = false;
                        gameBoard.setcolorPiece(x, y, gameBoard.getcolorPiece(firstSelectedX, firstSelectedY));
                        gameBoard.setcolorPiece(firstSelectedX, firstSelectedY, ColorNames.empty);
                        gameBoard.setcolorPiece(firstSelectedX + 1, firstSelectedY - 1, ColorNames.empty);
                        repaint();
                        return true;
                    }
                }
                if (y == firstSelectedY + 2 && x == firstSelectedX - 2) {
                    if (gameBoard.getcolorPiece(firstSelectedX - 1, firstSelectedY + 1) != ColorNames.empty && gameBoard.getcolorPiece(x, y) != gameBoard.getcolorPiece(firstSelectedX, firstSelectedY)&& gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) != gameBoard.getcolorPiece(firstSelectedX - 1, firstSelectedY + 1)) {
                        firstTileSelected = false;
                        gameBoard.setcolorPiece(x, y, gameBoard.getcolorPiece(firstSelectedX, firstSelectedY));
                        gameBoard.setcolorPiece(firstSelectedX, firstSelectedY, ColorNames.empty);
                        gameBoard.setcolorPiece(firstSelectedX - 1, firstSelectedY + 1, ColorNames.empty);
                        repaint();
                        return true;
                    }
                }

                if (y == firstSelectedY + 2 && x == firstSelectedX + 2) {
                    if (gameBoard.getcolorPiece(firstSelectedX + 1, firstSelectedY + 1) != ColorNames.empty && gameBoard.getcolorPiece(x, y) != gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) && gameBoard.getcolorPiece(firstSelectedX, firstSelectedY) != gameBoard.getcolorPiece(firstSelectedX + 1, firstSelectedY + 1)) {
                        firstTileSelected = false;
                        gameBoard.setcolorPiece(x, y, gameBoard.getcolorPiece(firstSelectedX, firstSelectedY));
                        gameBoard.setcolorPiece(firstSelectedX, firstSelectedY, ColorNames.empty);
                        gameBoard.setcolorPiece(firstSelectedX + 1, firstSelectedY + 1, ColorNames.empty);
                        repaint();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int y = e.getY();
        int x = e.getX();
        x = x - 45;
        x = x / 50;
        y = y - 33;
        y = y / 50;
        if (x < 0 || x > 9 || y < 0 || y > 9){
            return;
        }
        if (firstTileSelected == false) {
            if (gameBoard.getcolorPiece(x, y) != ColorNames.empty) {
                firstTileSelected = true;
                firstSelectedX = x;
                firstSelectedY = y;
                repaint();
            }
        } else {
            if (firstSelectedX == x & firstSelectedY == y) {
                firstTileSelected = false;
                repaint();
                return;
            }
            // Test capture of piece
            if (checkAndCaptureStone(x, y) == true) {
                return;
            }

            // Regular move 
            if (checkAndExecuteMove(x, y) == true){
                return;
            }
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }
}
