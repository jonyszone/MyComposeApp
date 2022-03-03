
package com.example.myapp.hero;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Question implements Serializable {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answers")
    @Expose
    private Answers answers;
    @SerializedName("questionImageUrl")
    @Expose
    private String questionImageUrl;
    @SerializedName("correctAnswer")
    @Expose
    private String correctAnswer;
    @SerializedName("score")
    @Expose
    private Integer score;

    public Question(String question, Answers answers, String questionImageUrl, String correctAnswer, Integer score) {
        this.question = question;
        this.answers = answers;
        this.questionImageUrl = questionImageUrl;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public String getQuestionImageUrl() {
        return questionImageUrl;
    }

    public void setQuestionImageUrl(String questionImageUrl) {
        this.questionImageUrl = questionImageUrl;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @NonNull
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", questionImageUrl='" + questionImageUrl + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", score=" + score +
                '}';
    }
}
