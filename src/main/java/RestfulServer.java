import spark.Spark;
import spark.Request;
import spark.Response;

public class RestfulServer {

    public RestfulServer() {
        this.configureRestfulAPIServer();
        this.processRestfulAPIRequests();
    }

    public void configureRestfulAPIServer() {
        //Start Spark Microserver listening on port specified
        Spark.port(8080);
    }

    // Configures request routes
    private void processRestfulAPIRequests() {
        Spark.get("/", this::echoRequest);
    }

    //Method that implements a spark route
    private String echoRequest(Request request, Response response) {
        response.type("application/json");

        response.header("Access-Control-Allow-Origin", "*");

        // Set to 200 which is HTTP status for SUCCESS
        response.status(200);

        // shows almost everything about original HTTP request
        return HttpRequestToJson(request);
    }

    // Returns all properties of requests coming IN
    private String HttpRequestToJson(Request request) {
        return "{\n"
                + "\"attributes\":\"" + request.attributes() + "\",\n"
                + "\"body\":\"" + request.body() + "\",\n"
                + "\"contentLength\":\"" + request.contentLength() + "\",\n"
                + "\"contentType\":\"" + request.contentType() + "\",\n"
                + "\"contextPath\":\"" + request.contextPath() + "\",\n"
                + "\"cookies\":\"" + request.cookies() + "\",\n"
                + "\"headers\":\"" + request.headers() + "\",\n"
                + "\"host\":\"" + request.host() + "\",\n"
                + "\"ip\":\"" + request.ip() + "\",\n"
                + "\"params\":\"" + request.params() + "\",\n"
                + "\"pathInfo\":\"" + request.pathInfo() + "\",\n"
                + "\"serverport\":\"" + request.port() + "\",\n"
                + "\"protocol\":\"" + request.protocol() + "\",\n"
                + "\"queryParams\":\"" + request.queryParams() + "\",\n"
                + "\"requestMethod\":\"" + request.requestMethod() + "\",\n"
                + "\"scheme\":\"" + request.scheme() + "\",\n"
                + "\"servletPath\":\"" + request.servletPath() + "\",\n"
                + "\"session\":\"" + request.session() + "\",\n"
                + "\"uri()\":\"" + request.uri() + "\",\n"
                + "\"url()\":\"" + request.url() + "\",\n"
                + "\"userAgent\":\"" + request.userAgent() + "\",\n"
                + "}";
    }

    //Just calls construction of Restful server
    public static void main(String[] programArgs) {
        RestfulServer restfulServer = new RestfulServer(); // NEVER RETURNS!!
    }
}
