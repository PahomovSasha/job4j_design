package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = Config.class.getClassLoader().getResource("app.properties.txt").getFile();
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test
    public void whenInvalidKey() {
        String path = Config.class.getClassLoader().getResource("app.properties.txt").getFile();
        Config config = new Config(path);
        config.load();
        assertNull(config.value("connection.username"));
    }
}
