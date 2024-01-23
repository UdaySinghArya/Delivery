package com.FoodDelivery.Delivery.controller;


import com.FoodDelivery.Delivery.model.Availaibility;
import com.FoodDelivery.Delivery.services.AvailabilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AvailabilityController {
    @Autowired
    AvailabilityServices availabilityServices;

    @PostMapping("/order")
    public String orderDelivery(@RequestBody  Availaibility availaibility){
     if(availabilityServices.delivery(availaibility))
         return "ordered Delivered";
     return "ordered not Delivered";
    }

    @GetMapping("/get-Employee-allDelivery")
    public Availaibility getEmployeeOrder(@RequestParam String employeeId){
        return availabilityServices.getEmployeeDelivery(employeeId);
    }

//    @GetMapping("/get-all-orders")
//    public List<Availaibility> getAllOrders(){
//        return availabilityServices.getAllOrders();
//    }

    @PutMapping("/orderedChange")
    public String orderChange(@RequestBody Availaibility availaibility){
        if(availabilityServices.orderChange(availaibility))
            return "Order Changed";
        return "order not change";
    }
}
