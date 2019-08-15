package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import ps.projects.foxy.tawjeehequizezz.Objects.HistoryCustomAdapter;
import ps.projects.foxy.tawjeehequizezz.R;

public class QuestionHistory extends AppCompatActivity {

    ArrayList<String> list_question =new ArrayList<String>();
    ArrayList<String> list_answers=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_history);

        list_question=getIntent().getStringArrayListExtra("his_ques");
        list_answers=getIntent().getStringArrayListExtra("his_answ");

        Button back=findViewById(R.id.back_button);
        ListView listView=findViewById(R.id.list_history);



        HistoryCustomAdapter customAdapter=new HistoryCustomAdapter(QuestionHistory.this,R.layout.my_history_list,list_answers,list_question);
        listView.setAdapter(customAdapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuestionHistory.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}
