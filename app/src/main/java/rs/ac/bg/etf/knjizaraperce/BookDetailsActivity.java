package rs.ac.bg.etf.knjizaraperce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.knjizaraperce.databinding.ActivityBookDetailsBinding;

public class BookDetailsActivity extends AppCompatActivity {

    private ActivityBookDetailsBinding binding;
    private String bookTitle;
    private Book book;

    public Book findbook() {
        int NUMBER_OF_BOOKS = getResources().getInteger(R.integer.number_of_books);
        for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
            Book book = Book.createFromResources(getResources(), i);
            if (book.getTitle().equals(bookTitle)) return book;
        }
        return Book.createFromResources(getResources(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        bookTitle = bundle.getString("book_title");
        book = findbook();

        binding.bookImage.setImageDrawable(book.getImage());
        binding.bookTitle.setText(book.getTitle());
        binding.bookAuthor.setText(book.getAuthor());
        binding.bookPages.setText("" + book.getPages());
        binding.bookYear.setText("" + book.getYear());
        binding.bookDescription.setText(book.getDescription());
        binding.rating.setText("" + book.getRating());
        if (book.getPromotion() == 0) {
            binding.promotionButton.setVisibility(View.GONE);
        }

        CommentViewModel commentViewModel = CommentViewModel.getInstance(getResources());
        CommentAdapter commentAdapter = new CommentAdapter(commentViewModel.getComments(bookTitle));

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(commentAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.star1.setOnClickListener(v -> {
            binding.star1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);

            if (book.getRating() > 1) {
                book.setRating(book.getRating() - 1);
                binding.rating.setText("" + book.getRating());
            }
            else if (book.getRating() < 1) {
                book.setRating(book.getRating() + 1);
                binding.rating.setText("" + book.getRating());
            }
        });

        binding.star2.setOnClickListener(v -> {
            binding.star1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);

            if (book.getRating() > 2) {
                book.setRating(book.getRating() - 1);
                binding.rating.setText("" + book.getRating());
            }
            else if (book.getRating() < 2) {
                book.setRating(book.getRating() + 1);
                binding.rating.setText("" + book.getRating());
            }
        });

        binding.star3.setOnClickListener(v -> {
            binding.star1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);
            binding.star5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);

            if (book.getRating() > 3) {
                book.setRating(book.getRating() - 1);
                binding.rating.setText("" + book.getRating());
            }
            else if (book.getRating() < 3) {
                book.setRating(book.getRating() + 1);
                binding.rating.setText("" + book.getRating());
            }
        });

        binding.star4.setOnClickListener(v -> {
            binding.star1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_outline_24, 0, 0, 0);

            if (book.getRating() > 4) {
                book.setRating(book.getRating() - 1);
                binding.rating.setText("" + book.getRating());
            }
            else if (book.getRating() < 4) {
                book.setRating(book.getRating() + 1);
                binding.rating.setText("" + book.getRating());
            }
        });

        binding.star5.setOnClickListener(v -> {
            binding.star1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);
            binding.star5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_star_24, 0, 0, 0);

            if (book.getRating() > 5) {
                book.setRating(book.getRating() - 1);
                binding.rating.setText("" + book.getRating());
            }
            else if (book.getRating() < 5) {
                book.setRating(book.getRating() + 1);
                binding.rating.setText("" + book.getRating());
            }
        });

        binding.headerImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.buttonRecommend.setOnClickListener(v -> {
            Intent intent = new Intent(this, RecommendationActivity.class);
            intent.putExtra("book_title", bookTitle);
            startActivity(intent);
        });

        binding.buttonAddComment.setOnClickListener(v -> {
            String comment = binding.addComment.getEditText().getText().toString();

            UserViewModel userViewModel = UserViewModel.getInstance();
            String author = userViewModel.getFirstName() + " " + userViewModel.getLastName();
            commentViewModel.addComment(bookTitle, author, comment);

            commentAdapter.notifyDataSetChanged();
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
                Intent recommendationIntent = new Intent(this, RecommendedBooksActivity.class);
                startActivity(recommendationIntent);
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