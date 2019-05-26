package com.example.bestwatch.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bestwatch.R;
import com.example.bestwatch.model.objects.Person;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PersonViewHolder> {

    private Context context;
    private List<Person> personList;
    private OnItemClickListener onItemClickListener;

    public PeopleAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.PersonViewHolder holder, int position) {
        Person person = personList.get(position);

        String imageUrl = "https://image.tmdb.org/t/p/h632" + person.getImageUrl();
        Glide.with(context).load(imageUrl).centerCrop().placeholder(R.drawable.ic_icon).into(holder.profileImageView);
        holder.nameTextView.setText(person.getName());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public Person getMovieAt(int position) {
        return personList.get(position);
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImageView;
        TextView nameTextView;

        public PersonViewHolder(View view) {
            super(view);
            profileImageView = view.findViewById(R.id.profile_imageView);
            nameTextView = view.findViewById(R.id.name_textView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (onItemClickListener != null && position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(personList.get(position));
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Person person);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
