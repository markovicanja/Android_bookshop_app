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
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = ProfileActivity.userViewModel;

        binding.username.setText(userViewModel.getUsername().getValue());
        binding.firstName.setPlaceholderText(userViewModel.getFirstName().getValue());
        binding.lastName.setPlaceholderText(userViewModel.getLastName().getValue());
        binding.address.setPlaceholderText(userViewModel.getAddress().getValue());
        binding.phone.setPlaceholderText(userViewModel.getPhone().getValue());

        binding.buttonChangeData.setOnClickListener(v -> {
            String first_name = binding.firstName.getEditText().toString();
            String last_name = binding.lastName.getEditText().toString();
            String address = binding.address.getEditText().toString();
            String phone = binding.phone.getEditText().toString();

            userViewModel.setFirstName(first_name);
            userViewModel.setLastName(last_name);
            userViewModel.setAddress(address);
            userViewModel.setPhone(phone);

            Toast.makeText(this, "Podaci su uspesno izmenjeni.", Toast.LENGTH_SHORT).show();
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
                finish();
                return true;
            case R.id.recommendations_menu_item:

                return true;
            case R.id.logout_menu_item:
                Intent loginIntent = new Intent(this, MainActivity.class);
                startActivity(loginIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}