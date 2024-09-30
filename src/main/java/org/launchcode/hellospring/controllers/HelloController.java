package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// Chapter 9 & 10: Spring & Controller Exercises


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String name, String lang){
        String greeting="";

        if(lang.equals("Eng")){
            greeting="Hello! ";
        }
        else if(lang.equals("Fr")){
            greeting="Bonjour ";
        }
        else if(lang.equals("Spa")){
            greeting="Hola ";
        }
        else if(lang.equals("Jap")){
            greeting="Konnichiwa ";
        }
        else if(lang.equals("Ger")){
            greeting="Hallo ";
        }

        // For a BONUS MISSION, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
        return "--------------" + "<br>" +
                "<b>" + greeting + "</b>" +
                "<i>" + " " + name + "</i>" + "<br>" +
                "--------------" ;
    }


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
                "<label> Select Language: " + "<br>" +
                "<select name='language'>" + "<br>" +
                "<option value='Eng'>English</option>" + "<br>" +
                "<option value='Fr'>French</option>" + "<br>" +
                "<option value='Spa'>Spanish</option>" + "<br>" +
                "<option value='Jap'>Japanese</option>" + "<br>" +
                "<option value='Ger'>German</option>" + "<br>" +
                "</select>" +
                "<label>" + "<br>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
