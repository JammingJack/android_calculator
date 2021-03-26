package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    int valOne=0, valTwo=0;
    String operation;
    Boolean isOperandOne = true;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (EditText)findViewById(R.id.textDisplay);
    }

    public void affiche(){
        if(isOperandOne){
            result.setText(""+valOne);
        }
        else{
            result.setText(""+valOne + " " + operation + " " + valTwo);
        }

    }
    public void setOperand(View view){
        Button btn = (Button)view;
        /*
        if (view.getId()==R.id.buttonPlus){
            operation="+";
            result.setText(result.getText() + " " +operation+ " 0");
        }
        if (view.getId()==R.id.buttonMinus){
            operation="-";
            result.setText(result.getText() + " " +operation+ " 0");
        }
        if (view.getId()==R.id.buttonProduct){
            operation="*";
            result.setText(result.getText() + " " +operation+ " 0");
        }
        if (view.getId()==R.id.buttonDivision){
            operation="/";
            result.setText(result.getText() + " " +operation+ " 0");
        }
        isOperandOne = false;
         */
        result.setText(String.valueOf(result.getText())+btn.getText());
    }
    public void ajouterNbr(View view){

        Button btn = (Button) view;
        /*
        Button btn = (Button) view;
        if(isOperandOne){
            valOne = valOne*10 + Integer.parseInt(String.valueOf(btn.getText()));
        }
        else{
            valTwo = valTwo*10 + Integer.parseInt(String.valueOf(btn.getText()));
        }
            affiche();

         */
        result.setText(String.valueOf(result.getText())+btn.getText());
    }
    public void calcul(View view){
        if(operation.equals("+")){
            valOne=(valOne+valTwo);
            valTwo =0;
            result.setText(""+valOne);
        }
        if(operation.equals("-")){
            valOne=(valOne-valTwo);
            valTwo =0;
            result.setText(""+valOne);
        }
        if(operation.equals("*")){
            valOne=(valOne*valTwo);
            valTwo =0;
            result.setText(""+valOne);
        }
        if(operation.equals("/")){
            valOne=(valOne/valTwo);
            valTwo =0;
            result.setText(""+valOne);
        }
    }
    public void clear(View view){
        result.setText("");
        valOne=0;
        valTwo=0;
        isOperandOne=true;
    }

    public void calcul3(View view){
        int value = EvaluateString.evaluate(String.valueOf(result.getText()));
        result.setText(String.valueOf(value));
    }
}