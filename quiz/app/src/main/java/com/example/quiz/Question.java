package com.example.quiz;

import android.widget.Button;
import android.widget.ImageView;


public class Question {

    public String imageView;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button button4) {
        this.button4 = button4;
    }

    public Question(String iv, Button bt1, Button bt2, Button bt3, Button bt4) {
        this.imageView = iv;
        this.button1 = bt1;
        this.button2 = bt2;
        this.button3 = bt3;
        this.button4 = bt4;
    }
}
