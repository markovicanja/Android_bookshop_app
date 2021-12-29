package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityHomeBinding;
import rs.ac.bg.etf.knjizaraperce.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private int index, promotionIndex;
    private ArrayList<Book> books, promotionBooks;
    public int NUMBER_OF_BOOKS;

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
            Book book = Book.createFromResources(getResources(), i);
            books.add(book);
        }
        return books;
    }

    public ArrayList<Book> getPromotionBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
            Book book = Book.createFromResources(getResources(), i);
            if (book.getPromotion() == 1) books.add(book);
        }
        return books;
    }

    public void setContent() {
        binding.bookImage.setImageDrawable(books.get(index).getImage());
        binding.bookTitle.setText(books.get(index).getTitle());
        binding.bookAuthor.setText(books.get(index).getAuthor());

        binding.promotionBookImage.setImageDrawable(promotionBooks.get(promotionIndex).getImage());
        binding.promotionBookTitle.setText(promotionBooks.get(promotionIndex).getTitle());
        binding.promotionBookAuthor.setText(promotionBooks.get(promotionIndex).getAuthor());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NUMBER_OF_BOOKS = getResources().getInteger(R.integer.number_of_books);

        books = getAllBooks();
        promotionBooks = getPromotionBooks();

        setContent();

        binding.bookImage.setOnClickListener(view -> {

        });

        binding.bookTitle.setOnClickListener(view -> {

        });

        binding.promotionBookImage.setOnClickListener(view -> {

        });

        binding.promotionBookTitle.setOnClickListener(view -> {

        });

        binding.chevronLeftBook.setOnClickListener(view -> {
            if (index == 0) index = books.size() - 1;
            else index--;
            setContent();
        });

        binding.chevronRightBook.setOnClickListener(view -> {
            if (index == books.size() - 1) index = 0;
            else index++;
            setContent();
        });

        binding.chevronLeftPromotion.setOnClickListener(view -> {
            if (promotionIndex == 0) promotionIndex = promotionBooks.size() - 1;
            else promotionIndex--;
            setContent();
        });

        binding.chevronRightPromotion.setOnClickListener(view -> {
            if (promotionIndex == promotionBooks.size() - 1) promotionIndex = 0;
            else promotionIndex++;
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

                return true;
            case R.id.recommendations_menu_item:

                return true;
            case R.id.logout_menu_item:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}