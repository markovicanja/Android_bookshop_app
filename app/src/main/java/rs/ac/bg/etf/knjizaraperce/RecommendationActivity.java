package rs.ac.bg.etf.knjizaraperce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityRecommendationBinding;

public class RecommendationActivity extends AppCompatActivity {

    private ActivityRecommendationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecommendationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        String bookTitle = bundle.getString("book_title");

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.heading.setText("Preporucite knjigu '" + bookTitle + "' nekome...");

        binding.recommendButton.setOnClickListener(v -> {
            String username = binding.username.getEditText().getText().toString();

            Toast.makeText(this, "Uspesno ste preporucili knjigu korisniku " + username,
                    Toast.LENGTH_SHORT).show();
        });
    }
}