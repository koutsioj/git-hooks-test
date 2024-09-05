package com.example.githookstest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Gson gson = new Gson();

        // Example JSON string
        String json = "{\"name\":\"John Doe\", \"age\":30}";

        // Deserialize JSON to a Java object
        Person person = gson.fromJson(json, Person.class);
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);

        // Serialize Java object back to JSON
        String jsonOutput = gson.toJson(person);
        System.out.println("JSON Output: " + jsonOutput);
    }

    // A simple class to hold the deserialized data
    static class Person {
        String name;
        int age;
    }
        //pre-commit git hook : test commit 1

}
