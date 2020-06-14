package km.project.movielist;

public class NetworkHelper {
    private Retrofit retrofit;
    private ApiService apiService;
    public static NetworkHelper networkHelper = new NetworkHelper();

    public NetworkHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService =retrofit.create(ApiService.class);
    }

    public static NetworkHelper getInstance() {
        return networkHelper;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
