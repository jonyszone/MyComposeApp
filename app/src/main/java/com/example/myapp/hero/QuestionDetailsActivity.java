package com.example.myapp.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapp.R;
import com.squareup.picasso.Picasso;

public class QuestionDetailsActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);

        imageView = findViewById(R.id.imageView);

        Question question = (Question) getIntent().getSerializableExtra("question");
        if (question != null){
            String imageUrl = question.getQuestionImageUrl();
            Picasso.get().load(imageUrl).into(imageView);
        }
    }
}