import spark.Spark;
import spark.Request;
import spark.Response;

<<<<<<< HEAD
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
=======
public class RestfulServer{
    public RestfulServer(){
        this.configureRestfulApiServer();
        this.processRestfulApiRequests();
    }
    private void configureRestfulApiServer(){
        spark.port(8080);
        System.out.println("Server configured to listen on port 8080");
    }

    private void processRestfulApiRequests(){
        spark.get("/", this::echoRequest);
    }

    private String echoRequest(Request request, Responce, responce){
        responce.type("application/json");
        response.header("Access-Control-Allow-Origin", "*");
        response.status(200);

        return HttpRequestToJson(request);
    }

    private String HttpRequestToJson(Request request){
>>>>>>> CS370MavenProject/master
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
<<<<<<< HEAD
                + "\"serverport\":\"" + request.port() + "\",\n"
                + "\"protocol\":\"" + request.protocol() + "\",\n"
                + "\"queryParams\":\"" + request.queryParams() + "\",\n"
                + "\"requestMethod\":\"" + request.requestMethod() + "\",\n"
=======
                + "\"serverPort\":\"" + request.port() + "\",\n"
                + "\"protocol\":\"" + request.protocol() + "\",\n"
                + "\"queryParams\":‘"" + request.queryParams() + "\",\n"
                + "\"requestMethod:\"' + request.requestMethod() + "\",\n"
>>>>>>> CS370MavenProject/master
                + "\"scheme\":\"" + request.scheme() + "\",\n"
                + "\"servletPath\":\"" + request.servletPath() + "\",\n"
                + "\"session\":\"" + request.session() + "\",\n"
                + "\"uri()\":\"" + request.uri() + "\",\n"
<<<<<<< HEAD
                + "\"url()\":\"" + request.url() + "\",\n"
                + "\"userAgent\":\"" + request.userAgent() + "\",\n"
                + "}";
    }

    //Just calls construction of Restful server
    public static void main(String[] programArgs) {
        RestfulServer restfulServer = new RestfulServer(); // NEVER RETURNS!!
    }
}
=======
                + "\"url()\":\""  + request.url() + "\",\n"
                + "\"userAgent\":\""  + request.userAgent() + "\",\n"
                + "}";
    }
    public static void main(String[] programArgs){
        RestfulServer restfulServer= new RestfulServer();
    }

}
>>>>>>> CS370MavenProject/master
