package nyc.muaadh_melhi_develpoer.ourappfinalreview.backend;

import nyc.muaadh_melhi_develpoer.ourappfinalreview.PokeService;
import nyc.muaadh_melhi_develpoer.ourappfinalreview.backend.RetrofitClient;

/**
 * Created by c4q on 2/24/18.
 */

public class Common {
    private static final String BASE_URL = "http://pokeapi.co/api/v2/";

    public static PokeService getPoke(){
        return RetrofitClient.getRetrofitClient(BASE_URL).create(PokeService.class);
    }

}
