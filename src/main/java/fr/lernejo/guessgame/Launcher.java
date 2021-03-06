package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("launcher");

    public static void main(String args[])
    {
        long max_iter = 1000;
        long max_random = new SecureRandom().nextLong(100);
        Player player = null;
        if (args.length > 0)
        {
            if (args[0].equals("-interactive"))
            {
                player = new HumanPlayer();
                max_iter = Long.MAX_VALUE;
            }
            else if (args[0].equals("-auto"))
            {
                try
                {
                    max_random = Long.parseLong(args[1]);
                    player = new ComputerPlayer();
                }
                catch (Exception e)
                {
                    logger.log(e.getMessage());
                }
            }
        }
        if (player != null)
        {
            Simulation simulation = new Simulation(player);
            simulation.initialize(max_random);
            simulation.loopUntilPlayerSucceed(max_iter);
        }
        else
        {
            logger.log("Vous devez soit mettre -auto avec un nombre ou -interactive");
        }
    }
}
