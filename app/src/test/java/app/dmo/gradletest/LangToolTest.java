package app.dmo.gradletest;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LangToolTest {

    @Test
    void mainShouldLoadENText() throws IOException {
        var standardOut = System.out;
        var outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        LangTool.main("EN");
        assertThat(outputStreamCaptor.toString().trim()).contains("Hellooooooo World!");


        System.setOut(standardOut);
    }

    @Test
    void mainShouldThrowIfInputWasEmpty() throws IOException {
        assertThatThrownBy(() -> LangTool.main())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 arg");
    }

    @Test
    void mainShouldThrowIfInputArgsWereNull() throws IOException {
        assertThatThrownBy(() -> LangTool.main((String) null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 arg");
    }

    @Test
    void mainShouldThrowIfInputArgsWasNull() throws IOException {
        assertThatThrownBy(() -> LangTool.main((String[]) null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 arg");
    }

    @Test
    void mainShouldThrowIfTooManyInputs() throws IOException {
        assertThatThrownBy(() -> LangTool.main("EN", "EN"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 arg");
    }

    @Test
    void mainShouldThrowIfUnknownInputs() throws IOException {
        assertThatThrownBy(() -> LangTool.main("FOO"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("FOO");
    }


}
