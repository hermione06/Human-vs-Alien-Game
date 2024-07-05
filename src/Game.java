package JAVA.Projects.AliensHumans;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human human = new Human(100);
        Alien alien = new Alien(150);
        GameController gameController = new GameController(human, alien);
        GameDisplay gameDisplay = new GameDisplay();

        gameDisplay.displayGameStart();
        gameController.startGame();
        scanner.close();   
    }    
}
