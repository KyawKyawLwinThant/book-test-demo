package com.example.bookstore.controller;


import com.example.bookstore.entities.UserRegister;
import com.example.bookstore.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/user/checkout")
    public String checkoutForm(Model model,@ModelAttribute("myList") List<String> myList){
        System.out.println("MyList :"+ myList);
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



    @ModelAttribute("hobby")
    public List<String> hobbyList(){
        return List.of("Reading","Skinning","Footballing","Swimming");
    }
    @ModelAttribute("gender")
    public List<String> gender(){
        return List.of("Male","Female");
    }

    @ResponseBody
    @PostMapping(value = "/book/ajax",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String processRadioButton(@RequestBody  int value){
        System.out.println("Value: "+ value);
        this.radioValue=value;
       // return "redirect:/user/checkout";
        return "success";
    }


    private int radioValue;


    @ModelAttribute("myList")
    public List<String> listObject(){
        switch (radioValue){
            case 1: return List.of("a", "b");

            case 2: return List.of("c","d");

            case 3: return List.of("d","e");

        }
        return Collections.emptyList();
    }

}
