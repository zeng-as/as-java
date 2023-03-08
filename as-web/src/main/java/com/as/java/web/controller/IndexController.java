package com.as.java.web.controller;

import com.as.java.util.EhcacheUtils;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author as
 * @since 2018/11/27 10:02
 */
@Controller
@EnableScheduling
public class IndexController {

//    @Scheduled(initialDelay = 500, fixedRate = 10000)
    public void refreshGgUserCache() {
        System.out.println("10秒一次");
    }

    @GetMapping("toIndex")
    public String toIndex() {
        System.out.println("???");
        System.out.println(IndexController.class.getClassLoader());
        return "index";
    }

    @GetMapping("toIndex2")
    public void homePage(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.sendRedirect(request.getContextPath() + "/toIndex");
    }

    @PostMapping("updateCache")
    @ResponseBody
    public void updateCache() {
        Object value = EhcacheUtils.get("testCache");
        Integer updateValue = Optional.ofNullable(value).map(Object::toString).
                map(Integer::parseInt).orElse(0);
        EhcacheUtils.put("testCache", ++updateValue);
    }

    @PostMapping("getCache")
    @ResponseBody
    public String getCache() {
        return Optional.ofNullable(EhcacheUtils.get("testCache")).map(Object::toString).orElse("");
    }
}
