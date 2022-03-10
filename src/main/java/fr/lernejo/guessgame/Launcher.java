package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String args[])
    {
        long max_iter = 1000;
        long max_random = 100;
        Player player = null;
        if (args.length > 0)
        {
            if (args[0] == "-interactive")
            {
                player = new ComputerPlayer();
                max_iter = Long.MAX_VALUE;
            }
            else if (args[0] == "-auto")
            {
                try
                {
                    max_random = Long.parseLong(args[1]);
                    player = new ComputerPlayer();
                }
                catch (Exception e)
                {

                }
            }
        }
        if (player != null)
        {
            Simulation simulation = new Simulation(player);
            simulation.initialize(new SecureRandom().nextLong(max_random));
            simulation.loopUntilPlayerSucceed(max_iter);
        }
        else
        {

        }
    }
}
