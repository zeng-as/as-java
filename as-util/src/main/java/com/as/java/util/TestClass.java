package com.as.java.util;

import java.util.*;

/**
 * @author as
 * @date 2021/12/28
 * @desc
 */
public class TestClass {
    public static String longestDupSubstring(String s) {
        int l = s.length();
        TreeMap<String, List<Integer>> m = new TreeMap<>();

        for (int i=0; i<l; i++) {
            String t = new String(new char[]{s.charAt(i)});
            List<Integer> idx = m.computeIfAbsent(t, k -> new ArrayList<>());
            idx.add(i);
        }

        TreeMap<String, List<Integer>> rs = find(s, m);

        if (rs.size() == 0) {
            return "";
        }
        return rs.lastEntry().getKey();
    }

    public static TreeMap<String, List<Integer>> find(String s, TreeMap<String, List<Integer>> m) {
        TreeMap<String, List<Integer>> n = new TreeMap<>();
        Iterator<Map.Entry<String, List<Integer>>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Integer>> e = iterator.next();
            String key = e.getKey();
            List<Integer> idxList = e.getValue();
            if (idxList.size() <= 1) {
                iterator.remove();
                continue;
            }

            for (int idx : idxList) {
                if (idx + key.length() + 1 > s.length()) {
                    break;
                }
                String tmpKey = s.substring(idx, idx + (key.length() + 1));
                List<Integer> tmpList = n.computeIfAbsent(tmpKey, k -> new ArrayList<>());
                tmpList.add(idx);
            }
        }

        if (n.size() > 0) {
            n = find(s, n);
        }

        return n.size() == 0 ? m : n;
    }

    public static void main(String[] args) {
        String banana = longestDupSubstring("pmyiaxmicpmvqywlkisfzzutlxxjipitwcfxgqqfnxizowkqfmzsvkxryknasyvthozahbmapwqocupxcktmmtddxgatzftamrsvtddjpbnrojcqonmzxmknashplmykdbadiiccdkbyyzifqxvqfwgwihxgnrhqlmqprnjawuzcotutbkgnykuuwtzzzppmoyfmplhpznpnlwwbndekakpsmehzmbcfoyudgwsvehzgsfwqdkihiiwxfskicrbmoevxvpmmymihlkmgnuyohcofzfkehccwxezxypnnvqzrilr");
        System.out.println(banana);
    }
}
