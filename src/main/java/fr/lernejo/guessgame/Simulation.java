package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

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
        while(!nextRound() && ++i != iter);
        long fin = System.currentTimeMillis() - deb;
        logger.log(new SimpleDateFormat("mm:ss:SSS").format(new Date(fin)));
    }
}
