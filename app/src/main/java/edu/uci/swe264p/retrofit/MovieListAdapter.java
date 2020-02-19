package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{

    private List<TopRatedResponse.movieResult> mData;

    int idx;

    MovieListAdapter(List<TopRatedResponse.movieResult> data) {
        this.mData = data;
        idx = 0;
    }

    /**
     * Responsible for displaying single item with a view.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView releaseDate;
        TextView vote;
        TextView overView;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            releaseDate = itemView.findViewById(R.id.tvReleaseDate);
            vote = itemView.findViewById(R.id.tvVote);
            overView = itemView.findViewById(R.id.tvOverview);
            image = itemView.findViewById(R.id.ivMovie);
        }
    }


    /**
     * Creates a new ViewHolder with its corresponding layout, pass layout.
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binds the data of single item to a view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + mData.get(idx).getPosterPath()).into(holder.image);
        holder.title.setText(mData.get(idx).getTitle());
        holder.releaseDate.setText(mData.get(idx).getReleaseDate());
        holder.vote.setText(mData.get(idx).getVoteAverage().toString());
        holder.overView.setText(mData.get(idx).getOverview());

        System.out.println("idx is " + idx + " , movie title is " + mData.get(idx).getTitle());
        ++idx;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
