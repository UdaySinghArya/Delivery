package com.FoodDelivery.Delivery.repository;

import com.FoodDelivery.Delivery.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff,String> {
}
