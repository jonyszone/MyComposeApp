package com.example.myapp.hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniGameActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://herosapp.nyc3.digitaloceanspaces.com/";
    private static final String TAG = "Retrofit call";

    private QuestionAdapter questionAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);

        //TextView fTextView = findViewById(R.id.fTextView);
        RecyclerView recyclerView = findViewById(R.id.questionRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);


        apiService.getResponse().enqueue(new Callback<ResponsedApi>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ResponsedApi> call, Response<ResponsedApi> response) {
                if (response.code() == 200) {
                    ResponsedApi responsedApi = response.body();
                   List<Question> questions = responsedApi.getQuestions();
                   questionAdapter = new QuestionAdapter(MiniGameActivity.this, questions);
                   recyclerView.setLayoutManager(linearLayoutManager);
                   recyclerView.setAdapter(questionAdapter);

                    //Toast.makeText(MiniGameActivity.this, "Question size " + questions.size(), Toast.LENGTH_SHORT).show();

                   /* String userContent = "";
                    userContent += "Questions Object: " + response.body().getQuestions().toString()+ "\n\n";

                    fTextView.setOnClickListener(view -> {
                        Question question = questions.get(1);
                        Intent intent = new Intent(getApplicationContext(), QuestionDetailsActivity.class);
                        intent.putExtra("question", question);
                        getApplicationContext().startActivity(intent);
                    });*/

                }else {
                   // fTextView.setText("Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponsedApi> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}