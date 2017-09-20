package com.bigsea.sns.web.controller.test;
import com.bigsea.sns.model.test.Demo;
import com.bigsea.sns.service.test.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by zhh on 2017/09/20.
 */
@Controller
@RequestMapping("/demo/")
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("add")
    @ResponseBody
    public String add(Demo demo) {
        demoService.save(demo);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    demoService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Demo demo) {
	    demoService.update(demo);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        Demo demo = demoService.findById(id);
        return demo.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() {
        List<Demo> list = demoService.findAll();
        return list.toString();
    }
}