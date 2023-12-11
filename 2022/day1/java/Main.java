package day1.java;

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        var path = Objects.requireNonNull(Main.class.getClassLoader().getResource("")).getPath();
        var file = new File(path + "/day1/input.txt");

        var content = "";
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            content = new String(bytes);
        }

        String[] split = content.split("\r\n");

        var max = 0;
        var sum = 0;
        for (String line : split) {
            if ("".equals(line)) {
                max = Math.max(max, sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }

        System.out.println(max);
    }
}