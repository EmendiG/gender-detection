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

    @Override
    public void handle(HttpExchange http) {
        Map<String, String> queryParams = new QueryParser().parseQueryToParams(http.getRequestURI().toString());
        Algorithm algorithm = new AlgorithmImpl();
        Gender gender = algorithm.findGender(queryParams.get("name"));

        try  {
            http.sendResponseHeaders(200, gender.toString().length());
            OutputStream os = http.getResponseBody();
            os.write(gender.toString().getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
