package com.example.elavi.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     ListView timetablelistview;
    public  void generatetimetable(int timetableno) {

        Log.i("Seek bar value is", Integer.toString(timetableno));

        ArrayList<String> tablecontent = new ArrayList<>();
        for (int j = 1; j <=10; j++) {
            tablecontent.add(Integer.toString(j * timetableno));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tablecontent);
        timetablelistview.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timetableseekbar=findViewById(R.id.timetableseekbar);
        timetablelistview=findViewById(R.id.timetablelistview);
        timetableseekbar.setMax(100);
        timetableseekbar.setProgress(1);
        generatetimetable(1);
        timetableseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timetableno;
                if(i<min)
                    timetableno=min;
                else
                {
                    timetableno=i;
                }
             generatetimetable(timetableno);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
