package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ps.projects.foxy.tawjeehequizezz.R;

public class Select_Screen extends AppCompatActivity {
    Button hadeeth;
    Button ageeda;
    Button sera;
    Button quran;
    Button morle;
    Button faghah;
    TextView unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__screen);

        hadeeth=findViewById(R.id.hadeeth);
        ageeda=findViewById(R.id.ageeda);
        sera=findViewById(R.id.seera);
        quran=findViewById(R.id.quran);
        morle=findViewById(R.id.morle);
        faghah=findViewById(R.id.fagha);
        unit=findViewById(R.id.unit_text);


        Typeface typeface = ResourcesCompat.getFont(Select_Screen.this, R.font.aldhabi);
        unit.setTypeface(typeface);


        hadeeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الحديث النبوي الشريف");
                startActivity(intent);
                finish();
            }
        });


        ageeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","العقيدة");
                startActivity(intent);
                finish();
            }
        });


        sera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","السير و التراجم");
                startActivity(intent);
                finish();
            }
        });


        quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","وحدة القرآن الكريم وعلومه");
                startActivity(intent);
                finish();
            }
        });


        morle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الفكر و الأخلاق");
                startActivity(intent);
                finish();
            }
        });


        faghah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الفقه");
                startActivity(intent);
                finish();
            }
        });







    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(Select_Screen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
