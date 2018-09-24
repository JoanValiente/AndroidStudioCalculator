package com.example.joanv.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity {

    private String num = "";
    private String lastNum = "";
    private String currAction = "";
    private String lastAction = "";
    private String result = "";
    private TextView numView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

         numView = findViewById(R.id.currNum);
         numView.setText(num);
    }

    public void onClickDigit(View view) {
        Button b = (Button)view;
        num += b.getText().toString().charAt(0);
        numView.setText(num);
    }

    public void onClickOperation(View view) {
        if (numView.getText().toString() == "")
            return;
        Button b = (Button)view;
        currAction = b.getText().toString();
        lastNum = numView.getText().toString();
        numView.setText("");
        num = "";
    }

    public void onClickEqual(View view) {
        if (numView.getText().toString() == "")
            return;
        result = String.valueOf(operate(lastNum, numView.getText().toString(), currAction));
        numView.setText(result);
    }

    public void onClickDot(View view) {
        num += ".";
        numView.setText(num);
    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "*": return Double.valueOf(a) * Double.valueOf(b);
            case "÷": try{
                return Double.valueOf(a) / Double.valueOf(b);
            }catch (Exception e){
            }
            default: return -1;
        }
    }

    public void onClickClear(View view) {
        numView.setText("");
        currAction = "";
        num = "";
    }
}
