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
    public String hellowithQueryParam(@RequestParam String name){
        return "Hello " + name + " !";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + " !";
    }

//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
//    public String hellogoodbye(){
//        return "Hello! And... Goodbye!!";
//    }

}
