package com.github.kolorobot.files;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {
    public void writeTo(String path, String content) throws IOException {
        Path target = Paths.get(path);
        if (Files.exists(target)) {
            throw new IOException("file already exists");
        }
        Files.copy(new ByteArrayInputStream(content.getBytes("UTF8")), target);
    }
}
