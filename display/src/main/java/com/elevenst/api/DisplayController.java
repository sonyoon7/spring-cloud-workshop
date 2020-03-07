package com.elevenst.api;

import com.elevenst.service.FeignProductRemoteService;
import com.elevenst.service.ProductRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/displays")
public class DisplayController {

    private final ProductRemoteService productRemoteService;
    private  final FeignProductRemoteService remoteService;

    public DisplayController(ProductRemoteService productRemoteService, FeignProductRemoteService remoteService) {
        this.productRemoteService = productRemoteService;
        this.remoteService = remoteService;
    }

    @GetMapping(path = "/{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
        String productInfo = getProductInfo();
        return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productInfo);
    }

    private String getProductInfo() {
        return remoteService.getProductInfo("12345");
//        return productRemoteService.getProductInfo("12345");
    }
}