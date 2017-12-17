package nyc.muaadh_melhi_develpoer.inclassretrofit.backend;

import nyc.muaadh_melhi_develpoer.inclassretrofit.modelpart3.Dogs;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 12/17/17.
 */

public interface DogService {

    @GET("api/breed/hound/images")
    Call<Dogs> getDogs();
}
