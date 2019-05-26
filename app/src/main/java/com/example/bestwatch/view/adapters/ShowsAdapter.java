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
import com.example.bestwatch.model.objects.Show;

import java.util.List;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.ShowViewHolder> {

    private Context context;
    private List<Show> showList;
    private OnItemClickListener onItemClickListener;

    public ShowsAdapter(Context context, List<Show> showList) {
        this.context = context;
        this.showList = showList;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_item, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowsAdapter.ShowViewHolder holder, int position) {
        Show show = showList.get(position);
        String imageUrl = "https://image.tmdb.org/t/p/w1280" + show.getBackdropUrl();
        Glide.with(context).load(imageUrl).centerCrop().placeholder(R.drawable.ic_icon).into(holder.posterImageView);
        holder.titleTextView.setText(show.getTitle());
        holder.ratingTextView.setText(String.valueOf(show.getRating()));
        int[] genreArray = show.getGenre();
        int genreId = 0;
        if (genreArray.length > 0) genreId = genreArray[0];
        holder.genreTextView.setText(getGenre(genreId));
        String year = show.getReleaseDate();
        if(year.length() != 0) holder.yearTextView.setText(year.substring(0, 4));
        else holder.yearTextView.setText("N/A");
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }

    public Show getShowAt(int position) {
        return showList.get(position);
    }

    class ShowViewHolder extends RecyclerView.ViewHolder {

        ImageView posterImageView;
        TextView titleTextView;
        TextView ratingTextView;
        TextView genreTextView;
        TextView yearTextView;

        public ShowViewHolder(View view) {
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
                        onItemClickListener.onItemClick(showList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Show show);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public String getGenre(int genreId) {

        String genre;

        switch (genreId) {
            case 10759:
                genre = "Action & Adventure";
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
            case 10762:
                genre = "Kids";
                break;
            case 9648:
                genre = "Mystery";
                break;
            case 10763:
                genre = "News";
                break;
            case 10764:
                genre = "Reality";
                break;
            case 10765:
                genre = "Sci-Fi & Fantasy";
                break;
            case 10766:
                genre = "Soap";
                break;
            case 10767:
                genre = "Talk";
                break;
            case 10768:
                genre = "War & Politics";
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
