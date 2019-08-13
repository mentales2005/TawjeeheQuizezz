package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ps.projects.foxy.tawjeehequizezz.Objects.Data_Handle;
import ps.projects.foxy.tawjeehequizezz.R;

public class Units extends AppCompatActivity {
    Data_Handle handle;
    List<String> arrayList=new ArrayList<String>();
    Button btn;
    String part;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        handle=new Data_Handle();
       // LinearLayout layout=findViewById(R.id.holder);
         ListView layout=findViewById(R.id.holder);


        part=getIntent().getStringExtra("part");
        arrayList.addAll(handle.getKeys(part,Units.this));


        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(Units.this,android.R.layout.simple_list_item_1,arrayList);
        layout.setAdapter(arrayAdapter);

        layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(Units.this,Game_View.class);
                intent.putExtra("part",part);
                intent.putExtra("unit",arrayAdapter.getItem(i));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
