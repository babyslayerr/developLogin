package com.example.marineinformation.Auth.service;

import java.util.Locale;

class Solution {

    public static void main(String args[]){


        String str = String.valueOf(10);
        String[] strs =  str.split("");


    }


    public static String solution(String s) {
        return makeLarge(s);

    }

    public static String makeLarge(String str){
        String result = null;
        boolean flag = true;
        String[] arrStr = str.split("");
        for(String str1 : arrStr){
            result += flag?str1.toUpperCase():str1;
            flag = str1.equals(" ") ? true : false;
        }
        return result;
    }
}