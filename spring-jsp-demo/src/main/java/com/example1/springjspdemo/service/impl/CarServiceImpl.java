package com.example1.springjspdemo.service.impl;
import com.example1.springjspdemo.bean.Car1;
import com.example1.springjspdemo.dao.CarDao;
import com.example1.springjspdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
@Component
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;


   /* @Override
    public List<Car> getTheCars(){
    List<Car> arr = carDao.getTheListOfCars(Start_Time,End_Time,Model);
    return arr;*/


    @Override
    public List<Car1> getCarByCarId(LocalDate start, LocalDate end,String sort) {
        return carDao.getCarByCarId(start,end,sort);

        /*List<Car1> car = carDao.getCarByCarId();
            return car;*/
        }

    @Override
    public List<Car1> bookCarByCarId(int car_id,String user_name, String pickup,String drop_off) {
        return carDao.bookCarByCarId(car_id,user_name,pickup,drop_off);
    }
    public List<Car1> reservationCheck(String reservation_id){
        return carDao.reservationCheck(reservation_id);
    }

    public List<Car1> returnCar(int return_id){
        return carDao.returnCar(return_id);
    }

}

