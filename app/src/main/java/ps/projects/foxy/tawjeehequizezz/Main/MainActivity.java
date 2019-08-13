package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.HashMap;

import ps.projects.foxy.tawjeehequizezz.Objects.Game_Question;
import ps.projects.foxy.tawjeehequizezz.Objects.Local_Save;
import ps.projects.foxy.tawjeehequizezz.R;

public class MainActivity extends AppCompatActivity {
    public DatabaseReference databaseRef;
    Local_Save save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

       databaseRef=FirebaseDatabase.getInstance().getReference("Tawjehee");

        new myAsnk().execute();


        Button select_page=findViewById(R.id.next);
        Button exit=findViewById(R.id.exit);


        select_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Select_Screen.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    public class myAsnk extends AsyncTask<DatabaseReference,Integer, String>{

        @Override
        protected String doInBackground(DatabaseReference... databaseReferences) {


            databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    save=new Local_Save();
                    GenericTypeIndicator<HashMap<String,HashMap<String,HashMap<String,Game_Question>>>> gen = new GenericTypeIndicator<HashMap<String, HashMap<String, HashMap<String, Game_Question>>>>() {};
                   save.setDataString("data",ConvertToGson(dataSnapshot.getValue(gen)),MainActivity.this);
                   // Toast.makeText(MainActivity.this,ConvertToGson(dataSnapshot.getValue(gen)),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this,"Error Try Again Later",Toast.LENGTH_LONG).show();
                }

            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

    }

    private String ConvertToGson(HashMap<String,HashMap<String,HashMap<String,Game_Question>>> data){
        Gson gson=new Gson();
        return gson.toJson(data);
    }




}


