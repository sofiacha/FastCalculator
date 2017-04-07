package com.example.sofak.fastcalculator;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;



public class MainActivity extends AppCompatActivity {

    //declaration and initialization of variables
    int count, cdot;
    int countdot = 0;
    int countpr = 0;
    int tvend;
    int tvlength;
    int i;
    String old;
    String old1;
    char aChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaration initialisation elements of the layout
        final com.example.sofak.fastcalculator.AutoResizeTextView tv = (com.example.sofak.fastcalculator.AutoResizeTextView) findViewById(R.id.canvas);
                 //TODO  Allazw textview me editext*/


        /*EditText numbers = (EditText) findViewById(R.id.edit_numbers);
        *         <EditText
            android:id="@+id/edit_numbers"
            android:layout_width="fill_parent"
            android:layout_height="78dp"
            android:textSize="100px"
            android:inputType="phone"
            android:textAlignment="textEnd"/>  */

        //for each button I create a function
       Button back = (Button) findViewById(R.id.backspace);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                //checks if textview has context before deleting
                if (tv.getText().length()>1){
                old = tv.getText().subSequence(0,tv.getText().length()-1).toString();
                tv.setText(old);
                }
                else {
                    tv.setText("0");
                }
            }
        });
        Button clea = (Button) findViewById(R.id.clear);
        clea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                tv.setTextSize(50);
                tv.setText("0");
            }
        });
        Button pare = (Button) findViewById(R.id.parenthesis);
        pare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                //variable that counts how many parenthesis have already been put, both ( and )
                count = 1;
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length();
                //if there is a zero in the numbers it puts ( or ) depending on how much parenthesis have been put already
                //counting the parenthesis that have already been put in textview
               // int ij = tv.getText().length()-1;
                if(tvend>=1){
                    int ij = tv.getText().length()-1;
                    Log.d("PAra", Integer.toString(ij));
                      while(ij>0 && (tv.getText().charAt(ij)!='(' && tv.getText().charAt(ij)!=')')){
                          Log.d("PAra", Integer.toString(ij));
                          ij--;
                      }
                       //depending of the number of counts ( or ) will be put
                        if (tv.getText().charAt(ij)=='(') {
                            Log.d("PAra", Integer.toString(ij));
                            Log.d("PAraCha", Character.toString(tv.getText().charAt(ij)));
                            if(tv.getText().charAt(tvend-1)=='('||tv.getText().charAt(tvend-1)=='+'||tv.getText().charAt(tvend-1)=='-'||tv.getText().charAt(tvend-1)=='/' ||tv.getText().charAt(tvend-1)=='*') {
                                old = tv.getText().toString();
                                tv.setText(old + "(");
                            }else if(tv.getText().charAt(tvend-1)=='.'){
                                old = tv.getText().subSequence(0, tv.getText().length() - 1).toString();
                                tv.setText(old+ ")");
                            }else{
                                old = tv.getText().toString();
                                tv.setText(old + ")");
                            }
                        }else if (tv.getText().charAt(ij)==')'){
                            Log.d("PAra", Integer.toString(ij));
                            Log.d("PAraCha", Character.toString(tv.getText().charAt(ij)));
                            old = tv.getText().toString();
                            if(tv.getText().charAt(tvend-1)=='+'||tv.getText().charAt(tvend-1)=='-'||tv.getText().charAt(tvend-1)=='/' ||tv.getText().charAt(tvend-1)=='*'){
                                tv.setText(old + "(");
                            }else if(tv.getText().charAt(tvend-1)=='.'){
                                old = tv.getText().subSequence(0, tv.getText().length() - 1).toString();
                                tv.setText(old+ "(");
                            }else{
                                tv.setText(old + "*(");
                            }
                        }else{
                            if(tv.getText().charAt(tvend-1)=='+'||tv.getText().charAt(tvend-1)=='-'||tv.getText().charAt(tvend-1)=='/' ||tv.getText().charAt(tvend-1)=='*'){
                                old = tv.getText().toString();
                                tv.setText(old + "(");
                            }else if(tv.getText().charAt(tvend-1)=='.'){
                                old = tv.getText().subSequence(0, tv.getText().length() - 1).toString();
                                tv.setText(old+ "*(");
                            }else{
                                old = tv.getText().toString();
                                tv.setText(old + "*(");
                            }
                        }
                }else{
                    tv.setText("(");
                }
            }
        });
        Button percent = (Button) findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                //checking if there is already a percent symbol before putting a new one
                if(tv.getText().charAt(tv.getText().length()-1)==')'||tv.getText().charAt(tv.getText().length()-1)=='('||tv.getText().charAt(tv.getText().length()-1)=='%'||tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='/') {
                    tv.setText(old);
                }else if(tv.getText().charAt(tv.getText().length()-1)=='.'){
                    old = tv.getText().subSequence(0, tv.getText().length() - 1).toString();
                    tv.setText(old + "%");
                }else{
                    tv.setText(old + "%");
                }
            }
        });
        Button dia = (Button) findViewById(R.id.dia);
        dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
               // old = tv.getText().toString();
                //checking if there is a number to divise or if it is zero
                if (tv.getText().length()>0 ) {
                    //if there is already another symbol(+,-,*) it changes to / and if is already a / symbol it doesn't add an extra one.
                    if(tv.getText().charAt(tv.getText().length()-1)=='/'||tv.getText().charAt(tv.getText().length()-1)=='(') {
                        old = tv.getText().toString();
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='-'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "/";
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='.') {
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "/";
                        tv.setText(old);
                    }else{
                        old = tv.getText().toString();
                        tv.setText(old + "/");
                    }
                }
            }
        });
        Button dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                //checking if there is already a dot
                for(int i=0;i<tv.getText().length();i++) {
                    if(tv.getText().charAt(i)=='.'){
                        countdot++;
                        cdot = i;
                    }
                    if(tv.getText().charAt(i)=='+'||tv.getText().charAt(i)=='-'||tv.getText().charAt(i)=='*'||tv.getText().charAt(i)=='/'){
                        countpr=i;
                    }
                }
                if(countdot==0){
                    tv.setText(old + ".");
                }
                else{
                    if(countpr>cdot){
                        tv.setText(old + ".");
                    }
                }
                countdot=0;
                countpr=0;
            }
        });
        Button epi = (Button) findViewById(R.id.epi);
        epi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                //checking if there is a number to multiplie or if it is zero
                if (tv.getText().length()>0) {
                    //if there is already another symbol(+,-,/) it changes to * and if is already a * symbol it doesn't add an extra one.
                    if(tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='(') {
                        old = tv.getText().toString();
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='/'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "*";
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='.') {
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "*";
                        tv.setText(old);
                    }else{
                        old = tv.getText().toString();
                        tv.setText(old + "*");
                    }
                }
            }
        });
        Button meion = (Button) findViewById(R.id.meion);
        meion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                //checking if there is a number to subtract or if it is zero
                if (tv.getText().length()>0) {
                    //if there is already another symbol(+,/,*) it changes to - and if is already a - symbol it doesn't add an extra one.
                    if(tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='(') {
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='/'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "-";
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='.') {
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "-";
                        tv.setText(old);
                    }else{
                        tv.setText(old + "-");
                    }
                }
            }
        });
        Button kai = (Button) findViewById(R.id.kai);
        kai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                //checking if there is a number to add or if it is zero
                if (tv.getText().length()>0) {
                    //if there is already another symbol(/,-,*) it changes to + and if is already a + symbol it doesn't add an extra one.
                    if(tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='(') {
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='/'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "+";
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='.') {
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "+";
                        tv.setText(old);
                    }else{
                        tv.setText(old + "+");
                    }
                }
            }
        });
        Button oxtw = (Button) findViewById(R.id.eight);
        oxtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "8");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "8");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*8");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "8");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("8");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "8");
                        }
                    }
                }
            }
        });
        Button ennia = (Button) findViewById(R.id.nine);
        ennia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "9");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "9");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*9");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "9");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("9");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "9");
                        }
                    }
                }
            }
        });
        Button efta = (Button) findViewById(R.id.seven);
        efta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "7");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "7");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*7");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "7");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("7");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "7");
                        }
                    }
                }
            }
        });
        Button exi = (Button) findViewById(R.id.six);
        exi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "6");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "6");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*6");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "6");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("6");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "6");
                        }
                    }
                }
            }
        });
        Button pente = (Button) findViewById(R.id.five);
        pente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "5");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "5");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*5");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "5");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("5");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "5");
                        }
                    }
                }
            }
        });
        Button tessera = (Button) findViewById(R.id.four);
        tessera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "4");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "4");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*4");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "4");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("4");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "4");
                        }
                    }
                }
            }
        });
        Button tria = (Button) findViewById(R.id.three);
        tria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "3");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "3");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*3");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "3");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("3");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "3");
                        }
                    }
                }
            }

        });
        Button duo = (Button) findViewById(R.id.two);
        duo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                        if (tv.getText().length() > 1) {
                            if (aChar == '-' && tv.getText().charAt(1)=='0'){
                                old = tv.getText().subSequence(0, tvend).toString();
                                tv.setText(old + "2");
                            }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                                old = tv.getText().subSequence(0, tvend).toString();
                                tv.setText(old + "2");
                            }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                                old = tv.getText().toString();
                                tv.setText(old + "*2");
                            }else{
                                old = tv.getText().toString();
                                tv.setText(old + "2");
                            }
                        } else {
                            if (aChar == '0') {
                                 tv.setText("2");
                            } else {
                                old = tv.getText().toString();
                                tv.setText(old + "2");
                            }
                        }
                }
            }
        });
        Button ena = (Button) findViewById(R.id.one);
        ena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 2 or if it is zero so it changes it to 2
                    if (tv.getText().length() > 1) {
                        if (aChar == '-' && tv.getText().charAt(1)=='0'){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "1");
                        }else if( tv.getText().charAt(tv.getText().length() - 1)=='0' &&(tv.getText().charAt(tv.getText().length() - 2)=='+'||tv.getText().charAt(tv.getText().length() - 2)=='-'||tv.getText().charAt(tv.getText().length() - 2)=='*'||tv.getText().charAt(tv.getText().length() - 2)=='/')){
                            old = tv.getText().subSequence(0, tvend).toString();
                            tv.setText(old + "1");
                        }else if(tv.getText().charAt(tv.getText().length() - 1)==')'||tv.getText().charAt(tv.getText().length() - 1)=='%'){
                            old = tv.getText().toString();
                            tv.setText(old + "*1");
                        }else{
                            old = tv.getText().toString();
                            tv.setText(old + "1");
                        }
                    } else {
                        if (aChar == '0') {
                            tv.setText("1");
                        } else {
                            old = tv.getText().toString();
                            tv.setText(old + "1");
                        }
                    }
                }
            }
        });
        Button mhden = (Button) findViewById(R.id.zero);
        mhden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
                    //checking if there is already a number and adds 0 or if it is zero so it changes it to 0
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "0");
                        } else {
                            tv.setText("0");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "0");
                    }
                }
            }
        });
        Button ison = (Button) findViewById(R.id.ison);
        ison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                Random r = new Random();
                final int i1 = r.nextInt(1000) + 1;
                //randomises the output
                tv.setText(Integer.toString(i1));
                final Handler handler = new Handler();
                //I am using a handler to postpone the dialog box for 1sec
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 1000ms
                        //I am creating the dialog window and dismiss it after taping inside it
                        final Dialog d = new Dialog(MainActivity.this) {
                            @Override
                            public boolean onTouchEvent(MotionEvent event) {
                                // Tap anywhere to close dialog.
                                this.dismiss();
                                return true;
                            }
                        };
                        d.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                        //initialize the specific layout
                        d.setContentView(getLayoutInflater().inflate(R.layout.tryfragment, null));
                        //setting the answer to dialog window
                        TextView titel = (TextView) d.findViewById(R.id.answer);
                        titel.setText("The answer is "+Integer.toString(i1));
                        //giving specific parameters to window
                        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                        getWindow().setFormat(PixelFormat.RGBA_8888);
                        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        lp.copyFrom(d.getWindow().getAttributes());
                        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        d.show();
                        d.getWindow().setAttributes(lp);
                    }
                }, 1000);
            }
        });
        Button synplyn = (Button) findViewById(R.id.synplun);
        synplyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length();
                tvlength = tv.getText().length();
                //searching from end to start the textview for a symbol, end to 1 (not 0)
                while((tv.getText().charAt(tvlength-1)!= '+' && tv.getText().charAt(tvlength-1)!= '-' && tv.getText().charAt(tvlength-1)!= '*'&& tv.getText().charAt(tvlength-1)!= '/'&&tvlength>1)){
                    tvlength--;
                }
                //depending on what the symbol is
                switch (tv.getText().charAt(tvlength-1)) {
                    case '+':
                        //if it is in the end then we change it
                        if(tvlength-1==tvend-1){
                            old1 = tv.getText().subSequence(0,tvlength-1).toString() + "-" ;
                            tv.setText(old1);
                        }else {//if it is somewhere in between then we create a string that has the string that it was before but we change the symbol
                            old1 = tv.getText().subSequence(0, tvlength - 1).toString() + "-" + tv.getText().subSequence(tvlength , tvend).toString();
                            tv.setText(old1);
                        }
                        break;
                    case '-':
                        if(tvlength-1==0){
                            old1 = tv.getText().subSequence(1,tvend).toString();
                            tv.setText(old1);
                        }
                        else if(tvlength-1==tvend-1 ){
                            if ( tvlength-2!='(') {
                                old1 = tv.getText().subSequence(0, tvlength - 1).toString() + "+";
                                tv.setText(old1);
                            }else{
                                old1 = tv.getText().subSequence(0, tvlength - 1).toString();
                                tv.setText(old1);
                            }
                        }else {
                            if(tv.getText().charAt(tvlength-2)!='('){
                                old1 = tv.getText().subSequence(0, tvlength - 1).toString() + "+" + tv.getText().subSequence(tvlength , tvend ).toString();
                                tv.setText(old1);
                            }else{
                                old1 = tv.getText().subSequence(0, tvlength - 2).toString() +  tv.getText().subSequence(tvlength , tvend ).toString();
                                tv.setText(old1);
                            }
                        }
                        break;
                    case '*':
                        if(tvlength-1==tvend-1){
                            old1 = tv.getText().subSequence(0,tvlength-2).toString() + "*(-" ;
                            tv.setText(old1);
                        }else {
                            old1 = tv.getText().subSequence(0, tvlength - 1).toString() + "*(-" + tv.getText().subSequence(tvlength , tvend ).toString();
                            tv.setText(old1);
                        }
                        break;
                    case '/':
                        if(tvlength-1==tvend-1){
                            old1 = tv.getText().subSequence(0,tvlength-2).toString() + "/(-" ;
                            tv.setText(old1);
                        }else {
                            old1 = tv.getText().subSequence(0, tvlength - 1).toString() + "/(-" + tv.getText().subSequence(tvlength , tvend ).toString();
                            tv.setText(old1);
                        }
                        break;
                    default:
                        //if we are here it means that there is no symbol, only a number so we add a - in the start
                        old1 = "-" + tv.getText().toString();
                        tv.setText(old1);
                        break;
                    }
            }
        });

     }
}