package com.chrisfrederick;

import java.util.Date;
public class AlfredQuotes {
    Date date = new Date();

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // YOUR CODE HERE
        String greeting = String.format("Hello, %s. Lovely to meet you", name);
        return greeting;
    }

    public String guestGreeting(String name, String dayPeriod){
        String greeting = String.format("Good %s, %s. Lovely to see you", dayPeriod, name);
        return greeting;
    }

    public String dateAnnouncement() {
        // YOUR CODE HERE
        return "It is currently "+ date;
    }

    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis")>-1){
            return "She is really of no help, What can I get for you sir?";
        }
        if(conversation.indexOf("Alfred")>-1){
            return "At your service, naturally. How may I help you?";
        }
        return "Right. And with that I shall retire.";
    }

    // NINJA BONUS
    // See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}


