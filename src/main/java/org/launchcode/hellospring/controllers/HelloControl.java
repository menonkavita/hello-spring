package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    // Handles request of the form /hell?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello " + name + " !";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + " !";
    }


    // Handles request of the form
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +                   // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    // Handling request of form using GET & POST
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloGoodbyeWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "! And... Goodbye!!";
    }

}
