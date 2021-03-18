package com.liuhaidongcoder.mybatis;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Liu Haidong
 * @date 20/12/6
 */
public class Test {
    public static void main(String[] args) {

        String pattern = "abba";
        String str1="北京 杭州 杭州 北京";
        System.out.println(isMatch(pattern,str1));
        String pattern2 = "aabb";
        String str2="北京 杭州 杭州 北京";
        System.out.println(isMatch(pattern2,str2));

        String pattern3 = "baab";
        String str3="北京 杭州 杭州 北京";
        System.out.println(isMatch(pattern3,str3));

    }
    public static boolean isMatch(String pattern,String str){
        if(null ==pattern || null==str){
            return false;
        }

        String[] words = str.split(" ");
        //单词的个数和模式串长度不一致返回false
        if(words.length != pattern.length()){
            return false;
        }
        //模式串去重
        Set<String> patternSets = new HashSet<>();
        List<String> patterList = new ArrayList<>();
        for(char c : pattern.toCharArray()){
            if(!patternSets.contains(String.valueOf(c))){
                patternSets.add(String.valueOf(c));
                patterList.add(String.valueOf(c));
            }
        }
        //目标串去重
        String[] result = str.split(" ");
        Set<String> wordSets = new HashSet<>();
        List<String> wordList = new ArrayList<>();
        for(String s:result){
            if(!wordSets.contains(s)){
                wordSets.add(s);
                wordList.add(s);
            }
        }
        //去重后个数不匹配返回false
        if(patternSets.size() != wordSets.size()){
            return false;
        }
        //模式串和单词映射表
        HashMap<String,String> hashMap = new HashMap<>();
        for(int i=0;i <patterList.size();i++){
            hashMap.put(patterList.get(i),wordList.get(i));
        }
        for(int i=0 ;i < pattern.length();i++){
            if(!hashMap.get(String.valueOf(pattern.charAt(i))).equals(words[i])){
                return false;
            }
        }
        return true;
    }
}
