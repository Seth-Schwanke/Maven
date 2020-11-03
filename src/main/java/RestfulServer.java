import spark.Spark;
import spark.Request;
import spark.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestfulServer{
    private final Logger log = LoggerFactory.getLogger(RestfulServer.class);

    public RestfulServer(){
        this.configureRestfulApiServer();
        this.processRestfulApiRequests();
    }
    private void configureRestfulApiServer(){
        Spark.port(8080);
        System.out.println("Server configured to listen on port 8080");
    }

    private void processRestfulApiRequests(){
        Spark.get("/", this::echoRequest);
        Spark.post("/", this::echoRequest);//use this for sending things back
        Spark.post("/body", this::logToConsole);
        //use above to print out body
    }
    String logToConsole(Request request, Response response){
        response.type("/json");
        response.header("Access-Control-Allow-Origin", "*");
        response.status(200);
        String modifiedBody = editBody(request.body());
        System.out.println(modifiedBody);
        return modifiedBody;
    }

     String echoRequest(Request request, Response response){
        response.type("application/json");
        response.header("Access-Control-Allow-Origin", "*");
        response.status(200);
        return HttpRequestToJson(request);
    }

    // Manipulates body by reversing it
    public String editBody(String body) {
        return new StringBuilder(body).reverse().toString();
    }

    private String HttpRequestToJson(Request request){
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
                + "\"serverPort\":\"" + request.port() + "\",\n"
                + "\"protocol\":\"" + request.protocol() + "\",\n"
                + "\"queryParams\":\"" + request.queryParams() + "\",\n"
                + "\"requestMethod:\":\"" + request.requestMethod() + "\",\n"
                + "\"scheme\":\"" + request.scheme() + "\",\n"
                + "\"servletPath\":\"" + request.servletPath() + "\",\n"
                + "\"session\":\"" + request.session() + "\",\n"
                + "\"uri()\":\"" + request.uri() + "\",\n"
                + "\"url()\":\""  + request.url() + "\",\n"
                + "\"userAgent\":\""  + request.userAgent() + "\",\n"
                + "}";
    }

    public static void main(String[] programArgs){
        RestfulServer restfulServer= new RestfulServer();

    }

}