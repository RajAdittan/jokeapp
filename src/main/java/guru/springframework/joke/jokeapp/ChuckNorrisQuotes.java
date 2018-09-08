package guru.springframework.joke.jokeapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ChuckNorrisQuotes {

    private final ArrayList<String> quotes;



    private ChuckNorrisQuotes(List<String> quoteList) {
        this.quotes = new ArrayList<>(quoteList);
    }

    public static ChuckNorrisQuotes from(String fileName) {

        if(Files.exists(Paths.get(fileName))) {
            try {
                return new ChuckNorrisQuotes(Files.readAllLines(Paths.get(fileName)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String getRandomQuote() {
        int randomPosition = (int) (System.nanoTime() % quotes.size());
        return quotes.get(randomPosition);
    }
}
