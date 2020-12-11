import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class HistoryOfQuestions extends RestfulServer {
    public static void main(String[] args) {

        String question = ""; //store question into string
        ArrayList<String> q = new ArrayList<>(); //arraylists of strings to hold questions
        ArrayList<String> Answer = new ArrayList<>();
        if(question == "!History"){ //check if it is asking for the history
            read(q); //read out history
        }
        //else if(question == "what is the weather outside?"){
        // return "it is 25 degrees outside with a 30% chance of snow";
        //}
        else { //question needs to be added to arraylist
            q.add(question);//add it
        }
    }
    public static void read(ArrayList<String> storage){
        for (String s : storage) {
            System.out.println(s);
        }

    }
}


