package hr.bulb.tech;

import hr.bulb.tech.model.Sentence;
import hr.bulb.tech.model.Text;
import hr.bulb.tech.model.Word;
import java.util.List;

public class Main {

    public static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(final String[] args) throws InterruptedException {

        final String text = """
                Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.
                Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.
                Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.
                Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?
                Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?""";

        final Text text1 = new Text(text);

        final Thread shuffleSentences = new Thread(() -> shuffleSentences(text1));
        final Thread shuffleWords = new Thread(() -> shuffleWords(text1));
        final Thread shuffleCharacters = new Thread(() -> shuffleCharacters(text1));

        shuffleCharacters.start();
        shuffleSentences.start();
        shuffleWords.start();

        shuffleSentences.join();
        shuffleWords.join();
        shuffleCharacters.join();

        System.out.print(text1);

        VOWELS.forEach(vowel -> System.out.println(vowel + ": " + countCharacters(text, vowel)));
    }

    static void shuffleSentences(final Text text) {
        text.shuffleSentences();
    }

    static void shuffleWords(final Text text) {
        text.getSentences().forEach(Sentence::shuffleWords);
    }

    static void shuffleCharacters(final Text text) {
        text.getSentences().forEach(sentence -> sentence.getWords().forEach(Word::shuffleCharacters));
    }

    public static long countCharacters(final String text, final char vowel) {
        return text.chars().filter(character -> Character.toLowerCase(character) == vowel).count();
    }
}
