package hr.bulb.tech.model;

import static hr.bulb.tech.Main.VOWELS;
import static hr.bulb.tech.Main.countCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sentence {

    private final List<Word> words;
    private final Character punctuation;

    public Sentence(final String sentence) {

        words = new ArrayList<>();
        final String[] wordsFromSentence = sentence.split(" ");

        Arrays.stream(wordsFromSentence).forEach(word -> this.words.add(new Word(word)));

        this.punctuation = this.words.get(this.words.size() - 1).removeLastCharacter();
    }

    public List<Word> getWords() {
        return words;
    }

    public void shuffleWords() {

        words.get(0).setFirstCharacterToLower();

        Collections.shuffle(words);

        words.get(0).setFirstCharacterToUpper();
        words.get(words.size() - 1).addLastCharacter(punctuation);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        words.forEach(sb::append);

        return sb.append(countVowels(sb.toString())).append("\n").toString();
    }

    private String countVowels(final String sentence) {

        final StringBuilder sb = new StringBuilder();

        VOWELS.forEach(vowel -> sb.append(vowel).append(": ").append(countCharacters(sentence, vowel)).append(" "));

        return sb.toString();
    }

}
