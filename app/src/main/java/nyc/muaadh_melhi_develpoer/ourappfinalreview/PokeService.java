package nyc.muaadh_melhi_develpoer.ourappfinalreview;

import nyc.muaadh_melhi_develpoer.ourappfinalreview.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/24/18.
 */

public interface PokeService {

    @GET("pokemon/{id}/")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
