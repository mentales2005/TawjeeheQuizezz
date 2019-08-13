package ps.projects.foxy.tawjeehequizezz.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ps.projects.foxy.tawjeehequizezz.R;

public class Select_Screen extends AppCompatActivity {
    Button hadeeth;
    Button ageeda;
    Button sera;
    Button quran;
    Button morle;
    Button faghah;


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


        hadeeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الحديث النبوي الشريف");
                startActivity(intent);
            }
        });


        ageeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","العقيدة");
                startActivity(intent);
            }
        });


        sera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","السير و التراجم");
                startActivity(intent);
            }
        });


        quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","وحدة القرآن الكريم وعلومه");
                startActivity(intent);
            }
        });


        morle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الفكر و الأخلاق");
                startActivity(intent);
            }
        });


        faghah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Select_Screen.this,Units.class);
                intent.putExtra("part","الفقه");
                startActivity(intent);
            }
        });







    }
}
