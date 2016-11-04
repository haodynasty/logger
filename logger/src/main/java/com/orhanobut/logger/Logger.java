package com.orhanobut.logger;

import android.support.annotation.NonNull;

import com.orhanobut.logger.util.ObjParser;
import com.orhanobut.logger.util.XmlJsonParser;

import timber.log.Timber;

/**
 * Logger is a wrapper of {@link Timber}
 * But more pretty, simple and powerful
 * 注意：要让设置Settings生效必须使用LogDebugTree作为默认tree才行
 *
 * @author Orhan Obut
 */
public final class Logger {

    private static LogDebugTree printer;

    protected Logger() {
    }

    /**
     * using default DebugTree, same with {@link #plant(Timber.Tree)} and this tree is LogDebugTree
     * <p>notice: only invoke once time
     * @param settings default setting
     */
    public static void plantDefaultDebugTree(Settings settings) {
        printer = new LogDebugTree(settings);
        Timber.plant(printer);
    }

    /**
     * using default DebugTree, same with {@link #plant(Timber.Tree)} and this tree is LogDebugTree
     * <p>notice: only invoke once time
     */
    public static void plantDefaultDebugTree(){
        printer = new LogDebugTree(new Settings()
                .isShowMethodLink(true)
                .isShowThreadInfo(false)
                .setMethodOffset(0)
//                .setLogPriority(BuildConfig.DEBUG ? Log.VERBOSE : Log.ASSERT)
        );
        Timber.plant(printer);
    }

    /**
     * maybe return null, if not use default tree (by invoke {@link #plantDefaultDebugTree()})
     * @return
     * @see #plantDefaultDebugTree()
     * @see #plantDefaultDebugTree(Settings)
     */
    public static Settings getSettings() {
        if (printer == null) return null;
        return printer.getSettings();
    }

    public static Timber.Tree t(String tag) {
        return Timber.tag(tag);
    }

    public static void v(String message, Object... args) {
        message = handleNullMsg(message);
        Timber.v(message, args);
    }

    public static void d(String message, Object... args) {
        message = handleNullMsg(message);
        Timber.d(message, args);
    }

    public static void i(String message, Object... args) {
        message = handleNullMsg(message);
        Timber.i(message, args);
    }

    public static void w(String message, Object... args) {
        message = handleNullMsg(message);
        Timber.w(message, args);
    }

    public static void w(Throwable throwable, String message, Object... args) {
        message = handleNullMsg(message);
        Timber.w(throwable, message, args);
    }

    public static void e(String message, Object... args) {
        message = handleNullMsg(message);
        Timber.e(message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        message = handleNullMsg(message);
        Timber.e(throwable, message, args);
    }

    public static void wtf(String message, Object... args){
        message = handleNullMsg(message);
        Timber.wtf(message, args);
    }

    public static void wtf(Throwable throwable, String message, Object... args) {
        message = handleNullMsg(message);
        Timber.wtf(throwable, message, args);
    }

    /**
     * Formats the json content and print it
     *
     * @param json the json content
     */
    public static void json(String json) {
        Timber.d(XmlJsonParser.json(json));
    }

    /**
     * Formats the json content and print it
     *
     * @param xml the xml content
     */
    public static void xml(String xml) {
        Timber.d(XmlJsonParser.xml(xml));
    }

    /**
     * Formats the json content and print it
     *
     * @param object Bean,Array,Collection,Map,Pojo and so on
     */
    public static void object(Object object) {
        Timber.d(ObjParser.parseObj(object));
    }

    public static void plant(Timber.Tree tree) {
        Timber.plant(tree);
    }

    public static void uprootAll() {
        Timber.uprootAll();
    }

    /**
     * Timber will swallow message if it's null and there's no throwable.
     */
    @NonNull
    private static String handleNullMsg(String message) {
        if (message == null) {
            message = "null";
        }
        return message;
    }

}
