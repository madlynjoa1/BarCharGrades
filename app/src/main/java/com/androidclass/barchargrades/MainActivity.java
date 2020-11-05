package com.androidclass.barchargrades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText totalStudents;
    EditText gradeA, gradeB, gradeC, gradeD, gradeF;
    Button calculate;
    String percentageA, percentageB,percentageC, percentageD, percentageF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalStudents=findViewById(R.id.totalNumStudentsET);
        gradeA=findViewById(R.id.grade1AET);
        gradeB=findViewById(R.id.grade2BET);
        gradeC=findViewById(R.id.grade3CET);
        gradeD=findViewById(R.id.grade4DET);
        gradeF=findViewById(R.id.grade5EET);

        calculate=findViewById(R.id.calculateButton);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog();



            }
        });

    }

    private String format() {
        // a letetr 20 *100/totalStu
        StringBuilder result = new StringBuilder();
        double studentsTotalNum=Double.parseDouble(totalStudents.getText().toString());
        double gradeAValue= Double.parseDouble(gradeA.getText().toString());
        double gradeBValue= Double.parseDouble(gradeB.getText().toString());
        double gradeCValue=Double.parseDouble(gradeC.getText().toString());
        double gradeDValue=Double.parseDouble(gradeD.getText().toString());
        double gradeFValue=Double.parseDouble(gradeF.getText().toString());
        //string to double


        if(gradeAValue+gradeBValue+gradeCValue+gradeDValue+gradeFValue==studentsTotalNum) {
            // Calculate precentage
            //setPercentageA((gradeAValue * 100) / studentsTotalNum);
            percentageA= String.valueOf((gradeAValue*100)/studentsTotalNum);
            percentageB = String.valueOf((gradeBValue * 100)/ studentsTotalNum);
            percentageC = String.valueOf((gradeCValue * 100) / studentsTotalNum);
            percentageD = String.valueOf((gradeDValue * 100) / studentsTotalNum);
            percentageF = String.valueOf((gradeFValue * 100) / studentsTotalNum);

            result.append("As:").append(percentageA).append("\n").append("Bs: ").append(percentageB).append("\n").append("Cs: " + percentageC + "\n").append("Ds: " + percentageD + "\n").append("Fs: " + percentageF + "\n");

            return result.toString();
        }
        else{
            result.append("Inputs don't match total number of students");
            return result.toString();

        }

    }

    private void OpenDialog() {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setCancelable(false);//is when you click outside the dialog it closes
        builder.setTitle("Percentages of grade distribution are: ");
        //get result display here
        if(format().equals("Inputs don't match total number of students")){
            Toast.makeText(getApplicationContext(),"Input don't add to total number of students", Toast.LENGTH_LONG).show();
        }
        else {
            builder.setMessage(format());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    calculate.setVisibility(View.VISIBLE);
                    Intent calculateBar = new Intent(MainActivity.this, BarCharDisplay.class);
                    calculateBar.putExtra("bar1",percentageA);
                    calculateBar.putExtra("bar2",percentageB);
                    calculateBar.putExtra("bar3",percentageC);
                    calculateBar.putExtra("bar4",percentageD);
                    calculateBar.putExtra("bar5",percentageF);
                    startActivity(calculateBar);

                }
            });
            builder.show();
        }
    }

//    public Double getPercentageA() {
//        return percentageA;
//    }
//
//    public void setPercentageA(Double percentageA) {
//        this.percentageA = percentageA;
//    }
    //make a class where we get string ET to integer and calculate


}