package com.softdesign.school.ui.activities;


import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButtonBlue;
    Button mButtonGreen;
    Button mButtonRed;
    Toolbar mActionBarToolbar;
    EditText mEditText;
    CheckBox mCheckBox;
    String mString;
    TextView mTextView;
    public static final String TOOLBAR_COLOR_KEY = "toolbar_color";
    public static final String STATUSBAR_COLOR_KEY = "statusbar_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                setupColor(R.color.colorPrimary, R.color.colorPrimaryDark);
                break;
            case R.id.btn_green:
                setupColor(R.color.green, R.color.green_dark);
                break;
            case R.id.btn_red:
                setupColor(R.color.red, R.color.red_dark);
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
     * Сохраняет текст из переменой mString при повороте экрана и  выводит в лог onSaveInstanceState и сохраняет цвет тулбара и статус бара
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceState");
        outState.putString("text", mString);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            outState.putInt(STATUSBAR_COLOR_KEY, getWindow().getStatusBarColor());
        }
        outState.putInt(TOOLBAR_COLOR_KEY, ((ColorDrawable) mActionBarToolbar.getBackground()).getColor());
    }

    /**
     * Востанавливает данные для пременой mString и передает их в mTextView и выводит в лог onRestoreInstanceState и востанавливает цвет у тулбара и статус бара
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
        mString = savedInstanceState.getString("text");
        mTextView.setText(mString);
        setupColor(savedInstanceState.getInt(TOOLBAR_COLOR_KEY), savedInstanceState.getInt(STATUSBAR_COLOR_KEY));
    }

    /**
     * Устанавливает цвет тулбара и статус бара
     */
    private void setupColor(int color, int color2) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionBarToolbar.setBackgroundColor(this.getResources().getColor(color));
            getWindow().setStatusBarColor(this.getResources().getColor(color2));
        }
    }
}
