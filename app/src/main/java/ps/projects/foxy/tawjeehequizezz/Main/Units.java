package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ps.projects.foxy.tawjeehequizezz.Objects.CustomAdapter;
import ps.projects.foxy.tawjeehequizezz.Objects.Data_Handle;
import ps.projects.foxy.tawjeehequizezz.R;

public class Units extends AppCompatActivity {
    Data_Handle handle;
    List<String> arrayList=new ArrayList<String>();
    CustomAdapter customAdapter;
    TextView tx;
    String part;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        handle=new Data_Handle();
       // LinearLayout layout=findViewById(R.id.holder);
         ListView layout=findViewById(R.id.holder);
         tx=findViewById(R.id.units_name);

        part=getIntent().getStringExtra("part");
        arrayList.addAll(handle.getKeys(part,Units.this));


        tx.setText(part);
        Typeface typeface = ResourcesCompat.getFont(Units.this, R.font.aldhabi);
        tx.setTypeface(typeface);

        customAdapter=new CustomAdapter(Units.this,R.layout.my_list,arrayList,part,Units.this);
        layout.setAdapter(customAdapter);


        /*
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(Units.this,R.layout.my_list,R.id.list_button,arrayList);
        layout.setAdapter(arrayAdapter);
*/


    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(Units.this,Select_Screen.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
