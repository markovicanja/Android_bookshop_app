package rs.ac.bg.etf.knjizaraperce;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rs.ac.bg.etf.knjizaraperce.databinding.ViewHolderCommentBinding;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private final List<Comment> comments;

    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderCommentBinding viewHolderCommentBinding = ViewHolderCommentBinding.inflate(
                layoutInflater,
                parent,
                false);
        return new CommentViewHolder(viewHolderCommentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);
        ViewHolderCommentBinding binding = holder.binding;

        binding.commentAuthor.setText(comment.getAuthor());
        binding.comment.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        public ViewHolderCommentBinding binding;

        public CommentViewHolder(@NonNull ViewHolderCommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}