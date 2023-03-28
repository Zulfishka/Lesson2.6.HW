package com.geekthech.lesson26hw;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText2, editText1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText2 = findViewById(R.id.edit_text2);
        editText1 = findViewById(R.id.edit_text1);
        button = findViewById(R.id.button);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText1.getText().toString().length() >= 1 && editText2.getText().toString().length() >= 1) {
                    button.setBackgroundColor(button.getContext().getResources().getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(button.getContext().getResources().getColor(R.color.grey));
                }
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText1.getText().toString().length() >= 1 || editText2.getText().toString().length() >= 1) {
                    button.setBackgroundColor(button.getContext().getResources().getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(button.getContext().getResources().getColor(R.color.grey));
                }
            }
        });

        TextView textView, vhod, melkiiText;
        textView= findViewById(R.id.textView);
        vhod= findViewById(R.id.vhod);
        melkiiText= findViewById(R.id.melkii_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText2.getText().toString().equals("admin") && editText1.getText().toString().equals("admin")) {
                    editText1.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    vhod.setVisibility(View.GONE);
                    melkiiText.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}