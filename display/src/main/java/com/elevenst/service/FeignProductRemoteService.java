package com.elevenst.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product") //서비스 아이디 / url ="http://localhost:8082
public interface FeignProductRemoteService {

    @RequestMapping("products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);

}
