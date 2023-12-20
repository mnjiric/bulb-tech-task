package hr.bulb.tech.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Text {

    private final List<Sentence> sentences;

    public Text(final String text) {

        sentences = new ArrayList<>();
        final String[] sentencesFromText = text.split("\n");

        Arrays.stream(sentencesFromText).forEach(sentence -> this.sentences.add(new Sentence(sentence)));
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void shuffleSentences() {
        Collections.shuffle(sentences);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        sentences.forEach(sb::append);

        return sb.toString();
    }
}
