package com.example.myapp.hero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private Context context;
    private List<Question> questionList;

    public QuestionAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.questions_row, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.firstRow.setText(questionList.get(position).getQuestion());
        holder.secondRow.setText(questionList.get(position).getAnswers().toString());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder{

        TextView firstRow, secondRow;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            firstRow = itemView.findViewById(R.id.first_row);
            secondRow = itemView.findViewById(R.id.second_row);
        }
    }
}
