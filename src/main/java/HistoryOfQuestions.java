import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class HistoryOfQuestions {

    String question; //store question into string
    ArrayList<String> q = new ArrayList<>(); //arraylists of strings to hold questions
    ArrayList<String> Answer = new ArrayList<>();

    public String store(String quest){
        q.add(quest);
        String temp = "";
        String temp2 = answer(quest, temp);
        Answer.add(temp2);
        return temp2;
    }

    public String answer(String qstn, String tmpo){
        if(qstn.equals("what is the weather like today?")){
            tmpo = "It is 25 degrees outside with a 30% chance of snow";
            return tmpo;
        }
        else if(qstn.equals("how many states are there?")){
            tmpo = "There are 50 states in the United States";
            return tmpo;
        }
        else if(qstn.equals("what is todays date?")){
            tmpo = "today is the 11th of december";
            return tmpo;
        }
        else{
            tmpo = "GOOGLE ASSISTANT ANSWER HERE";
            return tmpo;
        }
    }

    public String read(ArrayList<String> storage, ArrayList<String> answers) {
       String tempBOI = "";
        for(int i = 0; i < storage.size(); i++){
           tempBOI += (storage.get(i) + "\n");
           tempBOI += (answers.get(i) + "\n");
       }
        return tempBOI;
    }
}


