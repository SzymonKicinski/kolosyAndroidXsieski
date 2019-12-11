package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button losuj;
    ImageView kwadrat;
    ImageView graniastoslup;
    ImageView kolo;
    ImageView prostokat;
    //    ArrayList<Question> questions = new ArrayList<Question>() {
    ArrayList<Question> questions = new ArrayList<Question>();
    // Tablica
    Question[] questionsTabel = new Question[7];

    // Dynamic IMAGE
    final Integer imgResIdKolo = R.drawable.kolo;
    final Integer imgResIdKwadrat = R.drawable.kwadrat;
    final Integer imgResIdRomb = R.drawable.romb;
    final Integer imgResIdRownloeglobok = R.drawable.rownoleglobok;
    final Integer imgResIdSzcescian = R.drawable.szescian;
    final Integer imgResIdTrojkat = R.drawable.trojkat;
    final Integer imgResIdprostopadloscian = R.drawable.prostopadloscian;
    final Integer imgResIdgraniastoslup = R.drawable.graniastoslup;
    final Integer[] resId = {
            imgResIdgraniastoslup,
            imgResIdKolo,
            imgResIdSzcescian,
            imgResIdKwadrat,
            imgResIdprostopadloscian,
            imgResIdRomb,
            imgResIdRownloeglobok,
            imgResIdTrojkat
    };
    // Kwadrat
    // Kolo
    // Prostopadloscia
    // Romb
    // Prostokat
    // Trojkat
    // Rownloeglobok
    // Szczecian

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.obrazId);
        imageView.setImageResource(R.drawable.figury);
