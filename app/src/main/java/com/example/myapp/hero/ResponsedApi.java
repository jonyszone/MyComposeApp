
package com.example.myapp.hero;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsedApi {

    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    public ResponsedApi(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public String toString() {
        return "ResponsedApi{" +
                "questions=" + questions +
                '}';
    }
}
