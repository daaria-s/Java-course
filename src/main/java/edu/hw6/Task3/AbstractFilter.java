package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

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
