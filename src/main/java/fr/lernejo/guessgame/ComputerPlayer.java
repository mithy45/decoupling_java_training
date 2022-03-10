package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{

    private long nb_guessed;
    private long max = Long.MAX_VALUE;
    private long min = 0;

    @Override
    public long askNextGuess(){
        nb_guessed = (max + min) / 2;
        return nb_guessed;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) // Plus grand
        {
            min = nb_guessed;
        }
        else
        {
            max = nb_guessed;
        }
    }
}
