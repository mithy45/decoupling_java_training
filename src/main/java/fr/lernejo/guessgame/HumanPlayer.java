package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    private Scanner scanner = new Scanner(System.in);

    public long askNextGuess() {
        while (true) {
            logger.log("Veuillez saisir un nombre deviné par le jeu !");
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.log("Ce n'est pas un nombre");
            } catch (Exception e) {
                logger.log(e.getMessage());
                return -1;
            }
        }
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

