package nyc.muaadh_melhi_develpoer.inclassretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import nyc.muaadh_melhi_develpoer.inclassretrofit.adapter.DogAdpater;
import nyc.muaadh_melhi_develpoer.inclassretrofit.backend.DogService;
import nyc.muaadh_melhi_develpoer.inclassretrofit.modelpart3.Dogs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private DogService dogService;
    private String TAG=MainActivity.class.getSimpleName();

    private String url = "https://dog.ceo/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         dogService = retrofit.create(DogService.class);

         //call
        Call<Dogs> dogsCall= dogService.getDogs();
        dogsCall.enqueue(new Callback<Dogs>() {
            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                List<String> dogsList=response.body().getMessage();
                Log.d(TAG, "onResponse: ");
                RecyclerView recyclerView= (RecyclerView)findViewById(R.id.re);
                DogAdpater dogAdpater=new DogAdpater(dogsList);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
                recyclerView.setAdapter(dogAdpater);
                recyclerView.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

            }
        });



    }

}