//        setContent();

        // Init variable
        losuj = (Button) findViewById(R.id.losujBtn);
        // Losuj button
        losuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number = losuj();
                preperData(number);
                imageView.setImageResource(resId[number]);
            }
        });
    }

    //Button z odpowiedzia
    public void onClick(View view) {
        Button pressedButton = (Button)view;
        String buttonString = pressedButton.getText().toString();
        checkIfWin(buttonString);
        System.out.println(view.getContext());
        String output = view.getTransitionName();
//        if( view.getTextAlignment() ) {
//
//        }
    }

    private void checkIfWin(String buttonString) {
        System.out.println(buttonString);
        if(
                buttonString == "graniastoslup" ||
                buttonString == "Kolo" ||
                buttonString == "Szescian" ||
                buttonString == "Kwadrat" ||
                buttonString == "Prostopadloscian" ||
                buttonString == "Romb" ||
                buttonString == "Rownloeglobok" ||
                buttonString == "Trojkat"
        ) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Win win");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("You lost, fucking looser");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    // LOSOWANIE
    public int losuj() {
        int min = 0;
        int max = 7;
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    // RESET
    public void reset() {
        losuj();
    }

    public void preperData(Integer i) {
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        switch (i) {
            case 0:

                btn1.setText("graniastoslup");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 1:
                btn1.setText("Kolo");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 2:
                btn1.setText("Szescian");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 3:
                btn1.setText("Kwadrat");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 4:
                btn1.setText("Prostopadloscian");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 5:
                btn1.setText("Romb");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 6:
                btn1.setText("Rownloeglobok");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            case 7:
                btn1.setText("Trojkat");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
            default:
                btn1.setText("DUPA");
                btn2.setText("Dupa");
                btn3.setText("Dupa1");
                btn4.setText("Dupa2");
                break;
        }
    }

    public void setContent() {
        //Kwadrat


//        ImageView kwadrat;
//        kwadrat = (ImageView) findViewById(R.id.obrazId);
//        ImageView kwadrat = null;
//        kwadrat.setImageResource(R.drawable.kwadrat);
        Button bt1 = null;// = (Button) findViewById(R.id.btn1);
        Button bt2 = null;// = (Button) findViewById(R.id.btn2);
        Button bt3 = null;// = (Button) findViewById(R.id.btn3);
        Button bt4 = null;// = (Button) findViewById(R.id.btn4);
        bt1.setText("Kwadrat");
        bt2.setText("2");
        bt3.setText("3");
        bt4.setText("4");
//        Question one = new Question(kwadrat, bt1, bt2, bt3, bt4);
        questionsTabel[0] = new Question("kwadrat", bt1, bt2, bt3, bt4);
//        questions.add(0,one);

        //graniastoslup
        /*ImageView graniastoslup;*/
//        graniastoslup = (ImageView) findViewById(R.id.obrazId);
//        graniastoslup.setImageResource(R.drawable.graniastoslup);
        Button btn1 = null;//= (Button) findViewById(R.id.btn1);
        Button btn2 = null;//= null ;// = (Button) findViewById(R.id.btn2);
        Button btn3 = null;//= null ;// = (Button) findViewById(R.id.btn3);
        Button btn4 = null;//= null ;// = (Button) findViewById(R.id.btn4);
        btn1.setText("graniastoslup");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        questionsTabel[1] = new Question("graniastoslup", btn1, btn2, btn3, btn4);
//        questions.add(1,two);
        //kolo
//        ImageView kolo;
//        kolo = (ImageView) findViewById(R.id.obrazId);
//        kolo.setImageResource(R.drawable.kolo);
        Button btnn1 = null;// = (Button) findViewById(R.id.btn4);
        Button btnn2 = null;// = (Button) findViewById(R.id.btn2);
        Button btnn3 = null;// = (Button) findViewById(R.id.btn3);
        Button btnn4 = null;// = (Button) findViewById(R.id.btn4);
        btnn1.setText("kolo");
        btnn2.setText("2");
        btnn3.setText("3");
        btnn4.setText("4");
        questionsTabel[2] = new Question("kolo", btnn1, btnn2, btnn3, btnn4);
//        questions.add(2,three);
        //kolo
//        ImageView prostokat;
//        prostokat = (ImageView) findViewById(R.id.obrazId);
//        prostokat.setImageResource(R.drawable.prostokat);
        Button bbt1 = null;// = (Button) findViewById(R.id.btn4);
        Button bbt2 = null;// = (Button) findViewById(R.id.btn2);
        Button bbt3 = null;// = (Button) findViewById(R.id.btn3);
        Button bbbt4 = null;// = (Button) findViewById(R.id.btn4);
        bbt1.setText("prostokat");
        bbt2.setText("2");
        bbt3.setText("3");
        bbbt4.setText("4");
        questionsTabel[3] = new Question("prostokat", bbt1, bbt2, bbt3, bbbt4);
//        questions.add(3,four);
        //prostopadloscian
        //ImageView prostokat;
        prostokat = (ImageView) findViewById(R.id.obrazId);
        prostokat.setImageResource(R.drawable.prostopadloscian);
        Button bbbbt1 = null;// = (Button) findViewById(R.id.btn4);
        Button bbbbt2 = null;// = (Button) findViewById(R.id.btn2);
        Button bbbbt3 = null;// = (Button) findViewById(R.id.btn3);
        Button bbbbt4 = null;// = (Button) findViewById(R.id.btn4);
        bbbbt1.setText("prostopadloscian");
        bbbbt2.setText("2");
        bbbbt3.setText("3");
        bbbbt4.setText("4");
        questionsTabel[4] = new Question("prostokat", bbbbt1, bt2, bbbbt2, bbbbt4);
//        questions.add(4,five);

//romb
        //ImageView romb;
//        prostokat = (ImageView) findViewById(R.id.obrazId);
//        prostokat.setImageResource(R.drawable.romb);
        Button bcbbbt1 = null;// = (Button) findViewById(R.id.btn4);
        Button bcbbbt2 = null;// = (Button) findViewById(R.id.btn2);
        Button bcbbbt3 = null;// = (Button) findViewById(R.id.btn3);
        Button bcbbbt4 = null;// = (Button) findViewById(R.id.btn4);
        bcbbbt1.setText("romb");
        bcbbbt2.setText("2");
        bcbbbt3.setText("3");
        bcbbbt4.setText("4");
        questionsTabel[5] = new Question("prostokat", bcbbbt1, bcbbbt2, bcbbbt3, bcbbbt4);
//        questions.add(5,six);

//rownoleglobok
        //ImageView rownoleglobok;
//        prostokat = (ImageView) findViewById(R.id.obrazId);
//        prostokat.setImageResource(R.drawable.rownoleglobok);
        Button abbbbt1 = null;// = (Button) findViewById(R.id.btn4);
        Button abbbbt2 = null;// = (Button) findViewById(R.id.btn2);
        Button abbbbt3 = null;// = (Button) findViewById(R.id.btn3);
        Button abbbbt4 = null;// = (Button) findViewById(R.id.btn4);
        abbbbt1.setText("rownoleglobok");
        abbbbt2.setText("2");
        abbbbt3.setText("3");
        abbbbt4.setText("4");
        questionsTabel[6] = new Question("prostokat", abbbbt1, abbbbt2, abbbbt3, abbbbt4);
//        questions.add(6,seven);

//szescian
        //ImageView szescian;
//        prostokat = (ImageView) findViewById(R.id.obrazId);
//        prostokat.setImageResource(R.drawable.szescian);
        Button wbbbbt1 = null;// = (Button) findViewById(R.id.btn4);
        Button wbbbbt2 = null;// = (Button) findViewById(R.id.btn2);
        Button wbbbbt3 = null;// = (Button) findViewById(R.id.btn3);
        Button wbbbbt4 = null;// = (Button) findViewById(R.id.btn4);
        wbbbbt1.setText("szescian");
        wbbbbt2.setText("2");
        wbbbbt3.setText("3");
        wbbbbt4.setText("4");
        questionsTabel[7] = new Question("prostokat", wbbbbt1, wbbbbt2, wbbbbt3, wbbbbt4);
//        questions.add(7,eight);

        for (int i = 0; i < 7; i++) {
            System.out.println(questionsTabel[i].getButton1());
        }


    }

}
