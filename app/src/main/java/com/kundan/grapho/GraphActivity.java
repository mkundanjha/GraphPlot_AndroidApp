package com.kundan.grapho;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.lang.Math;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    LineChart chart;
    Button mButton;
    ArrayList<Entry> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        chart=findViewById(R.id.lineChart);
        mButton=findViewById(R.id.button);

        Bundle bundle=getIntent().getExtras();
        String flag=bundle.getString("flag");
        if(Integer.parseInt(flag)==1){
            String slope=bundle.getString("m");
            String intercept=bundle.getString("c");
            String values="Slope= "+ slope +" and intercept= "+ intercept;
            Toast.makeText(getApplicationContext(),values,Toast.LENGTH_LONG).show();
            setEntryValue(slope,intercept);
            createGraph(Color.BLUE);
        }
        else {
            String a = bundle.getString("a");
            String b = bundle.getString("b");
            String c = bundle.getString("d");
            String quadValue ="a= "+a +" b= "+b +" c= "+c;
            Toast.makeText(getApplicationContext(),quadValue,Toast.LENGTH_LONG).show();
            setEntryQuadValue(a,b,c);
            createGraph(Color.GREEN);
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

// Entry value for linear data
    private ArrayList<Entry> setEntryValue(String slope,String intercept){
        data.clear();
        for(int i=0;i<100;i++){
            data.add(new Entry(i,(i*Float.parseFloat(slope))+Float.parseFloat(intercept)));
        }
        return data;
    }

//    Entry value for quadratic data
   private ArrayList<Entry> setEntryQuadValue(String a,String b,String c){
       data.clear();
       for(int i=0;i<10;i++){
           data.add(new Entry(i,((float)Math.pow(i,2) *Float.parseFloat(a))+i*Float.parseFloat(b)+Float.parseFloat(c)));
       }
       return data;

   }


    private void goBack(){
        Intent intent=new Intent(getApplicationContext(),DataInputActivity.class);
        startActivity(intent);
    }
    public void createGraph(int clor){
        //        Creating X-axis
        XAxis xAxis=chart.getXAxis();
        xAxis.setDrawGridLines(false);      // remove vertical grid lines
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);      // set bottom x-axis
        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis3=chart.getAxisLeft();
        yAxis3.setTextColor(Color.WHITE);
        yAxis3.setAxisMaximum(100f);
        yAxis3.setAxisMinimum(0f);


        //      Chart Properties
        chart.getAxisRight().setEnabled(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.setScaleEnabled(false);


        LineDataSet set = new LineDataSet(data, "Graph");

        set.setFillAlpha(30);
        set.setDrawCircles(false);
        set.setDrawValues(false);
        set.setColor(clor);
        set.setLineWidth(3);

        ArrayList<ILineDataSet> dataSets=new ArrayList<>();
        dataSets.add(set);

        LineData data=new LineData(dataSets);
        chart.setData(data);
        chart.animateX(500);


    }

}
