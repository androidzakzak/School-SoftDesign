package com.softdesign.school.ui.activities;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;
import com.softdesign.school.utils.SetTheme;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButtonBlue;
    Button mButtonGreen;
    Button mButtonRed;
    Toolbar mActionBarToolbar;
    EditText mEditText;
    CheckBox mCheckBox;
    String mString;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetTheme.onActivityCreateSetTheme(this);  // Меняет тему при нажатие на кнопку
        setContentView(R.layout.activity_main);

        Lg.e(this.getLocalClassName(), "onCreate");
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mButtonBlue = (Button) findViewById(R.id.btn_blue);
        mButtonGreen = (Button) findViewById(R.id.btn_green);
        mButtonRed = (Button) findViewById(R.id.btn_red);
        mEditText = (EditText) findViewById(R.id.et_one);
        mCheckBox = (CheckBox) findViewById(R.id.cb_one);
        mTextView = (TextView) findViewById(R.id.tv_hello);
        mButtonBlue.setOnClickListener(this);
        mButtonGreen.setOnClickListener(this);
        mButtonRed.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);
        setupToolbar();
    }

    /**
     * Обработчик нажатий
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_blue:
                SetTheme.changeToTheme(this, SetTheme.THEME_DEFAULT);
                break;
            case R.id.btn_green:
                SetTheme.changeToTheme(this, SetTheme.THEME_GREEN);
                break;
            case R.id.btn_red:
                SetTheme.changeToTheme(this, SetTheme.THEME_RED);
                break;
            case R.id.cb_one:
                mString = mEditText.getText().toString();
                mTextView.setText(mString);
                break;
        }
    }

    /**
     * Инициализирует тулбар
     */
    private void setupToolbar() {
        setSupportActionBar(mActionBarToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Выводит в лог onStart
     */
    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "onStart");
    }

    /**
     * Выводит в лог onResume
     */
    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "onResume");
    }

    /**
     * Выводит в лог onPause
     */
    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "onPause");
    }

    /**
     * Выводит в лог onStop
     */
    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "onStop");
    }

    /**
     * Выводит в лог onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "onDestroy");
    }

    /**
     * Выводит в лог onRestart
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "onRestart");
    }

    /**
     * Сохраняет текст из переменой mString при повороте экрана и  выводит в лог onSaveInstanceState
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceState");
        outState.putString("text", mString);
    }

    /**
     * Востанавливает данные для пременой mString и передает их в mTextView и выводит в лог onRestoreInstanceState
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
        mString = savedInstanceState.getString("text");
        mTextView.setText(mString);
    }
}
