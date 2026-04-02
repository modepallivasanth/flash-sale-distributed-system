package com.vasanth.projects.flashsale.Controller;


import com.vasanth.projects.flashsale.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase/id")
    public String PurchaseProduct(@PathVariable Long id){

       return purchaseService.PurchaseProduct(Long.valueOf(id));

    }


}
