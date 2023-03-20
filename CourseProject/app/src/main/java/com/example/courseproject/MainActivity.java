package com.example.courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView courseText_text_view;
    private TextView courseTotalFees_text_view;
    private Button courseTotal_Button;
    private Button nextCourse_button;

    private int currentIndex=0;
    public static final String KEY_INDEX = "index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Course courseRecord1 = new Course("MIS 101","Intro. to Info. Systems",140);
        Course courseRecord2 = new Course("MIS 301","Systems Analysis",35);
        Course courseRecord3 = new Course("MIS 441","Database Management",12);
        Course courseRecord4 = new Course("CS 155","Programming in C++",90);
        Course courseRecord5 = new Course("MIS 451","Web-Based Systems",30);
        Course courseRecord6 = new Course("MIS 551","Advanced Web",30);
        Course courseRecord7 = new Course("MIS 651","Advanced Java",30);

        //data structure array

        Course[] allCourses = new Course[]{courseRecord1,courseRecord2,courseRecord3,courseRecord4,courseRecord5,courseRecord6,courseRecord7};

        if(savedInstanceState!=null){
            currentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        courseText_text_view = (TextView) findViewById(R.id.course_text_view);
        courseText_text_view.setText("Course: "+allCourses[currentIndex].getCourse_no()+" "+ allCourses[currentIndex].getCourse_name());

        courseTotal_Button = (Button) findViewById(R.id.course_total_fees_button);
        courseTotal_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get tge view of courseTotalFeesText_View
                courseTotalFees_text_view = (TextView) findViewById(R.id.course_total_fees_text_view);
                courseTotalFees_text_view.setText("Total Course Fees is : " + allCourses[currentIndex].calculateCourseTotalFees()+"");
// show is duration
                Toast.makeText(MainActivity.this,"Total Course Fees is : " + allCourses[currentIndex].calculateCourseTotalFees()+"", Toast.LENGTH_SHORT).show();





            }
        });


        nextCourse_button = (Button) findViewById(R.id.course_next_button);
        nextCourse_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex-1)%allCourses.length;
                courseText_text_view.setText("Course: "+allCourses[currentIndex].getCourse_no()+"  "+allCourses[currentIndex].getCourse_name());
                courseTotalFees_text_view = (TextView) findViewById(R.id.course_total_fees_text_view);
                courseTotalFees_text_view.setText("");
            }
        });




    }

@Override
    public void onStart() {

    super.onStart();
    Log.d("Course Project","onStart() called");
}

    @Override
    public void onPause() {

        super.onPause();
        Log.d("Course Project", "onPause() called");
    }
    @Override
    public void onResume() {

        super.onResume();
        Log.d("Course Project", "onResume() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.d("Course Project", "onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX,currentIndex);
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d("Course Project", "onDestroy called");
    }





}