package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloControl {

//    @ResponseBody
//    @GetMapping("hello")
//    // @GetMapping - Handles request at path /hello
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @ResponseBody
    @GetMapping("goodbye")
    // @GetMapping - Handles request at path /goodbye
    public String goodBye(){
        return "Goodbye, Spring!";
    }


    // Handles request of the form /hello?name=LaunchCode   --- Not working ---
    // Handling the form request using GET & POST
    // Remove @ResponseBody when using Thymeleaf template to let browser know not to send response back
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + " !";

        // variable "theGreeting" matches the string variable of this function
        // while "greeting" matches the variable in the hello.html file
        model.addAttribute("greeting", theGreeting);

        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    // Remove @ResponseBody when using Thymeleaf template to let browser know not to send reponse back
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
       model.addAttribute("greeting", "Hello using Path Variable, " + name + " !");

       // returns name of the html file that will handle
       // if there was a subfolder in "templates" directory, then the return statement
       // would say - return "subfolder/fileName";
        return "hello";
    }


    // Handles request of the form localhost:8080/form
    // Using resources/templates/form.html
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    // Handles requests @ /hello-names
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> theNames = new ArrayList<>();
        theNames.add("Java");
        theNames.add("LaunchCode");
        theNames.add("JavaScript");

        List<String> coffeeList = new ArrayList<>();
        coffeeList.add("French Roast");
        coffeeList.add("Espresso");
        coffeeList.add("Kopi Luwak");
        coffeeList.add("Instant");


        model.addAttribute("names", theNames);
        model.addAttribute("coffeeOptions", coffeeList);

        return "hello-list";            // returns name of the html file that will handle
    }

}
