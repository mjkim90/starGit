package km.project.movielist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class YtsAPI {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    class Data {

        @SerializedName("movie_count")
        @Expose
        private Integer movieCount;
        @SerializedName("limit")
        @Expose
        private Integer limit;
        @SerializedName("page_number")
        @Expose
        private Integer pageNumber;
        @SerializedName("movies")
        @Expose
        private ArrayList<Movie> movies = null;

        public Integer getMovieCount() {
            return movieCount;
        }

        public void setMovieCount(Integer movieCount) {
            this.movieCount = movieCount;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public ArrayList<Movie> getMovies() {
            return movies;
        }

        public void setMovies(ArrayList<Movie> movies) {
            this.movies = movies;
        }
    }
}
