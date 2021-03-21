package mat.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import mat.Gender;
import mat.parser.FileParser;
import mat.parser.FileParserImpl;
import mat.parser.QueryParser;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.stream.Stream;

public class TokensHandler implements HttpHandler {

    /**
     *   Handle the given request and generate an appropriate response
     */
    @Override
    public void handle(HttpExchange http) {

        Map<String, String> queryParams = QueryParser.parseQueryToParams(http.getRequestURI().toString());
        Gender pickedGender = Gender.valueOf(queryParams.get("gender").toUpperCase());

        FileParser fileParser = new FileParserImpl(pickedGender);
        long numberOfCharacters = fileParser.getNumberOfCharacters();
        Stream<String> fileStream = fileParser.getFileStream();

        try {
            http.sendResponseHeaders(200, numberOfCharacters );
            OutputStream os = http.getResponseBody();

            fileStream.forEach(line -> {
                try {
                    os.write(line.getBytes());
                    os.write("\n".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
