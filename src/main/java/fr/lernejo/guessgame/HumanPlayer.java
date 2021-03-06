package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);

    public long askNextGuess() {
        logger.log("Veuillez saisir un nombre deviné par le jeu !");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (Exception e) {
            logger.log(e.getMessage());
        }
        return -1;
    }

    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater)
        {
            logger.log("Trop grand !");
        }
        else
        {
            logger.log("Trop petit !");
        }
    }
}

