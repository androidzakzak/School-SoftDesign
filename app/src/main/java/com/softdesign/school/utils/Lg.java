package com.softdesign.school.utils;

import android.util.Log;


/**
 * Зарефакторить код логера в соответствии с данными на лекции рекомендациями, исспользовать подход DRY Don’t repeat yourself (не повторяй себя) -
 * т.е. избегаем повторения уже ранее написанного кода + Javadoc,
 * логер должен исспользовать различные уровни вывода логов (Verbose, debug, info, error, warn, assert ).
 */
public class Lg {

    private static final String PREFIX = "School ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    /**
     * Реализовывает вывод логов
     */
    private static void printLog(int priority, String tag, String text) {
        if (text.length() > LOGCAT_BUFFER_SIZE) {
            String textLog = text;
            while (textLog.length() > LOGCAT_BUFFER_SIZE) {
                String textLogFinal = textLog.substring(0, LOGCAT_BUFFER_SIZE);
                textLog = textLog.substring(LOGCAT_BUFFER_SIZE);
                Log.println(priority, PREFIX + tag, textLogFinal);
            }
            Log.println(priority, PREFIX + tag, textLog);
        } else {
            Log.println(priority, PREFIX + tag, text);
        }
    }

    /**
     * Выводит лог на уровне  вывода verbose
     */
    public static void v(String tag, String text) {
        printLog(Log.VERBOSE, tag, text);
    }

    /**
     * Выводит лог на уровне  вывода warn
     */
    public static void w(String tag, String text) {
        printLog(Log.WARN, tag, text);
    }

    /**
     * Выводит лог на уровне  вывода debug
     */
    public static void d(String tag, String text) {
        printLog(Log.DEBUG, tag, text);
    }

    /**
     * Выводит лог на уровне  вывода assert
     */
    public static void a(String tag, String text) {
        printLog(Log.ASSERT, tag, text);
    }

    /**
     * Выводит лог на уровне  вывода error
     */
    public static void e(String tag, String text) {
        printLog(Log.ERROR, tag, text);
    }

    /**
     * Выводит лог на уровне  вывода info
     */
    public static void i(String tag, String text) {
        printLog(Log.INFO, tag, text);
    }
}

