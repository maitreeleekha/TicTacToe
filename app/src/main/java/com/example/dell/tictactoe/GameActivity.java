package com.example.dell.tictactoe;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.src;
import static android.widget.Toast.LENGTH_SHORT;
import static com.example.dell.tictactoe.R.*;


/**
 * Created by Dell on 13.Dec.2017.
 */

public class GameActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    int i;
    char turn='X';
    Button[] buttons;
    TextView status;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("GameActivity", "Welcome to the game players!");
        setContentView(layout.gamelayout);

        b1 = (Button) findViewById(id.button);
        b2 = (Button) findViewById(id.button2);
        b3 = (Button) findViewById(id.button3);
        b4 = (Button) findViewById(id.button4);
        b5 = (Button) findViewById(id.button5);
        b6 = (Button) findViewById(id.button6);
        b7 = (Button) findViewById(id.button7);
        b8 = (Button) findViewById(id.button8);
        b9 = (Button) findViewById(id.button9);

        status = (TextView) findViewById(id.status);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/news_cycle.ttf");
        status.setTypeface(typeface);
        status.setText("Player Turn: "+turn);
        status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));

        buttons = new Button[]{b1, b2, b3, b4, b5, b6, b7, b8, b9};
        turn = 'X';
        for (i = 0; i < 9; i++) {

            Button btemp = (Button) buttons[i];
            btemp.setTypeface(typeface);
            btemp.setOnClickListener(Turn(btemp));
        }

      /*  boolean rowEqual;
        if (checkRowEquality(buttons)) rowEqual = true;
        else rowEqual = false;
        if (rowEqual == true) {

            Toast t = Toast.makeText(this, "GAME OVER!", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(this, "DRAW!", Toast.LENGTH_LONG);
            t.show();
        }*/


    }

    private boolean checkRowEquality() {

             if((buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")||
                (buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O"))
             {
                 buttons[0].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
                 buttons[1].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
                 buttons[2].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
                 return true;
             }
                 else if((buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")||
                (buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O"))
        {
            buttons[3].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            buttons[4].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            buttons[5].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            return true;

        }
                     else if((buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")||
                           (buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O"))
        {
            buttons[6].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            buttons[7].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            buttons[8].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
            return true;
        }
        return false;
    }

private boolean checkColumnEquality(){

         if((buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")||
            (buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O"))
         {
             buttons[0].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[3].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[6].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             return true;
         }
           else if( (buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")||
            (buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O"))
         {

             buttons[1].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[4].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[7].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             return  true;

         }
           else if( (buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")||
            (buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O"))

         {
             buttons[2].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[5].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[8].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             return true;}

             return false;
}

private boolean checkDiagonalEquality(){
         if((buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")||
            (buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O"))
         {
             buttons[0].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[4].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[8].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             return true;
         }
           else if( (buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")||
            (buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O"))
         {    buttons[2].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[4].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             buttons[6].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.white))));
             return true;}

    return false;
}

private boolean checkAllDisabled(){

    for(int j=0;j<9;j++){
        if(buttons[j].isEnabled()==true)
        {return false;}
    }

    return true;

}

private void setAllDisabled(){
    for(int j=0;j<9;j++){
        if(buttons[j].isEnabled()){
            buttons[j].setEnabled(false);
        }
    }
}

    View.OnClickListener Turn(final Button button) {

        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (turn == 'X') {
                    button.setText("X");
                    button.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                    turn = 'O';
                    status.setText("Player Turn: "+turn);
                    status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));

                    button.setEnabled(false);
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), raw.click);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                } else {
                    button.setText("O");
                    button.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                    turn = 'X';
                    status.setText("Player Turn: "+turn);
                    status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                    button.setEnabled(false);
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), raw.clickme);
                    mediaPlayer.start();
                }

           /*     String text = (String) button.getText();
                Toast t = Toast.makeText(getApplicationContext(), text , LENGTH_SHORT);
                t.show();
            */

                boolean req =  checkRowEquality();
                boolean ceq = checkColumnEquality();
                boolean deq = checkDiagonalEquality();
                boolean win=false;
                final ImageView playAgain = (ImageView) findViewById(id.playAgain);
                final TextView playAgaintv = (TextView) findViewById(id.playAgaintv);
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/news_cycle.ttf");
                playAgaintv.setTypeface(typeface);

                playAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.play);
                        mp.start();
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                        ResetGameBoard();
                    }

                    private void ResetGameBoard() {

                        for(int j=0;j<9;j++){
                                buttons[j].setEnabled(true);
                                buttons[j].setText("");
                                status.setText("Player Turn: X");
                                status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                                playAgain.setVisibility(View.INVISIBLE);
                                playAgaintv.setVisibility(View.INVISIBLE);
                                buttons[j].setBackgroundColor(getResources().getColor(Integer.parseInt(String.valueOf(color.grey))));
                            }
                    }
                });

                if ((req || ceq || deq) && turn=='O')
                {
                    status.setText("X WINS!!!");
                    status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                    win=true;
                    setAllDisabled();
                    playAgain.setVisibility(View.VISIBLE);
                    playAgaintv.setVisibility(View.VISIBLE);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.win);
                    mp.start();

            }

                else if((req || ceq || deq) && turn=='X')
                {
                    status.setText("O WINS!!!");
                    status.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                    setAllDisabled();
                    win=true;
                    playAgaintv.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.win);
                    mp.start();

                }

                if(win!=true && checkAllDisabled()){
                    status.setText("DRAW!");
                    playAgaintv.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), raw.win);
                    mp.start();
                }



            }

            ;
        };
    }
}



        /*
        while (i < 9) {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i%2 == 0) {
                        b1.setText("X");
                        b1.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                        b1.setEnabled(false);

                    } else {


                        b1.setText("O");
                        b1.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                        b1.setEnabled(false);
                    }
                }
            });


            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i % 2 == 0) {
                        b2.setText("X");
                        b2.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                        b2.setEnabled(false);
                    } else {
                        b2.setText("O");
                        b2.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                        b2.setEnabled(false);

                    }
                }
            });


            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i % 2 == 0) {
                        b3.setText("X");
                        b3.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                        b3.setEnabled(false);
                    } else {
                        b3.setText("O");
                        b3.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                        b3.setEnabled(false);

                    }
                }
            });
            i++;
        }


    }

}


/*
    public void bluePlyerTurn(){

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setText("X");
                b1.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b1.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setText("X");
                b2.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b2.setEnabled(false);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setText("X");
                b3.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b3.setEnabled(false);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setText("X");
                b4.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b4.setEnabled(false);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.setText("X");
                b5.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b5.setEnabled(false);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6.setText("X");
                b6.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b6.setEnabled(false);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b7.setText("X");
                b7.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b7.setEnabled(false);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b8.setText("X");
                b8.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b8.setEnabled(false);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b9.setText("X");
                b9.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorPrimaryDark))));
                b9.setEnabled(false);
            }
        });

    }

    public void redPlyerTurn(){


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setText("O");
                b1.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b1.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setText("O");
                b2.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b2.setEnabled(false);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setText("O");
                b3.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b3.setEnabled(false);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setText("O");
                b4.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b4.setEnabled(false);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.setText("O");
                b5.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b5.setEnabled(false);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6.setText("O");
                b6.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b6.setEnabled(false);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b7.setText("O");
                b7.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b7.setEnabled(false);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b8.setText("O");
                b8.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b8.setEnabled(false);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b9.setText("O");
                b9.setTextColor(getResources().getColor(Integer.parseInt(String.valueOf(color.colorAccent))));
                b9.setEnabled(false);
            }
        });


    }
}
*/
