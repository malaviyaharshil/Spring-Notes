package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("home called");
        return "index";
    }

//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num, int num2, Model model){
//
////        int num1 = Integer.parseInt(req.getParameter("num1"));
////        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num+num2;
//
//       model.addAttribute("result", result);
//
//        return "result";
//    }

//    @RequestMapping("add")
//    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv){
//
////        int num1 = Integer.parseInt(req.getParameter("num1"));
////        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num+num2;
//
//        mv.addObject("result",result);
//        mv.setViewName("result");
//        return mv;
//    }

//    @RequestMapping("addAlien")
//    public ModelAndView add( int aid, String aname, ModelAndView mv){
//
//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);
//
//        mv.addObject("alien",alien);
//        mv.setViewName("result");
//        return mv;
//    }

    @RequestMapping("addAlien")
    public String add(@ModelAttribute Alien alien){

//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);
//
//        mv.addObject("alien",alien);
//        mv.setViewName("result");
        return "result";
    }

    @ModelAttribute("country")
    public String countryName(){
        return "India";
    }
}
