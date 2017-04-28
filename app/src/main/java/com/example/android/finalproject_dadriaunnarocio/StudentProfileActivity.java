package com.example.android.finalproject_dadriaunnarocio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class StudentProfileActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    private ImageView studentPhoto;
    private TextView studentName;
    private TextView studentAge;
    private TextView studentGrade;
    private TextView studentSchool;
    private TextView studentFavFood;
    private TextView isVegetarian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        studentPhoto = (ImageView) findViewById(R.id.student_photo);
        studentName = (TextView) findViewById(R.id.student_name);
        studentAge = (TextView) findViewById(R.id.student_age);
        studentGrade = (TextView) findViewById(R.id.student_grade);
        studentSchool = (TextView) findViewById(R.id.school_name);
        studentFavFood = (TextView) findViewById(R.id.fav_food);
        isVegetarian = (TextView) findViewById(R.id.is_vegetarian);


        Student student = new Student("Rocio Conde", 12, 17, "arepas", "TC", R.drawable.girl, false);
        Intent intent = new Intent();
        intent.getSerializableExtra(Keys.STUDENT);
        studentPhoto.setImageResource(student.photoId);
        studentName.setText(student.fullName);
        studentAge.setText(String.valueOf(student.age + " years old "));
        studentGrade.setText(String.valueOf("/Grade " + student.grade));
        studentSchool.setText(student.school);
        studentFavFood.setText("Favorite food: " + student.favFood);
        isVegetarian.setText(String.valueOf("Is vegetarian? " + student.isVegetarian));


        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null)
                    startActivity(new Intent(StudentProfileActivity.this, LogInActivity.class));
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                auth.signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }


    public void selectMeals(View view) {

        Intent intentMeals = new Intent(this, MealOptions.class);
        startActivity(intentMeals);

    }

    public void addNewPost(View view) {

        Intent intentPosts = new Intent(this, AddNewPost.class);
        startActivity(intentPosts);
    }
}
