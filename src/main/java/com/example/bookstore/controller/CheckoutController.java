package com.example.bookstore.controller;


import com.example.bookstore.entities.UserRegister;
import com.example.bookstore.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/user/checkout")
    public String checkoutForm(Model model){
        model.addAttribute("registerUser",new UserRegister());
        return "register-form";
    }
    @PostMapping("/user/checkout")
    public String processCheckoutForm(UserRegister registerUser, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "register-form";
        }
       // checkoutService.register(registerUser);
        redirectAttributes.addFlashAttribute("success",true);
        System.out.println("Option:"+ registerUser.getOption());
        this.option=registerUser.getOption();
        //redirectAttributes.addFlashAttribute("check-option",registerUser.getOption());
        return "redirect:/book/mytest";
    }
        private int option;

    @GetMapping("/book/mytest")
    public String selectTest(Model model, @ModelAttribute("myMap") Map<Integer,List<String>> myMap){

        List<String> myList=myMap.get(this.option);
        System.out.println(myMap.get(this.option));
        System.out.println(myList);
        model.addAttribute("myList",myList);
        return "test";
    }

    @ModelAttribute("hobby")
    public List<String> hobbyList(){
        return List.of("Reading","Skinning","Footballing","Swimming");
    }
    @ModelAttribute("gender")
    public List<String> gender(){
        return List.of("Male","Female");
    }



    @ModelAttribute("myMap")
    public Map<Integer,List<String>> mappObject(){
        return Map.of(1,List.of("a","b"),2,List.of("c","d"),3,List.of("e","f"));
    }

}
