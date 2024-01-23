package com.FoodDelivery.Delivery.services;


import com.FoodDelivery.Delivery.model.Availaibility;
import com.FoodDelivery.Delivery.model.Staff;
import com.FoodDelivery.Delivery.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityServices {

    @Autowired
    AvailabilityRepository availabilityRepository;
    public boolean delivery(Availaibility availaibility){
        try{
            if(availaibility.getDeliveryDate()==""  && availaibility.getDeliveryDay()==""  &&  availaibility.getDeliveryTime()==""  && availaibility.getEmployeeId()=="")
                return false;
            availabilityRepository.save(availaibility);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Availaibility getEmployeeDelivery(String employeeId){
        if(availabilityRepository.existsById(employeeId)) {
            Optional<Availaibility> employee= availabilityRepository.findById(employeeId);
            if(employee.isPresent())
                return employee.get();
        }
        return null;
    }

//    public List<Availaibility> getAllOrders(){
//        return availabilityRepository.findAll();
//    }
    public boolean orderChange(Availaibility availaibility){
        if(availabilityRepository.existsById(availaibility.getEmployeeId())){
            availabilityRepository.save(availaibility);
            return true;
        }
        return false;
    }
}
