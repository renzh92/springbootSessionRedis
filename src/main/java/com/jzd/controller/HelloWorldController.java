package com.jzd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	 @RequestMapping("/index/{name}")
     @ResponseBody
     public String index(@PathVariable String name) {
		 if (null == name) {
            name = "boy";
        }

        return "hello world " + name;
    }
	 
	@RequestMapping("/tsession/{age}")
    @ResponseBody
    public String TestSession(HttpServletRequest req, HttpServletResponse resp,@PathVariable String age){
        req.getSession().setAttribute("age", age);
        String a = (String) req.getSession().getAttribute("age");
        String sessionid = req.getSession().getId();
        return "项目一的session="+a+"sessionid="+sessionid;
    }
	
	@RequestMapping("/test")
	@ResponseBody
	public String getTest(HttpServletRequest req) {
		String sessionid = req.getSession().getId();
		return "项目一sessionid="+sessionid+"-----age="+req.getSession().getAttribute("age");
	}
}
