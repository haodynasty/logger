package com.orhanobut.logger;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kale
 * @date 2016/3/27
 */
public class Settings {

    int methodOffset = 0;

    boolean showMethodLink = true;

    boolean showThreadInfo = false;

    int priority = Log.VERBOSE;

    List<String> filterTagArray = new ArrayList<>();

    public Settings setMethodOffset(int methodOffset) {
        this.methodOffset = methodOffset;
        return this;
    }

    public Settings isShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        return this;
    }

    public Settings isShowMethodLink(boolean showMethodLink) {
        this.showMethodLink = showMethodLink;
        return this;
    }

    /**
     * @param priority one of
     *                 {@link Log#VERBOSE},
     *                 {@link Log#DEBUG},
     *                 {@link Log#INFO},
     *                 {@link Log#WARN},
     *                 {@link Log#ERROR}
     */
    public Settings setLogPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * add filter tag to filter list, this tag will not print to log
     * @param tag
     * @return
     */
    public Settings addFilterTag(String tag){
        if (filterTagArray != null){
            this.filterTagArray.add(tag);
        }
        return this;
    }

    /**
     * clean filter tag list
     */
    public void cleanFilterTag(){
        if (filterTagArray != null){
            this.filterTagArray.clear();
        }
    }
}
