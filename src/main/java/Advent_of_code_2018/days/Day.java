package Advent_of_code_2018.days;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public interface Day {
    Object getResultP1(String input);

    Object getResultP2(String input);

    int getDay();

    default String getInput1() {
        List<String> lines;
        try {
            URI uri = ClassLoader.getSystemClassLoader().getResource("input").toURI();
            String path = Paths.get(uri).toString();

            lines = Files.readAllLines(Paths.get(path, "day" + getDay() + ".txt"));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return StringUtils.join(lines, "\n");
    }

    default String getInput2() {
        return getInput1();
    }

}
