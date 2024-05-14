package dk.kea.projekt5_eksamensprojekt_bilabonnement.service;

import dk.kea.projekt5_eksamensprojekt_bilabonnement.model.CarModel;
import dk.kea.projekt5_eksamensprojekt_bilabonnement.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public double calculateTotalMonthlyPrice() {
        List<CarModel> cars = carRepository.getFullListOfCars();
        double totalPrice = 0;
        for (CarModel car : cars) {
            totalPrice += car.getMonthly_price();
        }
        return totalPrice;
    }

    public double calculateTotalMonthlyPriceForLeasedCars() {
        double totalPrice = 0;
        return totalPrice;
    }
}
