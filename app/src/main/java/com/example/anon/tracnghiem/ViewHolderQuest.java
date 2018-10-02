package com.example.anon.tracnghiem;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ViewHolderQuest {
    private TextView deBai;
    private ImageView anhDapAn;
    private RadioGroup nhieuDapAn;
    private RadioButton dapAn0;
    private RadioButton dapAn1;
    private RadioButton dapAn2;
    private RadioButton dapAn3;
    private Button checkDapAnDung;

    public ViewHolderQuest() {
        deBai = null;
        anhDapAn = null;
        nhieuDapAn = null;
        dapAn0 = null;
        dapAn1 = null;
        dapAn2 = null;
        dapAn3 = null;
        checkDapAnDung = null;
    }

    public void setDeBai(TextView deBai) {
        this.deBai = deBai;
    }

    public void setAnhDapAn(ImageView anhDapAn) {
        this.anhDapAn = anhDapAn;
    }

    public void setNhieuDapAn(RadioGroup nhieuDapAn) {
        this.nhieuDapAn = nhieuDapAn;
    }

    public void setDapAn0(RadioButton dapAn0) {
        this.dapAn0 = dapAn0;
    }

    public void setDapAn1(RadioButton dapAn1) {
        this.dapAn1 = dapAn1;
    }

    public void setDapAn2(RadioButton dapAn2) {
        this.dapAn2 = dapAn2;
    }

    public void setDapAn3(RadioButton dapAn3) {
        this.dapAn3 = dapAn3;
    }

    public void setCheckDapAnDung(Button checkDapAnDung) {
        this.checkDapAnDung = checkDapAnDung;
    }

    public TextView getDeBai() {
        return deBai;
    }

    public ImageView getAnhDapAn() {
        return anhDapAn;
    }

    public RadioGroup getNhieuDapAn() {
        return nhieuDapAn;
    }

    public RadioButton getDapAn0() {
        return dapAn0;
    }

    public RadioButton getDapAn1() {
        return dapAn1;
    }

    public RadioButton getDapAn2() {
        return dapAn2;
    }

    public RadioButton getDapAn3() {
        return dapAn3;
    }

    public Button getCheckDapAnDung() {
        return checkDapAnDung;
    }
}
