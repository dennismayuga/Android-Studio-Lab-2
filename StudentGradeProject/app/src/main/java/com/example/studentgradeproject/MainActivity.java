package com.example.studentgradeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView student_name_text_view;
    private TextView student_grade_text_view;
    private Button display_avg_button;
    private Button display_prev_button;
    private Button display_next_button;

    private static String log = "StudentGradeProject";
    private static final String KEY_INDEX = "index";

    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //loading data

        Grade student1 = new Grade(1,"Graham","Bill",69,70,98,80,90);
        Grade student2 = new Grade(2,"Sanchez","Jim",88,72,90,83,93);
        Grade student3 = new Grade(3,"White","Peter",85,80,45,93,70);
        Grade student4 = new Grade(4,"Phelp","David",70,60,60,90,70);
        Grade student5 = new Grade(5,"Lewis","Sheila",50,76,87,59,72);
        Grade student6 = new Grade(6,"James","Thomas",89,99,97,98,99);

        Grade[] allGrades = new Grade[]{student1,student2,student3,student4,student5,student6};

        display_avg_button = (Button) findViewById(R.id.calc_grade_avg_button);
        display_next_button = (Button) findViewById(R.id.next_student_button);
        display_prev_button = (Button) findViewById(R.id.prev_student_button);

        student_grade_text_view = (TextView) findViewById(R.id.student_grade_avg_text_view);
        student_name_text_view = (TextView) findViewById(R.id.student_name_text_view);

        display_avg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student_name_text_view.setText(allGrades[index].getStudent_lname()+" "+allGrades[index].getStudent_fname());    //full name fname first

                student_grade_text_view.setText(allGrades[index].calculate_GradeAverage());     // displaying average

                Toast.makeText(MainActivity.this,allGrades[index].getStudent_lname()+" "+allGrades[index].getStudent_fname()+" is : " + allGrades[index].calculate_GradeAverage(), Toast.LENGTH_SHORT).show();



            }
        });

        display_prev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (Math.abs(index-1))%allGrades.length;
            }
        });

        display_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (Math.abs(index+1))%allGrades.length;
            }
        });







    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.d(log, "onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX,index);
    }

    @Override
    public void onStart() {

        super.onStart();
        Log.d(log,"onStart() called");
    }

    @Override
    public void onPause() {

        super.onPause();
        Log.d(log, "onPause() called");
    }
    @Override
    public void onResume() {

        super.onResume();
        Log.d(log, "onResume() called");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d(log, "onDestroy() called");
    }

    @Override
    public void onStop() {

        super.onStop();
        Log.d(log, "onStop() called");
    }

}