package com.example.hangmangame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Letters.LettersListener {

    /* 23 animals lol */
    static final String[] animals = {"bear","bee","bird","cat","crab","dolphin","cow","duck","snake","frog","giraffe","horse","lion","panda","pig","tiger","turtle","whale","zebra","chicken","dog","elephant","fox"};
    /* 18 foods lol */
    static final String[] food = {"rice","soup","pasta","noodles","corn","bread","apple","butter","beef","pork","sushi","cake","eggs","pear","yogurt","avocado","tomato","grape"};
    /* 17 music lol */
    static final String[] music = {"guitar","violin","viola","cello","bass","piano","drums","clarinet","flute","trumpet","harp","jazz","indie","pop","classical","rock","edm"};
    /* array of arrays */
    static final String[][] allWords = {animals, food, music};

    static final String[] categories = {"animals", "food", "music"};

    boolean game = false;

    int countWrong = 0; // number wrong
    char[] randomWordArray = {}; // word selected put into char array
    String wordSelectedUnderscores = ""; // displayed string of underscores
    ArrayList<Character> wordSelectedUnderscoresArr = new ArrayList<Character>(); // displayed string of underscores arraylist

    private TextView wordSelected; // word selected textview
    private Button btnStartGame;

    private TableLayout keyboard;
    private TableRow qwertyuiop;
    private TableRow asdfghjkl;
    private TableRow zxcvbnm;
    private Button btnQ;
    private Button btnW;
    private Button btnE;
    private Button btnR;
    private Button btnT;
    private Button btnY;
    private Button btnU;
    private Button btnI;
    private Button btnO;
    private Button btnP;
    private Button btnA;
    private Button btnS;
    private Button btnD;
    private Button btnF;
    private Button btnG;
    private Button btnH;
    private Button btnJ;
    private Button btnK;
    private Button btnL;
    private Button btnZ;
    private Button btnX;
    private Button btnC;
    private Button btnV;
    private Button btnB;
    private Button btnN;
    private Button btnM;
    private Button hint;
    int btnQNum = 0;
    int btnWNum = 1;
    int btnENum = 2;
    int btnRNum = 3;
    int btnTNum = 4;
    int btnYNum = 5;
    int btnUNum = 6;
    int btnINum = 7;
    int btnONum = 8;
    int btnPNum = 9;
    int btnANum = 10;
    int btnSNum = 11;
    int btnDNum = 12;
    int btnFNum = 13;
    int btnGNum = 14;
    int btnHNum = 15;
    int btnJNum = 16;
    int btnKNum = 17;
    int btnLNum = 18;
    int btnZNum = 19;
    int btnXNum = 20;
    int btnCNum = 21;
    int btnVNum = 22;
    int btnBNum = 23;
    int btnNNum = 24;
    int btnMNum = 25;
    private Button[] keyboardButtons;
    int[] keyboardButtonsUsed = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // list of btn visibility (0 = visible, 4 = invisible)

    int counthint = 0;
    String category;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countWrong", countWrong);
        outState.putCharArray("randomWordArray", randomWordArray);
        outState.putString("wordSelected", wordSelected.getText().toString());
        outState.putIntArray("keyboardButtonsUsed", keyboardButtonsUsed);
        outState.putBoolean("game", game);
        outState.putInt("hintStatus", counthint);
        outState.putString("category", category);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int savedCountWrong = savedInstanceState.getInt("countWrong");
        countWrong = savedCountWrong;
//        hangmanHead = (ImageView) findViewById(R.id.hangmanHead);
//        hangmanTorso = (ImageView) findViewById(R.id.hangmanTorso);
//        hangmanLeftArm = (ImageView) findViewById(R.id.hangmanLeftArm);
//        hangmanRightArm = (ImageView) findViewById(R.id.hangmanRightArm);
//        hangmanLeftLeg = (ImageView) findViewById(R.id.hangmanLeftLeg);
//        hangmanRightLeg = (ImageView) findViewById(R.id.hangmanRightLeg);
//        hangmanBody = new ImageView[]{hangmanLeftLeg, hangmanRightLeg, hangmanLeftArm, hangmanRightArm, hangmanTorso, hangmanHead};
//        for (int iter = 0; iter < countWrong; iter++) {
//            hangmanBody[iter].setVisibility(View.VISIBLE);
//        }

        char[] savedRandomWordArray = savedInstanceState.getCharArray("randomWordArray");
        randomWordArray = savedRandomWordArray;

        String savedWordSelected = savedInstanceState.getString("wordSelected");
        wordSelected.setText(savedWordSelected);
        for (char c : savedWordSelected.toCharArray()) {
            wordSelectedUnderscoresArr.add(c);
        }

        int[] savedKeyboardButtonsUsed = savedInstanceState.getIntArray("keyboardButtonsUsed");
        keyboardButtons = new Button[]{btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP, btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL, btnZ, btnX, btnC, btnV, btnB, btnN, btnM};
        for (int iter = 0; iter < savedKeyboardButtonsUsed.length; iter++) {
            keyboardButtons[iter].setVisibility(savedKeyboardButtonsUsed[iter]);
        }

        String savedCategory = savedInstanceState.getString("category");
        category = savedCategory;

        boolean savedGame = savedInstanceState.getBoolean("game");
        game = savedGame;

        if (game) {
//            hangmanFrame.setVisibility(View.VISIBLE);
            keyboard.setVisibility(View.VISIBLE);

            int savedHintStatus = savedInstanceState.getInt("hintStatus");
            counthint = savedHintStatus;
            int orientation = getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // In landscape
                hint.setVisibility(View.VISIBLE);
            } else {
                // In portrait
                hint.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        hangmanFrame = (ImageView) findViewById(R.id.hangmanFrame);
//        hangmanHead = (ImageView) findViewById(R.id.hangmanHead);
//        hangmanTorso = (ImageView) findViewById(R.id.hangmanTorso);
//        hangmanLeftArm = (ImageView) findViewById(R.id.hangmanLeftArm);
//        hangmanRightArm = (ImageView) findViewById(R.id.hangmanRightArm);
//        hangmanLeftLeg = (ImageView) findViewById(R.id.hangmanLeftLeg);
//        hangmanRightLeg = (ImageView) findViewById(R.id.hangmanRightLeg);
        wordSelected = (TextView) findViewById(R.id.wordSelected);
        btnStartGame = (Button) findViewById(R.id.btnStartGame);
        hint = (Button) findViewById(R.id.hint);

//        keyboard = (TableLayout) findViewById(R.id.keyboard);
//        qwertyuiop = (TableRow) findViewById(R.id.qwertyuiop);
//        asdfghjkl = (TableRow) findViewById(R.id.asdfghjkl);
//        zxcvbnm = (TableRow) findViewById(R.id.zxcvbnm);
//
//        btnQ = (Button) findViewById(R.id.btnQ);
//        btnW = (Button) findViewById(R.id.btnW);
//        btnE = (Button) findViewById(R.id.btnE);
//        btnR = (Button) findViewById(R.id.btnR);
//        btnT = (Button) findViewById(R.id.btnT);
//        btnY = (Button) findViewById(R.id.btnY);
//        btnU = (Button) findViewById(R.id.btnU);
//        btnI = (Button) findViewById(R.id.btnI);
//        btnO = (Button) findViewById(R.id.btnO);
//        btnP = (Button) findViewById(R.id.btnP);
//        btnA = (Button) findViewById(R.id.btnA);
//        btnS = (Button) findViewById(R.id.btnS);
//        btnD = (Button) findViewById(R.id.btnD);
//        btnF = (Button) findViewById(R.id.btnF);
//        btnG = (Button) findViewById(R.id.btnG);
//        btnH = (Button) findViewById(R.id.btnH);
//        btnJ = (Button) findViewById(R.id.btnJ);
//        btnK = (Button) findViewById(R.id.btnK);
//        btnL = (Button) findViewById(R.id.btnL);
//        btnZ = (Button) findViewById(R.id.btnZ);
//        btnX = (Button) findViewById(R.id.btnX);
//        btnC = (Button) findViewById(R.id.btnC);
//        btnV = (Button) findViewById(R.id.btnV);
//        btnB = (Button) findViewById(R.id.btnB);
//        btnN = (Button) findViewById(R.id.btnN);
//        btnM = (Button) findViewById(R.id.btnM);

        btnStartGame.setText("Start Game");
        /* START GAME */
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game = true;
//                hangmanFrame.setVisibility(View.VISIBLE);

                /* everything is in landscape for this */
//                int orientation = getResources().getConfiguration().orientation;
//                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//                    // In landscape
//                    hint.setVisibility(View.VISIBLE);
//                } else {
//                    // In portrait
//                    hint.setVisibility(View.INVISIBLE);
//                }

                // for restarting
                countWrong = 0;
                wordSelectedUnderscores = "";
                wordSelectedUnderscoresArr.clear();

                // randomly selects category
                int randomArrChooser = new Random().nextInt(allWords.length);
                category = categories[randomArrChooser];
                String[] randomArrSelected = allWords[randomArrChooser];
                // randomly selects word from category
                int randomKeyChooser = new Random().nextInt(randomArrSelected.length);
                String randomKeySelected = randomArrSelected[randomKeyChooser];
                // turning word into array of chars
                randomWordArray = randomKeySelected.toCharArray();
                System.out.println(randomWordArray);

                // TO DO: send word to gallows.java
                /**
                 * logic
                 * 1. start game
                 * 2. word selected in main activity
                 * 3. word string builder sent to gallows.java to create UI and underscores
                 * 4. keyboard turns on
                 * 5. keyboard button click
                 * 5a. letters.java interface to activity to gallows.java
                 * 5b. disable button after click
                 * 6. gallows.java checks if letter in word and update
                 * 7. hint button separate
                 */

                // building the underscores
                for (int iter = 0; iter < randomWordArray.length; iter++) {
                    wordSelectedUnderscores += "_";
                    wordSelectedUnderscoresArr.add('_');
                }
                // displaying the underscores of the word
                wordSelected.setText(wordSelectedUnderscores);

                // start up the keyboard
                keyboard.setVisibility(View.VISIBLE);

            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counthint++;
                if (counthint < 2) {
                    Toast.makeText(getApplicationContext(), category.toString(), Toast.LENGTH_LONG).show();
                } else if (counthint == 2) {
                    hangmanBody[countWrong].setVisibility(View.VISIBLE);
                    countWrong++;
                    hint.setVisibility(View.INVISIBLE);

                    // 6 wrongs = end game -> Toast & turn off keyboard
                    if (countWrong == hangmanBody.length) {
                        keyboard.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "OH NO! You killed Hangman! Game Over. Try again :)", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        counthint = 0;
    }

    @Override
    public char sendChar(char letter) {
        
    }

    /*
    *
    * randomly choose from three arrays a word from that array
    * dynamically set underscores to length of word
    * at same time, set up array of chars of that word
    *
    * at start game --> toast instructions
    *
    * while loop up to 6 (number of hangman parts)
    * countWrong
    * --> while (countWrong < 6) { guess as many times as user wants }
    * add user input letters into array to not repeat entries
    *
    * if countWrong == 1 -> head shows up, set to visible  (Toast wrong)
    * 2 -> torso, etc
    *
    * if user input correct -> Toast correct letter
    * update dynamically
    *
    * if all right -> Toast u r smarter than the average person
    *
    * if countWrong == 6 -> Toast game over u suck lol and end game (while loop over)
    *
    * start new game
    * set all limbs back to invisible
    * countWrong = 0
    *
    * landscape mode
    * new intent
    * start activity
    * adjust constraints and sizing
    * hint is the array name
    *
    * */
}