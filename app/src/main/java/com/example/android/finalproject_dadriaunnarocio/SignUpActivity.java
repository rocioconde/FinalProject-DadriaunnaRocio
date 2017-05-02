package com.example.android.finalproject_dadriaunnarocio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    private EditText studentName;
    private EditText studentGrade;
    private EditText studentAge;
    private EditText favFood;
    private EditText studentSchool;
    private CheckBox isVegetarian;
    private CheckBox reducedLunch50;
    private CheckBox reducedLunch100;
    private ArrayList<Student> student = new ArrayList<>();
    private DatabaseReference studentRef = database.getReference("student");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        studentName = (EditText) findViewById(R.id.username);
        studentGrade = (EditText) findViewById(R.id.user_grade);
        studentAge = (EditText) findViewById(R.id.user_age);
        studentSchool = (EditText) findViewById(R.id.school);
        isVegetarian = (CheckBox) findViewById(R.id.is_vegetarian);
        favFood = (EditText) findViewById(R.id.favorite_food);
        reducedLunch50 = (CheckBox) findViewById(R.id.reduced_lunch_50);
        reducedLunch100 = (CheckBox) findViewById(R.id.reduced_lunch_100);


//


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void signUp(View view) {

        FirebaseUser user = auth.getCurrentUser();

//        DatabaseReference studentRef = database.getReference(user.getUid());

        String studentFullName = studentName.getText().toString();
        String studentGrade1 = studentGrade.getText().toString();
        int studentGrade2 = Integer.parseInt(studentGrade1);
        String studentAge1 = studentAge.getText().toString();
        int studentAge2 = Integer.parseInt(studentAge1);
        String studentSchool1 = studentSchool.getText().toString();
        boolean isVegetarian1;
        isVegetarian1 = isVegetarian.isChecked();
        String favFood1 = favFood.getText().toString();


        Intent intentCreateNewAccount = new Intent(this, StudentProfileActivity.class);
        startActivity(intentCreateNewAccount);
    }


//    public void signOut(View view) {
//        auth.signOut();
//        student.clear();
//        displayText.setText("");
//
//
//    }

    }

