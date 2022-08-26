package org.http.request.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HttpStreamReader implements HttpReader {

    private static final Logger logger = LoggerFactory.getLogger(HttpStreamReader.class);

    @Override
    public List<String> read(InputStream inputStream) {

        try {
            Scanner scan = new Scanner(new String(inputStream.readAllBytes()));
            List<String> packetLines = new ArrayList<>();

            while (scan.hasNextLine()) {
                packetLines.add(scan.nextLine());
            }

            inputStream.close();

            return packetLines;

        } catch (IOException e) {
            logger.error("Error while reading client request.", e.getCause());
        }

        return Collections.emptyList();
    }

}