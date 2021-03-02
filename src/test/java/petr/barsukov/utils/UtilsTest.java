package petr.barsukov.utils;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UtilsTest {
    private static final String TEST_MESSAGE = "testMessage";
    private static final String TEST_MESSAGE_ENCODE = "dGVzdE1lc3NhZ2U=";

    @Test
    public void whenEncodeMessage() {
        String actual = Utils.encodeBase64(TEST_MESSAGE);
        assertThat(actual, is(TEST_MESSAGE_ENCODE));
    }

    @Test
    public void whenDecodeMessage() {
        String actual = Utils.decodeBase64(TEST_MESSAGE_ENCODE);
        assertThat(actual, is(TEST_MESSAGE));
    }
}