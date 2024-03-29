package rs.ac.bg.etf.knjizaraperce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(v -> {
            String username = binding.username.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();

            UserViewModel userViewModel = UserViewModel.getInstance();

            if (username.equals(userViewModel.getUsername()) && password.equals(userViewModel.getPassword())) {
                Intent explicitIntent = new Intent(this, HomeActivity.class);
                startActivity(explicitIntent);
            }
            else {
                Toast.makeText(this, "Neispravni kredencijali", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}