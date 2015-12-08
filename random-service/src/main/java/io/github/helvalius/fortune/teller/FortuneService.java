package io.github.helvalius.fortune.teller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FortuneService {

    @RequestMapping(path = "/seed", method= RequestMethod.GET)
    public int seed(){
        return new Random().nextInt();
    }

    @RequestMapping(path = "/subtractor", method=RequestMethod.POST)
    public int subtractor(@RequestParam(required = false) Integer minuend, @RequestParam(required = false) Integer subtrahend){
        int a = minuend != null ? minuend : new Random().nextInt();
        int b = subtrahend != null ? subtrahend : new Random().nextInt();
        return a-b;
    }
}
