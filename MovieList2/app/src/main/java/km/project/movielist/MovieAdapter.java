package km.project.movielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    ArrayList<Movie> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie item = items.get(i);
        viewHolder.setItem(item, viewHolder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Movie item){
        items.add(item);
    }

    public void setItems(ArrayList<Movie> items){
        this.items = items;
    }

    public Movie getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Movie item){
        items.set(position, item);
    }

    static class ViewHolder  extends RecyclerView.ViewHolder {

        TextView tv_title, tv_rating;
        ImageView iv_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            iv_id = itemView.findViewById(R.id.imageView2);
        }

        public void setItem(Movie item, ViewHolder viewHolder) {
            tv_title.setText(item.getTitle());
            tv_rating.setText(item.getRating().toString());

            Picasso.with(viewHolder.iv_id.getContext())
                    .load(item.getBackgroundImage())
                    .into(iv_id);
        }
    }
}


