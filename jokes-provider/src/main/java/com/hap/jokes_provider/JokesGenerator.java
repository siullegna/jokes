package com.hap.jokes_provider;

import java.util.ArrayList;
import java.util.Random;

public final class JokesGenerator {
    private static ArrayList<Joke> jokes = null;

    private JokesGenerator() {

    }

    private static ArrayList<Joke> getJokes() {
        if (jokes == null) {
            jokes = new ArrayList<>();
            jokes.add(new Joke("Q: What is black, white, and red all over?", "A: A sunburnt penguin!"));
            jokes.add(new Joke("Q: Why do cows go to New York?", "A: To see the moosicals!"));
            jokes.add(new Joke("Q: Where did the sheep go on vacation?", "A: The baaaahamas"));
            jokes.add(new Joke("Q: Where do orcas hear music?", "A: Orca-stras!"));
            jokes.add(new Joke("I invited my boyfriend to go to the gym with me, but he stood me up. I guess the two of us aren’t going to work out."));
            jokes.add(new Joke("Q. Why shouldn’t you marry a tennis player?", "A. Because Love means nothing to them."));
            jokes.add(new Joke("A musician told me he was going to hit me with the neck of his guitar. I replied, “Is that a fret?”"));
            jokes.add(new Joke("Q: What did the elephant want for his birthday?", "A: A trunk full of gifts."));
            jokes.add(new Joke("Q: What do you say to your goldfish on his birthday?", "A: Have a fin-tastic day."));
        }
        return jokes;
    }

    public static Joke getJoke() {
        final Random random = new Random();
        final ArrayList<Joke> jokes = getJokes();
        final int index = random.nextInt(jokes.size());
        return jokes.get(index);
    }
}
