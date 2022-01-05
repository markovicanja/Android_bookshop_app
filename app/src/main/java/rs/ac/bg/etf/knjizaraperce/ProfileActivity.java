package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityHomeBinding;
import rs.ac.bg.etf.knjizaraperce.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserViewModel userViewModel = UserViewModel.getInstance();

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.username.setText(userViewModel.getUsername());
        binding.firstName.setText(userViewModel.getFirstName());
        binding.lastName.setText(userViewModel.getLastName());
        binding.address.setText(userViewModel.getAddress());
        binding.phone.setText(userViewModel.getPhone());

        binding.buttonChangeData.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditDataActivity.class);
            startActivity(intent);
            finish();
        });

        binding.buttonChangePassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, PasswordActivity.class);
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
                return true;
            case R.id.recommendations_menu_item:
                Intent recommendationIntent = new Intent(this, RecommendedBooksActivity.class);
                startActivity(recommendationIntent);
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