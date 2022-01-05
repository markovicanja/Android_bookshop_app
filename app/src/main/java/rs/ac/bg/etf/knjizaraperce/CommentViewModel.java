package rs.ac.bg.etf.knjizaraperce;

import android.content.res.Resources;

import java.util.ArrayList;

public class CommentViewModel {
    private String[] bookTitles;
    private ArrayList<ArrayList<Comment>> comments;
    private int[] ratings;

    private static CommentViewModel instance = null;

    private CommentViewModel(Resources resources) {
        bookTitles = resources.getStringArray(R.array.book_titles);
        ratings = resources.getIntArray(R.array.book_ratings);

        comments = new ArrayList<>();
        for (int i = 0; i < bookTitles.length; i++) {
            ArrayList<Comment> bookComments = new ArrayList<>();
            comments.add(bookComments);
        }
        comments.get(0).add(new Comment("Teodora Buric", "Odlicna knjiga!"));
        comments.get(0).add(new Comment("Vuk Zekovic", "Za svaku preporuku."));
        comments.get(1).add(new Comment("Maja Erakovic", "Najbolja knjiga koju sam procitala u poslednje vreme!"));
    }

    public static CommentViewModel getInstance(Resources resources) {
        if (instance == null)
            instance = new CommentViewModel(resources);
        return instance;
    }

    private int findIndex(String bookTitle) {
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i].equals(bookTitle)) return i;
        }
        return -1;
    }

    public ArrayList<Comment> getComments(String bookTitle) {
        int index = findIndex(bookTitle);
        if (index == -1) return null;
        return comments.get(index);
    }

    public void addComment(String bookTitle, String author, String comment) {
        int index = findIndex(bookTitle);
        if (index == -1) return;
        comments.get(index).add(new Comment(author, comment));
    }

    public int getRating(String bookTitle) {
        int index = findIndex(bookTitle);
        if (index == -1) return 0;
        return ratings[index];
    }

    public void setRating(String bookTitle, int rating) {
        int index = findIndex(bookTitle);
        if (index == -1) return;
        ratings[index] = rating;
    }

}
