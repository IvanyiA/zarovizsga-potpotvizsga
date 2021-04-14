package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    public int encode(String path, char searchedChar) {
        checkParameter(searchedChar);

        return readFile(path, searchedChar);

    }

    private void checkParameter(char searchedChar) {
        if (searchedChar != '0' && searchedChar != '1' && searchedChar != 'x') {
            throw new IllegalArgumentException("Character to search must be 0, 1 or x");
        }
    }

    private int readFile(String path, char searchedChar) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            return countCharacter(searchedChar, reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int countCharacter(char searchedChar, BufferedReader reader) throws IOException {
        String line;
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            for (Character c : line.toCharArray()) {
                if (c.equals(searchedChar)) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
