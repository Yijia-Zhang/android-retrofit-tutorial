package edu.uci.swe264p.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TopRatedResponse {
    private float page;
    private float total_results;
    private float total_pages;
    List<movieResult> results = new ArrayList<>();

    public class movieResult{
        @SerializedName("vote_average")
        private Float voteAverage;
        @SerializedName("poster_path")
        private String posterPath;
        @SerializedName("title")
        private String title;
        @SerializedName("release_date")
        private String releaseDate;
        @SerializedName("overview")
        private String overview;

        public movieResult(Float voteAverage, String posterPath, String title, String releaseDate, String overview) {
            this.voteAverage = voteAverage;
            this.posterPath = posterPath;
            this.title = title;
            this.releaseDate = releaseDate;
            this.overview = overview;
        }

        public Float getVoteAverage() {
            return voteAverage;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public String getTitle() {
            return title;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public String getOverview() {
            return overview;
        }
    }

    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_results() {
        return total_results;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public List<movieResult> getResults(){
        return results;
    }

}
