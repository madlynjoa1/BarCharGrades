package com.androidclass.barchargrades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarCharDisplay extends AppCompatActivity {

       BarChart barchart;
       BarData barData;
       BarDataSet barDataSet;
       ArrayList barEntries;
       ArrayList<String> labels;
       MainActivity mMaiAct= new MainActivity();
       float bar1Data=0, bar2Data=0, bar3Data=0, bar4Data=0,bar5Data=0;
       String data1, data2, data3, data4,data5;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_bar_char_display);
           Intent intent=getIntent();

           Bundle bundle=getIntent().getExtras();
           //Dta to string
           data1=bundle.getString("bar1");
           data2= bundle.getString("bar2");
           data3=bundle.getString("bar3");
           data4=bundle.getString("bar4");
           data5=bundle.getString("bar5");
           // to integer
           bar1Data= Float.parseFloat(data1);
           bar2Data=Float.parseFloat(data2);
           bar3Data=Float.parseFloat(data3);
           bar4Data=Float.parseFloat(data4);
           bar5Data=Float.parseFloat(data5);

            //bind
           barchart=(BarChart) findViewById(R.id.barChar);
            //call method

           SetData();
           //char bar
           barDataSet=new BarDataSet(barEntries,"CHART DISTRIBUTION GRADES");


           //BarCharDisplay('A','B','C','D','F');
           barData=new BarData(barDataSet);
           boolean b =true ;
           barData.getDataSetByLabel("A's",b);
           barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
           barDataSet.setValueTextColor(Color.BLACK);
         barDataSet.setValueTextSize(25f);
          //label columns
         barDataSet.setLabel("A's Green\t\t\t\t B's Yelllow\t\t\t C's Red\t\t\t\t D's Blue\t\t\t\t F's 2ndGreen");
 //
          //Label chart
           Description description= new Description();
           description.setText("Grades Distribution CHART");
           barchart.setData(barData);
           barchart.setDescription(description);

       }
       private void SetData() {
           // bar1Data=Integer.parseInt(String.valueOf(mMaiAct.getPercentageA()));

           barEntries = new ArrayList<>();
           barEntries.add(new BarEntry(2, bar1Data));
           barEntries.add(new BarEntry(4, bar2Data));
           barEntries.add(new BarEntry(6, bar3Data));
           barEntries.add(new BarEntry(8,bar4Data));
           barEntries.add(new BarEntry(10,bar5Data));


       }

}
/////////////////////////
///package com.androidclass.barchargrades;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Bundle;
//
//import com.github.mikephil.charting.charts.BarChart;
//import com.github.mikephil.charting.components.Description;
//import com.github.mikephil.charting.data.BarData;
//import com.github.mikephil.charting.data.BarDataSet;
//import com.github.mikephil.charting.data.BarEntry;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//import java.util.ArrayList;
//
//public class BarCharDisplay extends AppCompatActivity {
//
//    BarChart barchart;
//    BarData barData;
//    BarDataSet barDataSet;
//    ArrayList barEntries;
//    ArrayList<String> labels;
//    MainActivity mMaiAct= new MainActivity();
//    float bar1Data=0, bar2Data=0, bar3Data=0, bar4Data=0,bar5Data=0;
//    String data1, data2, data3, data4,data5;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bar_char_display);
//        Intent intent=getIntent();
//
//        Bundle bundle=getIntent().getExtras();
//        //Dta to string
//        data1=bundle.getString("bar1");
//        data2= bundle.getString("bar2");
//        data3=bundle.getString("bar3");
//        data4=bundle.getString("bar4");
//        data5=bundle.getString("bar5");
//        // to integer
//        bar1Data= Float.parseFloat(data1);
//        bar2Data=Float.parseFloat(data2);
//        bar3Data=Float.parseFloat(data3);
//        bar4Data=Float.parseFloat(data4);
//        bar5Data=Float.parseFloat(data5);
//
//         //bind
//        barchart=(BarChart) findViewById(R.id.barChar);
//         //call method
//
//        SetData();
//        //char bar
//        barDataSet=new BarDataSet(barEntries,"Distribution Grades");
//        //BarCharDisplay('A','B','C','D','F');
//        barData=new BarData(barDataSet);
//        boolean b =true ;
//        barData.getDataSetByLabel("A's",b);
//
//        barchart.setData(barData);
//        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
//        barDataSet.setValueTextColor(Color.BLACK);
//        barDataSet.setValueTextSize(20f);
//        barDataSet.setLabel("A's Green\t\t\t\t B's Yelllow\t\t C's Red\t\t\t\t D's Blue\t\t\t\t F's 2ndGreen");
//
//
//        Description description= new Description();
//        description.setText("Grades");
//    }
//    private void SetData(){
//       // bar1Data=Integer.parseInt(String.valueOf(mMaiAct.getPercentageA()));
//
//        barEntries=new ArrayList<>();
//        barEntries.add(new BarEntry(2,bar1Data));
//        barEntries.add(new BarEntry(4,bar2Data));
//        barEntries.add(new BarEntry(6,bar3Data));
//        barEntries.add(new BarEntry(8,bar4Data));
//        barEntries.add(new BarEntry(10,bar5Data));
//
//
//
//
//    }
//}