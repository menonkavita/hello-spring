package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloControl {

    //handle request at path http://localhost:8080/hello


//    @ResponseBody
//    @GetMapping("hello")
//    // @GetMapping - Handles request at path /hello
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // --- Works -----
    // lives @ /hello/goodbye
    //handles request at path //http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    // @GetMapping - Handles request at path /goodbye
    public String goodBye(){
        return "Goodbye, Spring!";
    }

    // ----- Doesn't seem to be working - not sure if it is coz of
    //    @RequestMapping get() post() starting line 69       -----
    // lives @ /hello/hello
    // Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello " + name + " !" ;
//    }


    // --- Works -----
    //handle requests of the form http://localhost:8080/hello/hello/LaunchCode
    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + " !" ;
    }


    // --- Works -----
    //handles requests for http://localhost:8080/hello/form
    // lives @ /hello/form
    // Handles request of the form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +                   // submit a request to /hello
                "<label> Enter your names: </label>" + "<br>" +
                "<input type='text' name='name'>" + "<br>" +
                "<input type='text' name='friend'>" + "<br>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    // --- Works -----
    // Handles request of the form /form
    // Handles request of the form /hello?name=LaunchCode
    //handles requests of the form http://localhost:8080/hello?name=LaunchCode
    // Handling request of form using GET & POST
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloGoodbyeWithQueryParam(@RequestParam String name, @RequestParam String friend){
        return "Hello, " + name + "! Hello, " + friend + " ! And... Goodbye!!";
    }

}
