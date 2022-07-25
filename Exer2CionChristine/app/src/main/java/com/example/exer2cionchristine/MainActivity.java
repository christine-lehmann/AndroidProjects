package com.example.exer2cionchristine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {


    TextView inputTV;
    TextView outputTV;

    String input = "";
    String formula = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    //Initialize Input
    private void initTextViews()
    {
        inputTV = (TextView)findViewById(R.id.inputTextView);
        outputTV = (TextView)findViewById(R.id.outputTextView);
    }

    private void setInput(String givenValue)
    {
        input = input + givenValue;
        inputTV.setText(input);
    }

    //Equal Function
    public void onEqual(View view)
    {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            result = (double)engine.eval(formula);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            outputTV.setText(String.valueOf(result.doubleValue()));

    }

    //Power Check Function
    private void checkForPowerOf()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = input;
        tempFormula = input;
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    //Change Formula
    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< input.length(); i++)
        {
            if(isNumeric(input.charAt(i)))
                numberRight = numberRight + input.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(input.charAt(i)))
                numberLeft = numberLeft + input.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    //Check if it is number/integer
    private boolean isNumeric(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void onClear(View view)
    {
        inputTV.setText("");
        input = "";
        outputTV.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;

    //Parenthesis
    public void onPara(View view)
    {
        if(leftBracket)
        {
            setInput("(");
            leftBracket = false;
        }
        else
        {
            setInput(")");
            leftBracket = true;
        }
    }


    public void onPower(View view) {
        setInput("^");
    }

    public void onDivide(View view) {
        setInput("/");
    }

    public void onSeven(View view) {
        setInput("7");
    }

    public void onEight(View view) {
        setInput("8");
    }

    public void onNine(View view) {
        setInput("9");
    }

    public void onMultiply(View view) {
        setInput("*");
    }

    public void onFour(View view) {
        setInput("4");
    }

    public void onFive(View view) {
        setInput("5");
    }

    public void onSix(View view) {
        setInput("6");
    }

    public void onSubtract(View view) {
        setInput("-");
    }

    public void onOne(View view) {
        setInput("1");
    }

    public void onTwo(View view) {
        setInput("2");
    }

    public void onThree(View view) {
        setInput("3");
    }

    public void onAdd(View view) {
        setInput("+");
    }

    public void onZero(View view) {
        setInput("0");
    }

    public void onPoint(View view) {
        setInput(".");
    }

}