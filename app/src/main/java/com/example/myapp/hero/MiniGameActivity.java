package com.example.myapp.hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.state.ToggleableState;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.hero.data.ApiService;
import com.example.myapp.hero.data.Question;
import com.example.myapp.hero.data.ResponsedApi;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniGameActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://herosapp.nyc3.digitaloceanspaces.com/";
    private static final String TAG = "Retrofit failed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);

        //Intent
       // Intent intent = getIntent();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getResponse().enqueue(new Callback<ResponsedApi>() {
            @Override
            public void onResponse(Call<ResponsedApi> call, Response<ResponsedApi> response) {
                if (response.code() == 200) {
                    ResponsedApi responsedApi = response.body();
                    List<Question> questions = responsedApi.getQuestions();
                    Toast.makeText(MiniGameActivity.this, "" + questions.size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsedApi> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}