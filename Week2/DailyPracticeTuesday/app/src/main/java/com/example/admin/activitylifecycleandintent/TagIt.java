package com.example.admin.activitylifecycleandintent;

public class TagIt {
    public static String with(Object object){
        return object.getClass().getSimpleName() + "_TAG";
    }
}

