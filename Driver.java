import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Driver {
	
	static boolean DEBUG = false;
  static StringBuilder gameLog;	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
    gameLog = new StringBuilder();
    String filename = "log" + System.currentTimeMillis();
    Game game = new Game(DEBUG);
		while(!game.isOver()){
			System.out.println(game.boardState.toString());
			game.printState();
			boolean moveMade = false;
			while(!moveMade){
				String move = input.nextLine();
        
        gameLog.append(move + "\n");
        FileWriter file = new FileWriter(filename);
				BufferedWriter write = new BufferedWriter(file);
        write.write(gameLog.toString());
        write.close();
        file.close();

        if(game.move(move)){
					moveMade = true;
				}
				else{
					System.out.println("invalid move");
				}
			}
			game.switchTurns();
		}
		game.printState();
		game.printOutcome();
	}
}
