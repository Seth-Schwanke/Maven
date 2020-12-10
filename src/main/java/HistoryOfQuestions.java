import java.util.ArrayList;
public class HistoryOfQuestions extends RestfulServer {
    public static void main(String[] args) {
    // Get String Question
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

    }
}


