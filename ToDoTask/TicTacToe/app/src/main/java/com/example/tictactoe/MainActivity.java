package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    ImageView imageCross;
//    int alphaAmount = 255;
    int[] tictactoeArray = new int[10];
    int i = 0;
    ImageView imageCross;
    ImageView imageCircle;

    ImageView emptyButton11;
    ImageView emptyButton12;
    ImageView emptyButton13;
    ImageView emptyButton21;
    ImageView emptyButton22;
    ImageView emptyButton23;
    ImageView emptyButton31;
    ImageView emptyButton32;
    ImageView emptyButton33;

    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 row
        emptyButton11 = (ImageView) findViewById(R.id.emptyButton11);
        emptyButton12 = (ImageView) findViewById(R.id.emptyButton12);
        emptyButton13 = (ImageView) findViewById(R.id.emptyButton13);
        // 2 row
        emptyButton21 = (ImageView) findViewById(R.id.emptyButton21);
        emptyButton22 = (ImageView) findViewById(R.id.emptyButton22);
        emptyButton23 = (ImageView) findViewById(R.id.emptyButton23);
        // 3 row
        emptyButton31 = (ImageView) findViewById(R.id.emptyButton31);
        emptyButton32 = (ImageView) findViewById(R.id.emptyButton32);
        emptyButton33 = (ImageView) findViewById(R.id.emptyButton33);

        for (int i = 0; i < 9; i++) {
            tictactoeArray[i] = 2;
        }

        resetButton = (Button) findViewById(R.id.resetButton);

    }

    public int counter() {
            return 1;
    }


    public void onClick(View view) {
        i = i + counter();
        if (i % 2 == 0) {
            if (view == emptyButton11) {
                emptyButton11.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[1] = 1;
            }
            if (view == emptyButton12) {
                emptyButton12.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[2] = 1;
            }
            if (view == emptyButton13) {
                emptyButton13.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[3] = 1;
            }
            if (view == emptyButton21) {
                emptyButton21.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[4] = 1;
            }
            if (view == emptyButton22) {
                emptyButton22.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[5] = 1;
            }
            if (view == emptyButton23) {
                emptyButton23.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[6] = 1;
            }
            if (view == emptyButton31) {
                emptyButton31.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[7] = 1;
            }
            if (view == emptyButton32) {
                emptyButton32.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[8] = 1;
            }
            if (view == emptyButton33) {
                emptyButton33.setImageResource(R.drawable.krzyzyk);
                tictactoeArray[9] = 1;
            }
        } else {
            if (view == emptyButton11) {
                emptyButton11.setImageResource(R.drawable.kolko);
                tictactoeArray[1] = 0;
            }
            if (view == emptyButton12) {
                emptyButton12.setImageResource(R.drawable.kolko);
                tictactoeArray[2] = 0;
            }
            if (view == emptyButton13) {
                emptyButton13.setImageResource(R.drawable.kolko);
                tictactoeArray[3] = 0;
            }
            if (view == emptyButton21) {
                emptyButton21.setImageResource(R.drawable.kolko);
                tictactoeArray[4] = 0;
            }
            if (view == emptyButton22) {
                emptyButton22.setImageResource(R.drawable.kolko);
                tictactoeArray[5] = 0;
            }
            if (view == emptyButton23) {
                emptyButton23.setImageResource(R.drawable.kolko);
                tictactoeArray[6] = 0;
            }
            if (view == emptyButton31) {
                emptyButton31.setImageResource(R.drawable.kolko);
                tictactoeArray[7] = 0;
            }
            if (view == emptyButton32) {
                emptyButton32.setImageResource(R.drawable.kolko);
                tictactoeArray[8] = 0;
            }
            if (view == emptyButton33) {
                emptyButton33.setImageResource(R.drawable.kolko);
                tictactoeArray[8] = 0;
            }
        }
        if (
            // Krzyzk
                (tictactoeArray[1] == 1 &&
                        tictactoeArray[2] == 1 &&
                        tictactoeArray[3] == 1) || // poziom 1 2 3
                        (tictactoeArray[1] == 1 &&
                                tictactoeArray[4] == 1 &&
                                tictactoeArray[7] == 1) || // pion 1 4 7
                        (tictactoeArray[1] == 1 &&
                                tictactoeArray[5] == 1 &&
                                tictactoeArray[9] == 1) || // na ukos z 1 5 9
                        (tictactoeArray[3] == 1 &&
                                tictactoeArray[6] == 1 &&
                                tictactoeArray[9] == 1) ||
                        (tictactoeArray[4] == 1 &&
                                tictactoeArray[5] == 1 &&
                                tictactoeArray[6] == 1) ||
                        (tictactoeArray[7] == 1 &&
                                tictactoeArray[8] == 1 &&
                                tictactoeArray[9] == 1) ||
                        (tictactoeArray[2] == 1 &&
                                tictactoeArray[5] == 1 &&
                                tictactoeArray[8] == 1) ||
                        (tictactoeArray[3] == 1 &&
                                tictactoeArray[5] == 1 &&
                                tictactoeArray[7] == 1) ||
                        // Kolko
                        (tictactoeArray[1] == 0 &&
                                tictactoeArray[2] == 0 &&
                                tictactoeArray[3] == 0) || // poziom 1 2 3
                        (tictactoeArray[1] == 0 &&
                                tictactoeArray[4] == 0 &&
                                tictactoeArray[7] == 0) || // pion 1 4 7
                        (tictactoeArray[1] == 0 &&
                                tictactoeArray[5] == 0 &&
                                tictactoeArray[9] == 0) || // na ukos z 1 5 9
                        (tictactoeArray[3] == 0 &&
                                tictactoeArray[6] == 0 &&
                                tictactoeArray[9] == 0) ||
                        (tictactoeArray[4] == 0 &&
                                tictactoeArray[5] == 0 &&
                                tictactoeArray[6] == 0) ||
                        (tictactoeArray[7] == 0 &&
                                tictactoeArray[8] == 0 &&
                                tictactoeArray[9] == 0) ||
                        (tictactoeArray[2] == 0 &&
                                tictactoeArray[5] == 0 &&
                                tictactoeArray[8] == 0) ||
                        (tictactoeArray[3] == 0 &&
                                tictactoeArray[5] == 0 &&
                                tictactoeArray[7] == 0)
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
        }

        if ( view ==  resetButton) {
            this.reset();
        }

    }

    public void reset() {
        // 1 row
        emptyButton11.setImageResource(R.drawable.empty);
        emptyButton12.setImageResource(R.drawable.empty);
        emptyButton13.setImageResource(R.drawable.empty);
        emptyButton21.setImageResource(R.drawable.empty);
        emptyButton22.setImageResource(R.drawable.empty);
        emptyButton23.setImageResource(R.drawable.empty);
        emptyButton31.setImageResource(R.drawable.empty);
        emptyButton32.setImageResource(R.drawable.empty);
        emptyButton33.setImageResource(R.drawable.empty);
        i = 0;
        for (int i = 0; i < 9; i++) {
            tictactoeArray[i] = 2;
        }
    }

}

