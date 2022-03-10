package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nb_guessed = player.askNextGuess();
        if (nb_guessed == numberToGuess) {
            logger.log("Bien joué... Vous avez trouvé !");
            return true;
        }
        if (nb_guessed > numberToGuess)
        {
            player.respond(false);
        }
        else
        {
            player.respond(true);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long iter) {
        long i = 0;
        long deb = System.currentTimeMillis();
        while(!nextRound() && i != iter)
        {
            i++;
        }
        long fin = System.currentTimeMillis() - deb;
        Duration d = Duration.ofMillis(fin);
        logger.log(d.toMinutesPart() + ":" + d.toSecondsPart() + "." + d.toMillisPart());

    }
}
