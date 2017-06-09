package com.domain.a.not.tipcalckata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView completeTipTextView;
    TextView completePaymentTextView;
    EditText enteredPaymentEditText;
    EditText customEnteredTipEditText;
    Button button5;
    Button button10;
    Button button15;
    Button button20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        completeTipTextView = (TextView) findViewById(R.id.totalTip);
        completePaymentTextView = (TextView) findViewById(R.id.totalPayment);
        enteredPaymentEditText = (EditText) findViewById(R.id.enteredPayment);
        customEnteredTipEditText = (EditText) findViewById(R.id.customEnteredTip);
        button5 = (Button) findViewById(R.id.button5);
        button10 = (Button) findViewById(R.id.button10);
        button15 = (Button) findViewById(R.id.button15);
        button20 = (Button) findViewById(R.id.button20);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.05);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.1);
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.15);
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(0.2);
            }
        });

        customEnteredTipEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (!customEnteredTipEditText.getText().toString().isEmpty()) {
                        Double enteredCustomTip = Double.valueOf(customEnteredTipEditText.getText().toString());
                        calculateTipAddition(enteredCustomTip);
                        handled = true;
                    }
                }
                return handled;
            }
        });

    }

    void calculateTip(Double tip) {
        Double enteredPayment = Double.valueOf(enteredPaymentEditText.getText().toString());
        Double tipTotal = enteredPayment * tip;
        Double tipTotalRound = Math.floor(tipTotal * 100) / 100;
        Double total = tipTotalRound + enteredPayment;
        completeTipTextView.setText("Tip - $" + tipTotalRound);
        completePaymentTextView.setText("Total - $" + total);
    }

    void calculateTipAddition(Double tip) {
        Double enteredPayment = Double.valueOf(enteredPaymentEditText.getText().toString());
        Double total = tip + enteredPayment;
        completeTipTextView.setText("Tip - $" + tip);
        completePaymentTextView.setText("Total - $" + total);
    }
}
