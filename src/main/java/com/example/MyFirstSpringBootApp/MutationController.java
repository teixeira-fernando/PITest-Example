package com.example.MyFirstSpringBootApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutationController {

  @GetMapping("/compareToFifty/{value}")
  public String compareToFifty(@PathVariable int value){
    String message = "Could not determine comparison";
    if(value > 50){
      message = "Greater than 50";
    }
    else{
      message = "Smaller than or equal to 50";
    }
    return message;
  }

  @GetMapping("/increment/{value}")
  public int increment(@PathVariable int value){
    value++;
    return value;
  }
}



