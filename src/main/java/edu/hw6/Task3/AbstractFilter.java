package edu.hw6.Task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import static edu.hw6.Task3.AbstractFilter.globMatches;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.regexContains;

public class AbstractFilter implements DirectoryStream.Filter<Path> {
    Predicate<Path> predicate;

    public AbstractFilter(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean accept(Path entry) {
        return predicate.test(entry);
    }

    public AbstractFilter and(Predicate<Path> newPredicate) {
        predicate = predicate.and(newPredicate);
        return this;
    }
    static Predicate<Path> largerThan(long size) {
        return (Path path) -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

//    static Predicate<Path> magicNumber(int start, char... chars) {
//        return (Path path) -> {
//            new File(path.toString()).
//        }
//
//    }

    static Predicate<Path> globMatches(String glob) {
        return (Path path) -> path.getFileName().toString().matches(glob);
    }


    static Predicate<Path> regexContains(String pattern) {
        return (Path path) -> Pattern.compile(pattern).matcher(path.getFileName().toString()).find();
    }
}


class Main {
    public static void main(String[] args) {

        Predicate<Path> p;
//        final AbstractFilter regularFile = new AbstractFilter();

        AbstractFilter regularFile = new AbstractFilter(Files::isRegularFile);

        regularFile.and(Files::isReadable).and(largerThan(100_000)).and(Files::isRegularFile)
//            .and(magicNumber(0x89, 'P', 'N', 'G'));
            .and(globMatches("*.png"))
            .and(regexContains("[-]"));

    }
}
