package com.FoodDelivery.Delivery.services;

import com.FoodDelivery.Delivery.model.Availaibility;
import com.FoodDelivery.Delivery.model.Staff;
import com.FoodDelivery.Delivery.repository.AvailabilityRepository;
import com.FoodDelivery.Delivery.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;
    public boolean addStaffEmployee(Staff staff){
        try{
            if(!staffRepository.existsById(staff.getId())) {
                if (staff.getId() == "" || staff.getName() == "")
                    return false;
                staffRepository.save(staff);
                return true;
            }
            else
                return false;
        }catch (Exception ex){
            return false;
        }
    }

//    public List<Staff> getAllEmployee(){
//       return staffRepository.findAll();
//    }

    public Staff getEmployee(String id){
        if(staffRepository.existsById(id)) {
            Optional<Staff> employee= staffRepository.findById(id);
            if(employee.isPresent())
                return employee.get();
        }
        return null;
    }
    public boolean deleteEmployee(String id){
        if(staffRepository.existsById(id)) {
            staffRepository.deleteById(id);

            return true;
        }
        return false;
    }

    public boolean updateEmployee(Staff staff){
        if(staffRepository.existsById(staff.getId())) {
            staffRepository.save(staff);
            return true;
        }
        return false;
    }
}


