package com.guzova;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Book> books = parseFile("input.txt");
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        writeToFile1("output1.txt", books);
        System.out.println("Введите цену: ");
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        writeToFile2("output2.txt", books, p);
        System.out.println("Суммарная стоимость: " + getFullPrice(books));
    }

    private static int getFullPrice(List<Book> books) {
        int fullPrice = 0;
        for (Book b : books) {
            fullPrice += b.getPrice() * b.getCount();
        }
        return fullPrice;
    }

    private static void writeToFile2(String file, List<Book> books, int p) throws IOException {
        FileWriter fw = new FileWriter(file);
        for (Book b : books) {
            if (b.getPrice() > p) {
                fw.write(b.toString());
                fw.write(System.lineSeparator());
            }
        }
        fw.close();
    }

    private static void writeToFile1(String file, List<Book> books) throws IOException {
        FileWriter fw = new FileWriter(file);
        for (Book b : books) {
            fw.write(b.toString());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    private static List<Book> parseFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        List<Book> books = new ArrayList<>();
        while (sc.hasNextLine()) {
            Book book = new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            books.add(book);
        }
        return books;
    }


}
