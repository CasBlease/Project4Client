public class Game {
    gameBoard clientBoard = new gameBoard();
    gameBoard opponentBoard = new gameBoard();
    String getWinner(){
        if(clientBoard.isGameOver()){
            return "Opponent Won";
        }
        else if(opponentBoard.isGameOver()){
            return "Client Won";
        }
        else{
            return "Game Still in Progress";
        }
    }
}
