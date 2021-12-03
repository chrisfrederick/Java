package com.example.spring;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DaikichiController {


    @RequestMapping("daikichi")
    public String welcome(){
        return "Welcome!";
    }

    @RequestMapping(value = "daikichi/today", method = RequestMethod.GET)
    public String today(){
        return "Today you will find luck in all your endeavors!";
    }

    @GetMapping("daikichi/tomorrow")
    public String tomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    @GetMapping("daikichi/{travel}/{kyoto}")
    public String travel(@PathVariable("travel") String travel, @PathVariable("kyoto") String kyoto){
        return "Congratulations! You will soon travel to "+kyoto;
    }

    @GetMapping("daikichi/path/{lotto}/{number}")
    public String lotto(@PathVariable("loto") String loto, @PathVariable("number") Integer number){
//        int num = Integer.parseInt(number);
        if(number%2 == 0){
            return "You will takes a grand journey in the near future, but be weary of tempting offers";
        }else if(number%3==0){
            return "You have enjoyed the fruits of your labor but now is a great time to spend with family and friends";
        }else {
            return "Not a valid number";
        }
    }

}
