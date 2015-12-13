package io.github.helvalius.fortune.teller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FortuneService implements IFortuneService {

    @Override
    @HystrixCommand(fallbackMethod = "fixedNumber")
    @RequestMapping(path = "/seed", method = RequestMethod.GET)
    public int seed(){
        return new Random().nextInt();
    }

    @Override
    @HystrixCommand(fallbackMethod = "fixedSubstraction")
    @RequestMapping(path = "/subtractor", method=RequestMethod.POST)
    public int subtractor(@RequestParam(required = false) Integer minuend, @RequestParam(required = false) Integer subtrahend){
        int a = minuend != null ? minuend : new Random().nextInt();
        int b = subtrahend != null ? subtrahend : new Random().nextInt();
        return a-b;
    }

    public int fixedNumber(){
        return 42;
    }

    public int fixedSubstraction(){
        return 11;
    }




}
