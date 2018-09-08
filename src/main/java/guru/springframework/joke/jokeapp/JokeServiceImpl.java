package guru.springframework.joke.jokeapp;

import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private static final String JOKESFILE = "D:\\usr\\rajamohan\\IdeaProjects\\jokeapp\\src\\main\\resources\\static\\chuck-norris.jokes";

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl() {

        this.chuckNorrisQuotes = ChuckNorrisQuotes.from(JOKESFILE);
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
