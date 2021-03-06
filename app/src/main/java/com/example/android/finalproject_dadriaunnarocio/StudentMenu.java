package com.example.android.finalproject_dadriaunnarocio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class StudentMenu extends AppCompatActivity {

    private RecyclerView studentMenuRecyclerView;
    private MealsAdapter mealsAdapterForStudentMenu;
    private ArrayList<Meal> selectedMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        selectedMeals = (ArrayList<Meal>) getIntent().getSerializableExtra(Keys.SELECTED_MEALS);

        studentMenuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_student_menu);
        studentMenuRecyclerView.setHasFixedSize(true);
        studentMenuRecyclerView.setLayoutManager(new LinearLayoutManager(StudentMenu.this));
        mealsAdapterForStudentMenu = new MealsAdapter(selectedMeals, StudentMenu.this, false);
        studentMenuRecyclerView.setAdapter(mealsAdapterForStudentMenu);


    }

    public void confirmMenu(View view) {

        String mealString = "";

        for (Meal studentSelection : selectedMeals) {
            mealString += studentSelection.toString() + "\n";
        }



        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your SchoolMenu");
        intent.putExtra(Intent.EXTRA_TEXT, "This is your menu:" + "\n" + mealString);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
}
