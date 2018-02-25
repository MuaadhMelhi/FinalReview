package nyc.muaadh_melhi_develpoer.ourappfinalreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import nyc.muaadh_melhi_develpoer.ourappfinalreview.backend.Common;
import nyc.muaadh_melhi_develpoer.ourappfinalreview.model.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke);

        //start retrofit call
        PokeService pokeService = Common.getPoke();
        pokeService.getPokemon(1).enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Toast.makeText(PokeActivity.this, "Successful!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokeActivity.this, "Failed!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
