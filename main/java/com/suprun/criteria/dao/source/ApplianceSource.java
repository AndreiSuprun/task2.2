package com.suprun.criteria.dao.source;

import com.suprun.criteria.dao.DAOException;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class ApplianceSource {

    private static final String RESOURCE_FILE = "properties.file";
    private static final String FILE_NAME = "filename";

    public Stream<String> receiveApplianceStream() throws DAOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE);
        String fileName = resourceBundle.getString(FILE_NAME);
        Path path = null;
        Stream<String> applianceStream = Stream.empty();
        URL url = this.getClass().getClassLoader().getResource(fileName);
        if (url != null) {
            path = Path.of(url.getPath().substring(3));
        }
        try{
            applianceStream = Files.lines(path);
        } catch (IOException e) {
            throw new DAOException("File doesn't available", e);
        }
        return applianceStream;
    }
}
