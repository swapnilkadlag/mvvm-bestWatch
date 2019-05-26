package com.example.bestwatch.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bestwatch.R;
import com.example.bestwatch.model.objects.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movieList;
    private OnItemClickListener onItemClickListener;

    public MoviesAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        String imageUrl = "https://image.tmdb.org/t/p/w1280" + movie.getBackdropUrl();
        Glide.with(context).load(imageUrl).centerCrop().placeholder(R.drawable.ic_icon).into(holder.posterImageView);
        holder.titleTextView.setText(movie.getTitle());
        holder.ratingTextView.setText(String.valueOf(movie.getRating()));
        int[] genreArray = movie.getGenre();
        int genreId = 0;
        if (genreArray.length > 0) genreId = genreArray[0];
        holder.genreTextView.setText(getGenre(genreId));
        holder.yearTextView.setText(movie.getReleaseDate().substring(0, 4));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public Movie getMovieAt(int position) {
        return movieList.get(position);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView posterImageView;
        TextView titleTextView;
        TextView ratingTextView;
        TextView genreTextView;
        TextView yearTextView;

        public MovieViewHolder(View view) {
            super(view);
            posterImageView = view.findViewById(R.id.poster_imageView);
            titleTextView = view.findViewById(R.id.title_textView);
            ratingTextView = view.findViewById(R.id.rating_textView);
            genreTextView = view.findViewById(R.id.genre_textView);
            yearTextView = view.findViewById(R.id.year_textView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (onItemClickListener != null && position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(movieList.get(position));
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public String getGenre(int genreId) {

        String genre;

        switch (genreId) {
            case 28:
                genre = "Action";
                break;
            case 12:
                genre = "Adventure";
                break;
            case 16:
                genre = "Animation";
                break;
            case 35:
                genre = "Comedy";
                break;
            case 80:
                genre = "Crime";
                break;
            case 99:
                genre = "Documentary";
                break;
            case 18:
                genre = "Drama";
                break;
            case 10751:
                genre = "Family";
                break;
            case 14:
                genre = "Fantasy";
                break;
            case 36:
                genre = "History";
                break;
            case 27:
                genre = "Horror";
                break;
            case 10402:
                genre = "Music";
                break;
            case 9648:
                genre = "Mystery";
                break;
            case 10749:
                genre = "Romance";
                break;
            case 878:
                genre = "Science Fiction";
                break;
            case 10770:
                genre = "TV Movie";
                break;
            case 53:
                genre = "Thriller";
                break;
            case 10752:
                genre = "War";
                break;
            case 37:
                genre = "Western";
                break;
            case 0:
                genre = "N/A";
                break;
            default:
                genre = "N/A";
                break;
        }
        return genre;
    }
}
