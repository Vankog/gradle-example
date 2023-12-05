package app.dmo.gradletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

public class LangTool {
    enum Lang {
        EN
    }

    public static void main(final String... args) throws IOException {
        if (args == null || args.length != 1 || args[0] == null)
            throw new IllegalArgumentException("Expecting 1 arg");

        var lang = Lang.valueOf(args[0]);
        var greetingStream = requireNonNull(LangTool.class.getResourceAsStream(lang + ".txt"), "unknown language");
        try (var reader = new BufferedReader(new InputStreamReader(greetingStream, StandardCharsets.UTF_8))) {
            System.out.println(reader.readLine());
        }

    }
}
