package com.almasoft.rps;

import com.almasoft.rps.game.RPSGame;
import com.almasoft.rps.model.RPS;
import com.almasoft.rps.model.TakeResult;

import java.util.Scanner;

/**
 * Created by andrey on 15.03.17.
 */
public class Cli {

    private final RPSGame game;

    public Cli(RPSGame game) {
        this.game = game;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        printHelp();

        String input = null;

        do {
            System.out.print("[R, P, S]: ");
            input = scanner.nextLine();
            if (input != null && ! input.trim().isEmpty() && "R|P|S|r|p|s".indexOf(input) > -1) {

                RPS robotMove = game.makeRobotMove();

                TakeResult result = game.makeGameCycle(RPS.valueOfCode(input.charAt(0)));

                System.out.println("My move was: "+robotMove.code()+", you: " + result);
            }
        } while (!(input.equals("E") || input.equals("e")));

    }

    private void printHelp() {
        System.out.println("How to use:\n\tE, e\t-\t for exit game;");
        System.out.println("\tR, r\t-\t for rock;");
        System.out.println("\tP, p\t-\t for paper;");
        System.out.println("\tS, s\t-\t for sci ssors.");
        System.out.println("\n\nPlease enter your choice: ");
    }
}
