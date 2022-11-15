package com.example1.springjspdemo.service;

import com.example1.springjspdemo.bean.Car1;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface CarService {
// List<Car> getCarByCarId(LocalDate Start_Time, LocalDate End_Time);
List<Car1> getCarByCarId(LocalDate start, LocalDate end,String sort);

List<Car1> bookCarByCarId(int car_id,String user_name,String pickup,String drop_off);
List<Car1> reservationCheck(String reservation_id);

List<Car1> returnCar(int return_id);

}
