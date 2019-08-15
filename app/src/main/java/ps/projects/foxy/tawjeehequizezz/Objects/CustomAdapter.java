package ps.projects.foxy.tawjeehequizezz.Objects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ps.projects.foxy.tawjeehequizezz.Main.Game_View;
import ps.projects.foxy.tawjeehequizezz.Main.Units;
import ps.projects.foxy.tawjeehequizezz.R;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private Button itemButton;
    private List<String> listValues;
    String part;
    Activity activity;


    public CustomAdapter(Context context, int resource, List<String> objects, String part, Activity activity) {
        super(context, resource, objects);
        this.context=context;
        this.listValues=objects;
        this.part=part;
        this.activity=activity;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.my_list, null);


        itemButton = convertView.findViewById(R.id.list_button);
        itemButton.setText(listValues.get(position));
        //To lazy to implement interface
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, Game_View.class);
                intent.putExtra("part",part);
                intent.putExtra("unit",String.valueOf(getItem(position)));
                context.startActivity(intent);
                activity.finish();


            }
        });

        return convertView;
    }
}
