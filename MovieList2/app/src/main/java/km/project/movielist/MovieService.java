package km.project.movielist;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("list_movies.json")
    Call<YtsAPI> repoContributors(
            @Query("sort_by") String sort_by, @Query("limit") String limit);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://yts.lt/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
