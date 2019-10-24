package com.example.labexer4;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] aName, aVersion, APILevel, date, info;
    ListView list;
    int[] androidLogo = {R.drawable.a1,R.drawable.a2, R.drawable.a3,
            R.drawable.a4,R.drawable.a5,R.drawable.a6,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.a10,R.drawable.a11,R.drawable.a12,
            R.drawable.a13,R.drawable.a14, R.drawable.a15};
    ArrayList<Android> androidList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aName = getResources().getStringArray(R.array.androidTitle);
        aVersion = getResources().getStringArray(R.array.androidVersion);
        APILevel = getResources().getStringArray(R.array.APILevel);
        date = getResources().getStringArray(R.array.releaseDate);
        info = getResources().getStringArray(R.array.androidMessage);
        list = findViewById(R.id.lvVersions);
        for (int i = 0; i< aName.length; i++){
            androidList.add(new Android(androidLogo[i], aName[i],"Ver. "+ aVersion[i],"API Level " + APILevel[i],
                    "Released Date: "+ date[i], info[i]));
        }
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.list,androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getShortMessage());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();
    }
}
