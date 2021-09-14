package managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ConsoleCommandManager implements Iterable<String> {
    private Scanner scanner;
    ConsoleCommandManager(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private String current;

            @Override
            public boolean hasNext() {
                try {
                    current = scanner.nextLine();;
                    return true;
                } catch (NoSuchElementException e) {
                    return false;
                }
            }

            @Override
            public String next() {
                return current;
            }
        };
    }
}
