import java.util.ArrayList;

public class gameBoard {
    int width = 10;
    int height = 10;
    boolean gameOver;
    ShipSquare[][] board = new ShipSquare[10][10];
    Ship[] fleet = new Ship[5];
    //Creates ships with default lengths.
    public void generateFleet(){
        Ship shipToAdd;
        shipToAdd = new Ship(2);
        fleet[0] = shipToAdd;
        shipToAdd = new Ship(3);
        fleet[1] = shipToAdd;
        shipToAdd = new Ship(3);
        fleet[2] = shipToAdd;
        shipToAdd = new Ship(4);
        fleet[3] = shipToAdd;
        shipToAdd = new Ship(5);
        fleet[4] = shipToAdd;
    }

    //Takes the coordinate of the head of the ship and places ships left to right if horizontal, top to bottom if vertical.
    public void placeShip(Ship shipToPlace,int x, int y, boolean horizontal){
        board[x][y] = shipToPlace.arrayOfSquares.getFirst();
        if(horizontal){
            for(int i = 1; i < shipToPlace.shipLength; i++){
                //TODO: add the shipSquare's coordinates.
                board[x+i][y] = shipToPlace.arrayOfSquares.get(i);
                shipToPlace.arrayOfSquares.get(i).x = x+i;
                shipToPlace.arrayOfSquares.get(i).y = y;
            }
        }
        else{
            for(int i = 1; i < shipToPlace.shipLength; i++){
                board[x][y+i] = shipToPlace.arrayOfSquares.get(i);
                shipToPlace.arrayOfSquares.get(i).x = x;
                shipToPlace.arrayOfSquares.get(i).y = y+i;
            }
        }
    }
    public void receiveMissile(int x, int y){
        if(board[x][y] == null){
            //Miss
            return;
        }
        else{
            board[x][y].isSunk = true;
            for(int i = 0; i < 5; i++){
                //Finds the boat that the square belongs to and updates it.
                if(fleet[i].findShipSquare(x, y)){
                    if(fleet[i].isBoatSunk()){
                        isGameOver();
                    }
                    break;
                }
            }
        }
    }
    //Will return false if a boat is found that isn't sunk.
    public boolean isGameOver(){
        for(int i = 0; i < 5; i++){
            if(!fleet[i].boatIsSunk){
                gameOver = false;
                return false;
            }
        }
        gameOver = true;
        return true;
    }
}
