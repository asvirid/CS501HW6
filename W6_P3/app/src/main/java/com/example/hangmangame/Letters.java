package com.example.hangmangame;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Letters extends Fragment {

    View view;

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

    public Letters() {
        // required empty public constructor
    }

    /* interface definition to send char from keyboard to gallows UI */
    public interface LettersListener {
        public char sendChar(char letter);
    }

    LettersListener LL;

    /* onAttach checks that our fragment was successfully created and hooked to the main activity*/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LL = (LettersListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_letters, container, false);

        /* instantiating all views */
        keyboard = (TableLayout) view.findViewById(R.id.keyboard);
        qwertyuiop = (TableRow) view.findViewById(R.id.qwertyuiop);
        asdfghjkl = (TableRow) view.findViewById(R.id.asdfghjkl);
        zxcvbnm = (TableRow) view.findViewById(R.id.zxcvbnm);
        btnQ = (Button) view.findViewById(R.id.btnQ);
        btnW = (Button) view.findViewById(R.id.btnW);
        btnE = (Button) view.findViewById(R.id.btnE);
        btnR = (Button) view.findViewById(R.id.btnR);
        btnT = (Button) view.findViewById(R.id.btnT);
        btnY = (Button) view.findViewById(R.id.btnY);
        btnU = (Button) view.findViewById(R.id.btnU);
        btnI = (Button) view.findViewById(R.id.btnI);
        btnO = (Button) view.findViewById(R.id.btnO);
        btnP = (Button) view.findViewById(R.id.btnP);
        btnA = (Button) view.findViewById(R.id.btnA);
        btnS = (Button) view.findViewById(R.id.btnS);
        btnD = (Button) view.findViewById(R.id.btnD);
        btnF = (Button) view.findViewById(R.id.btnF);
        btnG = (Button) view.findViewById(R.id.btnG);
        btnH = (Button) view.findViewById(R.id.btnH);
        btnJ = (Button) view.findViewById(R.id.btnJ);
        btnK = (Button) view.findViewById(R.id.btnK);
        btnL = (Button) view.findViewById(R.id.btnL);
        btnZ = (Button) view.findViewById(R.id.btnZ);
        btnX = (Button) view.findViewById(R.id.btnX);
        btnC = (Button) view.findViewById(R.id.btnC);
        btnV = (Button) view.findViewById(R.id.btnV);
        btnB = (Button) view.findViewById(R.id.btnB);
        btnN = (Button) view.findViewById(R.id.btnN);
        btnM = (Button) view.findViewById(R.id.btnM);

        /* setting keyboard visible */
        keyboard.setVisibility(View.VISIBLE);
        keyboardButtons = new Button[]{btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP, btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL, btnZ, btnX, btnC, btnV, btnB, btnN, btnM};
        for (int iter = 0; iter < keyboardButtons.length; iter++) {
            keyboardButtons[iter].setVisibility(View.VISIBLE);
            keyboardButtons[iter].setEnabled(true);
        }

        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('q');
                btnQ.setEnabled(false);
                keyboardButtonsUsed[btnQNum] = 4;
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('w');
                btnW.setEnabled(false);
                keyboardButtonsUsed[btnWNum] = 4;
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('e');
                btnE.setEnabled(false);
                keyboardButtonsUsed[btnENum] = 4;
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('r');
                btnR.setEnabled(false);
                keyboardButtonsUsed[btnRNum] = 4;
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('t');
                btnT.setEnabled(false);
                keyboardButtonsUsed[btnTNum] = 4;
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('y');
                btnY.setEnabled(false);
                keyboardButtonsUsed[btnYNum] = 4;
            }
        });
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('u');
                btnU.setEnabled(false);
                keyboardButtonsUsed[btnUNum] = 4;
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('i');
                btnI.setEnabled(false);
                keyboardButtonsUsed[btnINum] = 4;
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('o');
                btnO.setEnabled(false);
                keyboardButtonsUsed[btnONum] = 4;
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('p');
                btnP.setEnabled(false);
                keyboardButtonsUsed[btnPNum] = 4;
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('a');
                btnA.setEnabled(false);
                keyboardButtonsUsed[btnANum] = 4;
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('s');
                btnS.setEnabled(false);
                keyboardButtonsUsed[btnSNum] = 4;
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('d');
                btnD.setEnabled(false);
                keyboardButtonsUsed[btnDNum] = 4;
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('f');
                btnF.setEnabled(false);
                keyboardButtonsUsed[btnFNum] = 4;
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('g');
                btnG.setEnabled(false);
                keyboardButtonsUsed[btnGNum] = 4;
            }
        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('h');
                btnH.setEnabled(false);
                keyboardButtonsUsed[btnHNum] = 4;
            }
        });
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('j');
                btnJ.setEnabled(false);
                keyboardButtonsUsed[btnJNum] = 4;
            }
        });
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('k');
                btnK.setEnabled(false);
                keyboardButtonsUsed[btnKNum] = 4;
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('l');
                btnL.setEnabled(false);
                keyboardButtonsUsed[btnLNum] = 4;
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('z');
                btnZ.setEnabled(false);
                keyboardButtonsUsed[btnZNum] = 4;
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('x');
                btnX.setEnabled(false);
                keyboardButtonsUsed[btnXNum] = 4;
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('c');
                btnC.setEnabled(false);
                keyboardButtonsUsed[btnCNum] = 4;
            }
        });
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('v');
                btnV.setEnabled(false);
                keyboardButtonsUsed[btnVNum] = 4;
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('b');
                btnB.setEnabled(false);
                keyboardButtonsUsed[btnBNum] = 4;
            }
        });
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('n');
                btnN.setEnabled(false);
                keyboardButtonsUsed[btnNNum] = 4;
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.sendChar('m');
                btnM.setEnabled(false);
                keyboardButtonsUsed[btnMNum] = 4;
            }
        });

        return view;
    }
}