package com.ex.myapplication3;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nitrogenEditText;
    private EditText phosphorusEditText;
    private EditText potassiumEditText;
    private EditText temperatureEditText;
    private EditText humidityEditText;
    private EditText phEditText;
    private EditText rainfallEditText;
    private Button getRecommendationButton;
    private TextView titleTextView; // If you need to interact with it


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //initialize views
        titleTextView = findViewById(R.id.title);
        nitrogenEditText = findViewById(R.id.nitrogen);
        phosphorusEditText = findViewById(R.id.phosphorus);
        potassiumEditText = findViewById(R.id.potassium);
        temperatureEditText = findViewById(R.id.temperature);
        humidityEditText = findViewById(R.id.humidity);
        phEditText = findViewById(R.id.ph);
        rainfallEditText = findViewById(R.id.rainfall);
        getRecommendationButton = findViewById(R.id.button_get_recommendation);

        //Set OneClickListener for the button
        getRecommendationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditText fields
                String nitrogenStr = nitrogenEditText.getText().toString().trim();
                String phosphorusStr = phosphorusEditText.getText().toString().trim();
                String potassiumStr = potassiumEditText.getText().toString().trim();
                String temperatureStr = temperatureEditText.getText().toString().trim();
                String humidityStr = humidityEditText.getText().toString().trim();
                String phStr = phEditText.getText().toString().trim();
                String rainfallStr = rainfallEditText.getText().toString().trim();

                // --- Input Validation (Recommended) ---
                if (nitrogenStr.isEmpty() || phosphorusStr.isEmpty() || potassiumStr.isEmpty() ||
                        temperatureStr.isEmpty() || humidityStr.isEmpty() || phStr.isEmpty() ||
                        rainfallStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop further processing if any field is empty
                }

                // --- Convert to appropriate data types (e.g., float or double) ---
                // You'll need to handle potential NumberFormatExceptions here
                try {
                    float nitrogen = Float.parseFloat(nitrogenStr);
                    float phosphorus = Float.parseFloat(phosphorusStr);
                    float potassium = Float.parseFloat(potassiumStr);
                    float temperature = Float.parseFloat(temperatureStr);
                    float humidity = Float.parseFloat(humidityStr);
                    float ph = Float.parseFloat(phStr);
                    float rainfall = Float.parseFloat(rainfallStr);

                    // --- Placeholder for your recommendation logic ---
                    // This is where you would typically:
                    // 1. Send this data to a backend server for processing.
                    // 2. Use a local machine learning model (e.g., TensorFlow Lite).
                    // 3. Implement your crop recommendation algorithm directly.

                    String recommendation = getCropRecommendation(nitrogen, phosphorus, potassium, temperature, humidity, ph, rainfall);

                    // --- Display the recommendation ---
                    // You might want to display this in a TextView a Dialog, or a new Activity.
                    Toast.makeText(MainActivity.this, "Recommendation: " + recommendation, Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // --- Placeholder method for your crop recommendation logic ---
    private String getCropRecommendation(float nitrogen, float phosphorus, float potassium,
                                         float temperature, float humidity, float ph, float rainfall) {
        // **Replace this with your actual recommendation logic.**
        // This is a very basic example.
        if (nitrogen > 50 && temperature > 20 && rainfall > 100) {
            return "Wheat";
        } else if (phosphorus > 30 && humidity > 60) {
            return "Corn";
        } else {
            return "General Purpose Fertilizer Recommended";
        }
    }
}
