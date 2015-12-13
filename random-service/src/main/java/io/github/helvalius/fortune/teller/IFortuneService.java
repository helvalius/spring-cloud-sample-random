package io.github.helvalius.fortune.teller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public interface IFortuneService {
    @RequestMapping(path = "/seed", method = RequestMethod.GET)
    int seed();

    @RequestMapping(path = "/subtractor", method = RequestMethod.POST)
    int subtractor(@RequestParam(required = false) Integer minuend, @RequestParam(required = false) Integer subtrahend);
}
