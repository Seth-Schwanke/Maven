import spark.Spark;
import spark.Request;
import spark.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//spark plugins

public class RestfulServer{
    private final Logger log = LoggerFactory.getLogger(RestfulServer.class); //setting up log

    public HistoryOfQuestions HOQ = new HistoryOfQuestions();

    public RestfulServer(){
        this.configureRestfulApiServer();
        this.processRestfulApiRequests();
    }
    private void configureRestfulApiServer(){
        Spark.port(8080); //set port to 8080
        System.out.println("Server configured to listen on port 8080");//tell user what port to look at on localhost
    }

    private void processRestfulApiRequests(){
        Spark.get("/", this::echoRequest);
        //Spark.post("/", this::echoRequest);//use this for sending things back
        Spark.post("/", this::Logger);
        //use above to print out body
    }

    String Logger(Request request, Response response) {
        response.type("application/json"); //set response type to json
        response.header("Access-Control-Allow-Origin", "*"); //set header
        response.status(200); //set status code

        System.out.println(request.body()); //print out body

        String requestBody = request.body();

        // Send requestBody to Receiver here
        String answer = Receiver(requestBody);

        System.out.println(answer);

        return (answer); //return body
    }

    String echoRequest(Request request, Response response){
        response.type("application/json"); //set response type
        response.header("Access-Control-Allow-Origin", "*"); //set header
        response.status(200); //set status code

        return HttpRequestToJson(request); //return request after it has gone through httprequest
    }

    private String HttpRequestToJson(Request request){
        return "{\n" //string with information about the server
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
        RestfulServer restfulServer= new RestfulServer(); //create new restful server
    }

    String Receiver(String currentQuestion) {


        if(currentQuestion.equals("!history")){
            return HOQ.read(HOQ.q, HOQ.Answer);
        }

        HOQ.question = currentQuestion;


        String rtrnAnsw = HOQ.store(currentQuestion);

        if(rtrnAnsw.equals("NULL")) {
            return ("Invalid String entered!");
        }
        else {
            return(rtrnAnsw);
        }



        /*
        if(question.endsWith("?")) { // Check if a question (does it end with a question mark?)
            String answer;



            if(answer.equals(null))  {
                return(answer);
            } else {
                answer= HOQ.store(question);

                return answer;
            }
        } else if(question.equals("!history")) {
            return HOQ.read();
        } else { // return string error to restfulserver class that describes the issue
            return "ERROR- Invalid string entered, please make sure it ends with a '?'";
        }*/
    }
}