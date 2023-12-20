package hr.bulb.tech.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {

    private final List<Character> characters;

    public Word(final String word) {

        characters = new ArrayList<>();

        for (final char character : word.toCharArray()) {
            if(character != ',') {
                characters.add(character);
            }
        }
    }

    public void shuffleCharacters() {

        final char firstCharacter= characters.remove(0);
        final char lastCharacter= characters.remove(characters.size() - 1);

        Collections.shuffle(characters);

        characters.add(0, firstCharacter);
        characters.add(lastCharacter);
    }

    public void setFirstCharacterToLower() {
        characters.set(0, Character.toLowerCase(characters.get(0)));
    }

    public void setFirstCharacterToUpper() {
        characters.set(0, Character.toUpperCase(characters.get(0)));
    }

    public Character removeLastCharacter() {
        return characters.remove(characters.size() - 1);
    }

    public void addLastCharacter(final Character character) {
        characters.add(character);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        characters.forEach(sb::append);

        return sb.append(" ").toString();
    }

}
