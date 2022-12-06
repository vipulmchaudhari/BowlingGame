package com.bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<Integer> scoreList = new ArrayList<Integer>();

    private String message;

    private boolean isSuccess;

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
