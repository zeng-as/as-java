package com.as.java.util;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author: as
 * date: 2018/11/1 10:55
 */
public class JpaUtils {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        List list = new ArrayList();
        for (int i=1;i<=12312;i++) {
            list.add(i);
        }
        params.put("okpolicyList", list);

        List okpolicyList = (List) params.get("okpolicyList");
        final int length = 1000;
        int batches = okpolicyList.size()/length;
        for (int i=0; i <= batches; i++) {
            Map<String, Object> tempParams = new HashMap<>();
            int toIndex = i == batches ? okpolicyList.size() : (i + 1)*length;
            List tempList = okpolicyList.subList(i*length, toIndex);
            if (0 == tempList.size()) {
                break;
            }
            tempParams.put("okpolicyList", tempList);

            System.out.println(tempList.size());
        }
    }
}
