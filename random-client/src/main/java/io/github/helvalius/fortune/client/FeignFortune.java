package io.github.helvalius.fortune.client;

import io.github.helvalius.fortune.teller.IFortuneService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("randomservice")
public interface FeignFortune extends IFortuneService {
    @RequestMapping(path = "/seed", method = RequestMethod.GET)
    int seed();

    @RequestMapping(path = "/subtractor", method = RequestMethod.POST, consumes = "application/json")
    int subtractor(@RequestParam(value = "minuend") Integer minuend, @RequestParam(value = "subtrahend") Integer subtrahend);

}
