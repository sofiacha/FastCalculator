package com.example.sofak.fastcalculator;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class MainActivity extends AppCompatActivity {

    int count, countdot = 0, tvend, tvlength, i;
    String old, old1;
    char aChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.canvas);
        final TextView answer = (TextView) findViewById(R.id.answer);
                 //TODO  Allazw textview me editext*/
                 //TODO Sxolia
        /*EditText numbers = (EditText) findViewById(R.id.edit_numbers);
        *         <EditText
            android:id="@+id/edit_numbers"
            android:layout_width="fill_parent"
            android:layout_height="78dp"
            android:textSize="100px"
            android:inputType="phone"
            android:textAlignment="textEnd"/>  */
       Button back = (Button) findViewById(R.id.backspace);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {

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
                tv.setText("0");
            }
        });
        Button pare = (Button) findViewById(R.id.parenthesis);
        pare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                count = 1;
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length();
                if (aChar == '0' ){
                        if (count%2==1) {
                            tv.setText("(");
                            count++;
                        }
                        else{
                            tv.setText(")");
                            count++;
                        }
                }else
                {
                    for(int ij=0;ij<tvend;ij++){
                        if (tv.getText().charAt(ij)== '(' || tv.getText().charAt(ij)== ')'){
                            count++;
                        }
                    }
                    old = tv.getText().toString();
                    if (count%2==1) {
                        tv.setText(old + "(");
                        count++;
                    }
                    else{
                        tv.setText(old + ")");
                        count++;
                    }
                }
            }
        });
        Button percent = (Button) findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                if(tv.getText().charAt(tv.getText().length()-1)=='%'){
                    tv.setText(old);
                }else{
                    tv.setText(old + "%");
                }
            }
        });
        Button dia = (Button) findViewById(R.id.dia);
        dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                if (tv.getText().length()>0 && tv.getText().charAt(0)!='0' ) {
                    if(tv.getText().charAt(tv.getText().length()-1)=='/') {
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='-'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "/";
                        tv.setText(old);
                    }else{
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
                for(int i=0;i<tv.getText().length();i++) {
                    if(tv.getText().charAt(i)=='.'){
                        countdot++;
                    }
                }
                if(countdot==0){
                    tv.setText(old + ".");
                }
                countdot=0;
            }
        });
        Button epi = (Button) findViewById(R.id.epi);
        epi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                old = tv.getText().toString();
                if (tv.getText().length()>0 && tv.getText().charAt(0)!='0' ) {
                    if(tv.getText().charAt(tv.getText().length()-1)=='*') {
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='/'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "*";
                        tv.setText(old);
                    }else{
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
                if (tv.getText().length()>0 && tv.getText().charAt(0)!='0' ) {
                    if(tv.getText().charAt(tv.getText().length()-1)=='-') {
                        tv.setText(old );
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='+'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='/'){
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
                if (tv.getText().length()>0 && tv.getText().charAt(0)!='0' ) {
                    if(tv.getText().charAt(tv.getText().length()-1)=='+') {
                        tv.setText(old);
                    }else if (tv.getText().charAt(tv.getText().length()-1)=='-'||tv.getText().charAt(tv.getText().length()-1)=='*'||tv.getText().charAt(tv.getText().length()-1)=='/'){
                        old = tv.getText().subSequence(0, tv.getText().length() - 1).toString() + "+";
                        tv.setText(old);
                    }
                    else{
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "8");
                        } else {
                            tv.setText("8");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "8");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "9");
                        } else {
                            tv.setText("9");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "9");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "7");
                        } else {
                            tv.setText("7");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "7");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "6");
                        } else {
                            tv.setText("6");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "6");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "5");
                        } else {
                            tv.setText("5");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "5");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "4");
                        } else {
                            tv.setText("4");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "4");
                    }
                }
            }
        });
        Button tria = (Button) findViewById(R.id.three);
        tria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if (tv.getText().length() != 0) {
                    aChar = tv.getText().charAt(0);
                }
                tvend = tv.getText().length() - 1;
                if (aChar == '0') {
                    if (tv.getText().length() > 1) {
                        old = tv.getText().subSequence(1, tvend).toString();
                        tv.setText(old + "3");
                    } else {
                        tv.setText("3");
                    }
                } else {
                    old = tv.getText().toString();
                    tv.setText(old + "3");
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
                    if (aChar == '0') {
                        if (tv.getText().length() > 1) {
                            old = tv.getText().subSequence(1, tvend).toString();
                            tv.setText(old + "2");
                        } else {
                            tv.setText("2");
                        }
                    } else {
                        old = tv.getText().toString();
                        tv.setText(old + "2");
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
            }
        });
        Button mhden = (Button) findViewById(R.id.zero);
        mhden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                if(tv.getText().length()!=0) {
                    aChar = tv.getText().charAt(0);
                    tvend = tv.getText().length() - 1;
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
                final int i1 = r.nextInt(50) + 1;
                tv.setText(Integer.toString(i1));
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        Dialog d = new Dialog(MainActivity.this);
                        d.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                        d.setContentView(getLayoutInflater().inflate(R.layout.tryfragment, null));
                        TextView titel = (TextView) d.findViewById(R.id.answer);
                        titel.setText("The answer is "+Integer.toString(i1));
                        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                        getWindow().setFormat(PixelFormat.RGBA_8888);
                        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        lp.copyFrom(d.getWindow().getAttributes());
                        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                        d.show();
                        //TODO on click kleine to para8yro
                        d.getWindow().setAttributes(lp);
                    }
                }, 2000);
            }
        });
        Button synplyn = (Button) findViewById(R.id.synplun);
        synplyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewrt) {
                aChar = tv.getText().charAt(0);
                tvend = tv.getText().length();
                tvlength = tv.getText().length();
                while((tv.getText().charAt(tvlength-1)!= '+' && tv.getText().charAt(tvlength-1)!= '-' && tv.getText().charAt(tvlength-1)!= '*'&& tv.getText().charAt(tvlength-1)!= '/'&&tvlength>1)){
                    tvlength--;
                }
                switch (tv.getText().charAt(tvlength-1)) {
                    case '+':
                        if(tvlength-1==tvend-1){
                            old1 = tv.getText().subSequence(0,tvlength-1).toString() + "-" ;
                            tv.setText(old1);
                        }else {
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
                        old1 = "-" + tv.getText().toString();
                        tv.setText(old1);
                        break;
                    }
            }
        });

     }
}