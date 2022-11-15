package com.example1.springjspdemo.dao.impl;

import com.example1.springjspdemo.bean.Car1;
import com.example1.springjspdemo.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Repository
public class CarDaoImpl extends JdbcDaoSupport implements CarDao {
    List<Integer> token = new ArrayList<>();

    @Autowired
    DataSource datasource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initilizer() {
        setDataSource(datasource);
    }

    @Override
    public List<Car1> getCarByCarId(LocalDate start, LocalDate end,String sort) {

        System.out.println(start.isBefore(end));
        System.out.println(start);
        LocalDate a = start;
        String sql;
        //
        if(sort.equals("asc"))
        {
             sql = "select * from car where Start_Time>=? and End_Time<=? and status=1 order by price";
        }
        if(sort.equals("desc"))
        {
            sql = "select * from car where Start_Time>=? and End_Time<=? and status=1 order by price desc";
        }
        else {
            sql = "select * from car where Start_Time>=? and End_Time<=? and status=1";
        }
        List<Car1> customers = new ArrayList<>();
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql,start,end);
        for (Map<String, Object> map : list) {
            Car1 car = new Car1();
            car.setBrand((String) map.get("Model"));
            car.setPrice((Integer) map.get("Price"));
            car.setType((String) map.get("Type"));
            car.setCar_id((Integer) map.get("car_id"));
            customers.add(car);
        }

        return customers;
    }

    @Override
    public List<Car1> bookCarByCarId(int car_id,String user_name, String pickup,String drop_off) {
        int x = (int) (Math.random()*1000);
        String abc = String.valueOf(x);
        String sql3="update car set token =?,pickup=?,drop_off=?,user=? where car_id=?";
        jdbcTemplate.update(sql3,abc,pickup,drop_off,user_name,car_id);
        String sql2 = "update car set status=0 where car_id=?";
        jdbcTemplate.update(sql2,car_id);
        String sql = "select * from car where car_id=?";

       // String sql3 = "update car set token=?,pickup=?,drop_off=?,user=";
        List<Car1> booking = new ArrayList<>();

        // jdbcTemplate.update(sql3,car_id);
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql,car_id);

        //token.add(x);


       for (Map<String, Object> map : list) {
            Car1 books = new Car1();
            books.setBrand((String) map.get("Model"));
            books.setPrice((Integer) map.get("Price"));
            books.setType((String) map.get("Type"));
            books.setCar_id((Integer) map.get("car_id"));
            books.setPickup((String)map.get("pickup"));
            books.setDrop_off((String)map.get("drop_off"));
            books.setUser_name((String)map.get("user"));
            books.setToken((String)map.get("token"));
            booking.add(books);
        }
        return booking;

    }
    @Override
    public List<Car1> reservationCheck(String reservation_id)
    {
        String resSQL = "select * from car where token=? and status=0";
        List<Map<String, Object>> list2 = getJdbcTemplate().queryForList(resSQL,reservation_id);
        List<Car1> reserving = new ArrayList<>();
        for (Map<String, Object> map : list2) {
            Car1 res = new Car1();
            res.setBrand((String) map.get("Model"));
            res.setPrice((Integer) map.get("Price"));
            res.setType((String) map.get("Type"));
            res.setCar_id((Integer) map.get("car_id"));
            res.setPickup((String)map.get("pickup"));
            res.setDrop_off((String)map.get("drop_off"));
            res.setUser_name((String)map.get("user"));
            res.setToken((String)map.get("token"));
            reserving.add(res);
        }
        return reserving;
    }

    @Override
    public List<Car1> returnCar(int return_id)
    {
        String returnSql = "update car set status=1,user=null where car_id=?";
        jdbcTemplate.update(returnSql,return_id);
        String sql = "select * from car where car_id=?";
        List<Car1> returning = new ArrayList<>();

        // jdbcTemplate.update(sql3,car_id);
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql,return_id);

        //token.add(x);


        for (Map<String, Object> map : list) {
            Car1 books = new Car1();
            books.setBrand((String) map.get("Model"));
            books.setPrice((Integer) map.get("Price"));
            books.setType((String) map.get("Type"));
            books.setCar_id((Integer) map.get("car_id"));
           /// books.setPickup((String)map.get("pickup"));
           // books.setDrop_off((String)map.get("drop_off"));
           // books.setUser_name((String)map.get("user"));
           // books.setToken((String)map.get("token"));
            returning.add(books);
        }
        return returning;


    }
}

