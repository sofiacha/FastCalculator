package com.example.sofak.fastcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int count = 0, countsyn = 0 , tvend;
    String old;
    char aChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.canvas);
        /*EditText numbers = (EditText) findViewById(R.id.edit_numbers);
        *         <EditText
            android:id="@+id/edit_numbers"
            android:layout_width="fill_parent"
            android:layout_height="78dp"
            android:textSize="100px"
            android:inputType="phone"
            android:textAlignment="textEnd"/>  */
        Button clea = (Button) findViewById(R.id.clear);
        clea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                Log.d("Char at index 0",  Character.toString(aChar) );
                tv.setText("0");
            }
        });
        Button pare = (Button) findViewById(R.id.parenthesis);
        pare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                count++;
                aChar = tv.getText().charAt(0);
                //tvend = tv.getText().length() - 1;
                //old = tv.getText().toString();
                if (aChar == '0' ){
                    if (count%2==1) {
                        tv.setText("(");
                    }
                    else{
                        tv.setText(")");
                    }
                }else
                {
                    old = tv.getText().toString();
                    if (count%2==1) {
                        tv.setText(old + "(");
                    }
                    else{
                        tv.setText(old + ")");
                    }
                }
            }
        });

        Button percent = (Button) findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + "%");
            }
        });
        Button dia = (Button) findViewById(R.id.dia);
        dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + "/");
            }
        });
        Button dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + ".");
            }
        });
        Button epi = (Button) findViewById(R.id.epi);
        epi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + "*");
            }
        });
        Button oxtw = (Button) findViewById(R.id.eight);
        oxtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "8");
                    }else
                    {
                        tv.setText("8");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "8");
                }
            }
        });
        Button ennia = (Button) findViewById(R.id.nine);
        ennia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "9");
                    }else
                    {
                        tv.setText("9");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "9");
                }
            }
        });
        Button efta = (Button) findViewById(R.id.seven);
        efta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "7");
                    }else
                    {
                        tv.setText("7");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "7");
                }
            }
        });
        Button exi = (Button) findViewById(R.id.six);
        exi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "6");
                    }else
                    {
                        tv.setText("6");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "6");
                }
            }
        });
        Button pente = (Button) findViewById(R.id.five);
        pente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "5");
                    }else
                    {
                        tv.setText("5");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "5");
                }
            }
        });
        Button tessera = (Button) findViewById(R.id.four);
        tessera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "4");
                    }else
                    {
                        tv.setText("4");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "4");
                }
            }
        });
        Button tria = (Button) findViewById(R.id.three);
        tria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "3");
                    }else
                    {
                        tv.setText("3");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "3");
                }
            }
        });
        Button duo = (Button) findViewById(R.id.two);
        duo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "2");
                    }else
                    {
                        tv.setText("2");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "2");
                }
            }
        });
        Button ena = (Button) findViewById(R.id.one);
        ena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "1");
                    }else
                    {
                        tv.setText("1");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "1");
                }
            }
        });
        Button mhden = (Button) findViewById(R.id.zero);
        mhden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length() - 1;
                if (aChar == '0' ){
                    if (tv.getText().length()>1){
                        old = tv.getText().subSequence(1,tvend).toString();
                        tv.setText(old + "0");
                    }else
                    {
                        tv.setText("0");
                    }
                }else
                {
                    old = tv.getText().toString();
                    tv.setText(old + "0");
                }
            }
        });
        Button ison = (Button) findViewById(R.id.ison);
        ison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                Random r = new Random();
                int i1 = r.nextInt(50) + 1;
                tv.setText(Integer.toString(i1));
                Toast.makeText(getApplicationContext(),"I told you I was fast, not smart :p", Toast.LENGTH_LONG).show();
            }
        });
        Button synplyn = (Button) findViewById(R.id.synplun);
        synplyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length();
                if (aChar != '-' ){
                        old = tv.getText().toString();
                        tv.setText("-" + old);
                }else
                {
                    old = tv.getText().subSequence(1,tvend).toString();
                    tv.setText(old);
                }
                /*countsyn++;
                old = tv.getText().toString();
                if (countsyn%2==1) {

                    tv.setText(old + "-");
                }
                else{
                    tv.setText(old + "-");
                }*/
            }
        });
        Button meion = (Button) findViewById(R.id.meion);
        meion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + "-");
            }
        });
        Button kai = (Button) findViewById(R.id.kai);
        kai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                tv.setText(old + "+");
            }
        });

         // int[] numbers = {R.id.eight, R.id.nine, R.id.seven, R.id.six, R.id.five, R.id.four, R.id.three, R.id.two, R.id.one, R.id.zero};
        //better idea: me to pou patietai ena apo ta koumpia not number 8a apo8hkeuetai se int oti periexei to textview
        /// mhden.setOnClickListener((View.OnClickListener) this);
        //  ena.setOnClickListener((View.OnClickListener) this);


    }

         /*TODO random number
        *  int alreadyPickedNumber=3 //Number to exclude
    int number=random.nextInt(9);
    while(number==alreadyPickedNumber){
         number=random.nextInt(9);
    }
        */

}
