package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityEditDataBinding;

public class EditDataActivity extends AppCompatActivity {

    private ActivityEditDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserViewModel userViewModel = UserViewModel.getInstance();

        binding.username.setText(userViewModel.getUsername());
        binding.firstName.setPlaceholderText(userViewModel.getFirstName());
        binding.lastName.setPlaceholderText(userViewModel.getLastName());
        binding.address.setPlaceholderText(userViewModel.getAddress());
        binding.phone.setPlaceholderText(userViewModel.getPhone());

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.buttonChangeData.setOnClickListener(v -> {
            String first_name = binding.firstName.getEditText().getText().toString();
            String last_name = binding.lastName.getEditText().getText().toString();
            String address = binding.address.getEditText().getText().toString();
            String phone = binding.phone.getEditText().getText().toString();

            userViewModel.setFirstName(first_name);
            userViewModel.setLastName(last_name);
            userViewModel.setAddress(address);
            userViewModel.setPhone(phone);

            Toast.makeText(this, "Podaci su uspesno izmenjeni.", Toast.LENGTH_SHORT).show();

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