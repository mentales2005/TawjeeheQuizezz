package ps.projects.foxy.tawjeehequizezz.Objects;

import android.content.Context;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Data_Handle {

    Local_Save save;
    HashMap<String,HashMap<String, HashMap<String,Game_Question>>> database;

    public Set<String> getKeys(String part, Context context){
        save=new Local_Save();
        Gson gson=new Gson();
        database=gson.fromJson(save.getDataString("data",context),
                new TypeToken<HashMap<String,HashMap<String,
                        HashMap<String,Game_Question>>>>(){}.getType());
       return database.get(part).keySet();

    }

    public HashMap<String,Game_Question> getQuestion(String part,String unit,Context context){
        save=new Local_Save();
        Gson gson=new Gson();
        database=gson.fromJson(save.getDataString("data",context),
                new TypeToken<HashMap<String,HashMap<String,
                        HashMap<String,Game_Question>>>>(){}.getType());

        return database.get(part).get(unit);

    }

    public ArrayList<String> listQuestionShuffled( HashMap<String, Game_Question> question){
        ArrayList<String> questionNumber=new ArrayList<String>();
        for (String str : question.keySet()){
            questionNumber.add(str);
        }
        Collections.shuffle(questionNumber);
        return questionNumber;

    }


    public ArrayList<String> AnswerShuffled(HashMap<String, Game_Question> question,ArrayList<String> listQuestionShuffled, int count ){
        ArrayList<String> answers1= new ArrayList<String>();
        answers1.add(question.get(listQuestionShuffled.get(count)).getF1());
        answers1.add(question.get(listQuestionShuffled.get(count)).getF2());
        answers1.add(question.get(listQuestionShuffled.get(count)).getF3());
        answers1.add(question.get(listQuestionShuffled.get(count)).getCorrect());
        Collections.shuffle(answers1);
        return answers1;

    }



}
