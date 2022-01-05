package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityEditDataBinding;
import rs.ac.bg.etf.knjizaraperce.databinding.ActivityPasswordBinding;

public class PasswordActivity extends AppCompatActivity {

    private ActivityPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserViewModel userViewModel = UserViewModel.getInstance();

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        binding.buttonChangePassword.setOnClickListener(v -> {
            String newPassword = binding.newPassword.getEditText().getText().toString();
            String repeatedPassword = binding.repeatedPassword.getEditText().getText().toString();
            String currentPassword = binding.currentPassword.getEditText().getText().toString();

            if (!newPassword.equals(repeatedPassword)) {
                Toast.makeText(this, "Lozinke se ne poklapaju.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!currentPassword.equals(userViewModel.getPassword())) {
                Toast.makeText(this, "Lozinka nije ispravna.", Toast.LENGTH_SHORT).show();
                return;
            }
            userViewModel.setPassword(newPassword);
            Toast.makeText(this, "Lozinka je uspesno izmenjena.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.profile_menu_item:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.recommendations_menu_item:
                Intent recommendationIntent = new Intent(this, RecommendedBooksActivity.class);
                startActivity(recommendationIntent);
                finish();
                return true;
            case R.id.logout_menu_item:
                Intent loginIntent = new Intent(this, MainActivity.class);
                startActivity(loginIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}