package com.FoodDelivery.Delivery.repository;

import com.FoodDelivery.Delivery.model.Availaibility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvailabilityRepository extends MongoRepository<Availaibility ,String>{
}
