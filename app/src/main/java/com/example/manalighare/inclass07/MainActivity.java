package com.example.manalighare.inclass07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements SelectAvatarFragment.SelectAvatarInterface,MyProfileFragment.MyprofileInterface,DisplayProfileFragment.DisplayProfileInterface {



    String image_name=" ";


    public String getImage_name() {
        return image_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity");



        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new MyProfileFragment(),"MyProfileFragment")
                .commit();





    }



    @Override
    public void getAvatar(String img_name) {
        Log.d("demo","String name is : "+img_name);
        Log.d("demo","BackStackEntryCount : "+getSupportFragmentManager().getBackStackEntryCount());

        this.image_name=img_name;

        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else {



        }

    }


    @Override
    public void gotoSelectAvatar() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new SelectAvatarFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoDisplayMyProfile(String first_name,String last_name,String student__id,String dept_name) {

        Student student=new Student();
        student.dept=dept_name;
        student.fname=first_name;
        student.lname=last_name;
        student.image_name=this.image_name;
        student.S_ID=student__id;


        DisplayProfileFragment displayProfileFragment=new DisplayProfileFragment();
        Bundle b=new Bundle();
        b.putSerializable("STUDENT_KEY",student);
        displayProfileFragment.setArguments(b);



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,displayProfileFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoMyProfile() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else {

        }
    }
}
