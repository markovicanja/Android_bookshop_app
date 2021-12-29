package rs.ac.bg.etf.knjizaraperce;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class Book {
    private String title;
    private String author;
    private int pages;
    private int year;
    private String description;
    private Drawable image;
    private int promotion;
    private int rating;

    public static Book createFromResources(Resources resources, int index) {
        String[] titles = resources.getStringArray(R.array.book_titles);
        String[] authors = resources.getStringArray(R.array.book_authors);
        int[] pages = resources.getIntArray(R.array.book_pages);
        int[] years = resources.getIntArray(R.array.book_years);
        String[] descriptions = resources.getStringArray(R.array.book_descriptions);
        TypedArray images = resources.obtainTypedArray(R.array.book_images);
        int[] promotions = resources.getIntArray(R.array.book_promotions);
        int[] ratings = resources.getIntArray(R.array.book_ratings);

        Book result = new Book(titles[index], authors[index], pages[index], years[index],
                descriptions[index], images.getDrawable(index), promotions[index], ratings[index]);

        images.recycle();

        return result;
    }

    public Book(String title, String author, int pages, int year, String description, Drawable image, int promotion, int rating) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.description = description;
        this.image = image;
        this.promotion = promotion;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
