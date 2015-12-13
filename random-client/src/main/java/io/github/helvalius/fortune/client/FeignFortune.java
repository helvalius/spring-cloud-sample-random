package io.github.helvalius.fortune.client;

import io.github.helvalius.fortune.teller.IFortuneService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("fortune")
public interface FeignFortune extends IFortuneService {
}
