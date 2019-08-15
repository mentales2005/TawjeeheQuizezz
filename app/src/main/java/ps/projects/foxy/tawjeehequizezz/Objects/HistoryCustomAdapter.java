package ps.projects.foxy.tawjeehequizezz.Objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import ps.projects.foxy.tawjeehequizezz.Main.QuestionHistory;
import ps.projects.foxy.tawjeehequizezz.R;

public class HistoryCustomAdapter extends ArrayAdapter {
    private Context context;
    private TextView question;
    private TextView answer;
    private List<String> values;
    private  List<String> keys;

    public HistoryCustomAdapter(Context context, int resource, List objects,List objects2) {
        super(context, resource, objects);
        this.context=context;
        this.values=objects;
        this.keys=objects2;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.my_history_list, null);

        question=convertView.findViewById(R.id.text_question);
        answer=convertView.findViewById(R.id.text_answer);

        question.setText(keys.get(position));
        answer.setText(values.get(position));


        //question.setText(values.get(position));
        //answer.setText(keys.get(position));


        return convertView;
    }
}
