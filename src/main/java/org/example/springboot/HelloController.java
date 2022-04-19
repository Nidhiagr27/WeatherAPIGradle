package org.example.springboot;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    String weatherInfo;
    String sportsInfo;
    @GetMapping( "/weather/{city}/{noOfDays}")
    public String index(@PathVariable ("city") String city,@PathVariable ("noOfDays") Integer days){
        try {
            HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json?q="+city+"&days="+ days)
                    .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "06d9388900msha47ce25c3581eedp112b38jsn8a889b0c3280")
                    .asString();
            weatherInfo= response.getBody();

        }
        catch (UnirestException e) {
            e.getMessage();
        }
       return weatherInfo;
    }

    @GetMapping("/sports/{city}")
    public String index2(@PathVariable ("city") String city){
        try {
            HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/sports.json?q="+city)
                    .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "06d9388900msha47ce25c3581eedp112b38jsn8a889b0c3280")
                    .asString();
            sportsInfo= response.getBody();
        } catch (UnirestException e) {
            e.getMessage();
        }
       return sportsInfo;
    }

}
