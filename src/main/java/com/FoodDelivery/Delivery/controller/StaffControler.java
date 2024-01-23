package com.FoodDelivery.Delivery.controller;


import com.FoodDelivery.Delivery.model.Staff;
import com.FoodDelivery.Delivery.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StaffControler {

    @Autowired
    StaffService staffService;

    @PostMapping("/add-Staff-Employee")
    public String addEmployee(@RequestBody  Staff staff){
        if(staffService.addStaffEmployee(staff))
                return "A new member added";
        return "new member not added or it already exist";
    }

//    @GetMapping("/get-All-Employee")
//    public List<Staff> getAllEmployee(){
//        return staffService.getAllEmployee();
//    }

    @GetMapping("/get-Employee")
    public Staff getEmployee(@RequestParam String id){
        return staffService.getEmployee(id);
    }

    @DeleteMapping("/delete-Employee")
    public String deleteEmployee(@RequestParam String id){
            if(staffService.deleteEmployee(id))
                return "delete successful";
            return "delete Unsuccessful";
    }

    @PutMapping("/update-Employee")
    public String updateEmployee(@RequestBody  Staff staff){
       if(staffService.updateEmployee(staff))
           return "Updated successful";
       return "updated Unsuccessful";
    }

}
