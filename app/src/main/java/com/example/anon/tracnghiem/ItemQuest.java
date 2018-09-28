package com.example.anon.tracnghiem;

class ItemQuest {
    private String quest;
    private String[] answers;
    private int idImage;
    private int idFinalDapAn;

    public ItemQuest(String que, String[] ans, int ima, int da) {
        quest = que;
        answers = new String[ans.length];
        for (int i = 0; i < ans.length; ++i) {
            answers[i] = ans[i];
        }
        idImage = ima;
        idFinalDapAn = da;
    }

    public String getQuest() {
        return quest;
    }

    public String[] getAnswers() {
        String[] ret_ans = new String[answers.length];
        for (int i = 0; i < answers.length; ++i) {
            ret_ans[i] = answers[i];
        }
        return ret_ans;
    }

    public int getIdImage() {
        return idImage;
    }

    public int getIdFinalDapAn() {
        return idFinalDapAn;
    }
}
