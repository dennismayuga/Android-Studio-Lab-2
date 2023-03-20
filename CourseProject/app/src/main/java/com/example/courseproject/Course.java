package com.example.courseproject;

public class Course {
    private String course_no;
    private String course_name;
    private int max_enroll;
    public static int credits;


    public Course() {
        this.course_no = "";
        this.course_name = "";
        this.max_enroll = 0;
    }

    public Course(String course_no, String course_name, int max_enroll) {
        this.course_no = course_no;
        this.course_name = course_name;
        this.max_enroll = max_enroll;
    }


    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getMax_enroll() {
        return max_enroll;
    }

    public void setMax_enroll(int max_enroll) {
        this.max_enroll = max_enroll;
    }

    @Override
    public String toString() {
        return "CourseClass{" +
                "course_no='" + course_no + '\'' +
                ", course_name='" + course_name + '\'' +
                ", max_enroll=" + max_enroll +
                '}';
    }

    //concret method
    public double calculateCourseTotalFees()
    {



        return this.max_enroll*250;
    }



}




