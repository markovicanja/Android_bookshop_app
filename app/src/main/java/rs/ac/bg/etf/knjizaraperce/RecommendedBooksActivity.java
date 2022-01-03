package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityHomeBinding;
import rs.ac.bg.etf.knjizaraperce.databinding.ActivityRecommendedBooksBinding;

public class RecommendedBooksActivity extends AppCompatActivity {

    private ActivityRecommendedBooksBinding binding;
    private ArrayList<Book> recommendedBooks;
    private int index;
    private String[] users = {"aleksajankovic", "ninamarkovic",
            "majaerakovic", "teaburic", "nikolakilibarda"};

    public ArrayList<Book> getRecommendedBooks() {
        int numberOfBooks = getResources().getInteger(R.integer.number_of_books);
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            Book book = Book.createFromResources(getResources(), i);
            if (book.getRating() > 3) books.add(book);
        }
        return books;
    }

    public void setContent() {
        binding.bookImage.setImageDrawable(recommendedBooks.get(index).getImage());
        binding.bookTitle.setText(recommendedBooks.get(index).getTitle());
        binding.bookAuthor.setText(recommendedBooks.get(index).getAuthor());
        binding.recommendationUser.setText(users[index % users.length]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecommendedBooksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recommendedBooks = getRecommendedBooks();
        setContent();

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.bookImage.setOnClickListener(view -> {
            Intent intent = new Intent(this, BookDetailsActivity.class);
            intent.putExtra("book_title", recommendedBooks.get(index).getTitle());
            startActivity(intent);
        });

        binding.bookTitle.setOnClickListener(view -> {
            Intent intent = new Intent(this, BookDetailsActivity.class);
            intent.putExtra("book_title", recommendedBooks.get(index).getTitle());
            startActivity(intent);
        });

        binding.chevronLeftBook.setOnClickListener(view -> {
            if (index == 0) index = recommendedBooks.size() - 1;
            else index--;
            setContent();
        });

        binding.chevronRightBook.setOnClickListener(view -> {
            if (index == recommendedBooks.size() - 1) index = 0;
            else index++;
            setContent();
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
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                startActivity(profileIntent);
                return true;
            case R.id.recommendations_menu_item:
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