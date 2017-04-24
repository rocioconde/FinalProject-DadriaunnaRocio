package com.example.android.finalproject_dadriaunnarocio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MealOptions extends AppCompatActivity {

    private List<Meal> meals;
    private MealsAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_options);
        initialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_meals);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mealAdapter = new MealsAdapter(meals, this);
        recyclerView.setAdapter(mealAdapter);
    }

    private void initialData() {
        meals = new ArrayList<>();
        meals.add(new Meal("Baked chicken fingers, white rice, and caesar salad", 5, 700, false, R.drawable.chickenfinger));
        meals.add(new Meal("Pork chops, mashed potatoes, and roasted carrots", 5, 750, false, R.drawable.porkchops));
        meals.add(new Meal("Redl lentils stew, baked potatoes, and banana", 4.30, 560, true, R.drawable.redlentils));
        meals.add(new Meal("Veggie burger, corn on the cob, and fruit salad", 4.90, 690, true, R.drawable.veggieburger));
        meals.add(new Meal("Cheees pizza, caesar salad, and fruit salad", 4.80, 690, true, R.drawable.cheespizza));
        meals.add(new Meal("Tofu chicken nuggets, macaroni and cheese, and watermelon slices", 4.50, 600, true, R.drawable.tofu));
        meals.add(new Meal("Cheese quesadilla, Spanish rice, black beans, and pico de gallo", 4.80, 650, true, R.drawable.quesadilla));
        meals.add(new Meal("Pasta with meatballs and corn on the cob", 5, 680, false, R.drawable.meatballs));
        meals.add(new Meal("Cheeseburger, roasted potatoes, and apple", 5, 680, false, R.drawable.cheeseburger));
        meals.add(new Meal("Pepperoni pizza, caprese salad, and watermelon slices", 5, 700, false, R.drawable.pepperoni));
    }



}