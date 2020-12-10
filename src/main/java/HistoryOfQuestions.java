import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
public class HistoryOfQuestions extends RestfulServer {
    public static void main(String[] args) {

        String question = ""; //store question into string
        ArrayList<String> q = new ArrayList<>(); //arraylists of strings to hold questions
        if(question == "!History"){ //check if it is asking for the history
            read(q); //read out history
        }
        else { //question needs to be added to arraylist
            q.add(question);//add it
        }
    /*// Get String Question
    String test = "test";
    ArrayList<String> ASKED = new ArrayList<String>();
    ArrayList<String> ANSWERED = new ArrayList<String>();

    // Check if question has already been asked
    // If yes return string to RestfulServer
    // If no add to arraylist
     if(ASKED.contains(test)) {
        System.out.println("Has already been asked");
        // Return previous Answer

    }else{
         ASKED.add(test);
    }

    */}
    public static void read(ArrayList<String> storage){
        for (String s : storage) {
            System.out.println(s);
        }

    }
}


