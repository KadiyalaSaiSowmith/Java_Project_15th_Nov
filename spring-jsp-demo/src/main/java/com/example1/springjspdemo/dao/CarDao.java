package com.example1.springjspdemo.dao;

import com.example1.springjspdemo.bean.Car1;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarDao {
    List<Car1> getCarByCarId(LocalDate start, LocalDate end,String sort);
    List<Car1> bookCarByCarId(int car_id,String user_name,String pickup,String drop_off);
    List<Car1> reservationCheck(String reservation_id);

    List<Car1> returnCar(int return_id);
}
