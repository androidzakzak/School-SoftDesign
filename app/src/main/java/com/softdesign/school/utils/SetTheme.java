package com.softdesign.school.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.WindowManager;

import com.softdesign.school.R;

public class SetTheme {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_RED = 2;

    /**
     * Устанавливает тему для активити, и перезапускает активити.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /**
     * Выбирает тему для активити
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.colorPrimaryDark));

                }
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.theme_green);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.green_dark));

                }
                break;
            case THEME_RED:
                activity.setTheme(R.style.theme_red);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.red_dark));

                }
                break;
        }
    }
}
