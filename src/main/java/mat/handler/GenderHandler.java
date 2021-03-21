package mat.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import mat.Gender;
import mat.algorithm.Algorithm;
import mat.algorithm.AlgorithmImpl;
import mat.parser.QueryParser;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class GenderHandler implements HttpHandler {

    /**
     *   Handle the given request and generate an appropriate response
     */
    @Override
    public void handle(HttpExchange http) {

        // parse parameters from URI
        Map<String, String> queryParams = QueryParser.parseQueryToParams(http.getRequestURI().toString());
        Algorithm algorithm = new AlgorithmImpl();
        Gender foundGender = algorithm.findGender(queryParams.get("name"), queryParams.get("algorithm"));

        try  {
            http.sendResponseHeaders(200, foundGender.toString().length() );
            OutputStream os = http.getResponseBody();
            os.write(foundGender.toString().getBytes());
            os.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
