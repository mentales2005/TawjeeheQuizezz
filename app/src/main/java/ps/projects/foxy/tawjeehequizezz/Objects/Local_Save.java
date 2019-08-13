package ps.projects.foxy.tawjeehequizezz.Objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.prefs.Preferences;

public class Local_Save {

    public void setDataString(String key, String value, Context context){
        SharedPreferences preferences = context.getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();

    }
    public String getDataString(String key, Context context){
        SharedPreferences preferences = context.getSharedPreferences("MyPref",0);
        return preferences.getString(key, null);
    }
}
