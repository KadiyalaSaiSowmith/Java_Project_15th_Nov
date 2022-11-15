package com.example1.springjspdemo.controller;
import com.example1.springjspdemo.bean.Car1;
import com.example1.springjspdemo.bean.User;
import com.example1.springjspdemo.service.CarService;
import com.example1.springjspdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Controller

public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
        User user = userService.getUserByUserId(userId);
        /*if (userId.equals("admin") && password.equals("root"))
        {
            model.put("userId",userId);
            return "welcome";

        }
        model.put("errorMsg","please Provide the correct userId and password");
        return "login";*/
        if (user.getPassword().equals(password)) {
            model.put("userId", userId);
            return "redirect:welcome";
        }
        model.put("errorMsg", "Please provide correct userid and password");
        return "login";


    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
        int count = userService.createNewUser(user);
        if (count != 1) {
            model.put("errorMsg", "Some issue occurred with registration");
            return "register";
        }
        model.put("successMsg", "User created successfully!!");
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage() {
        return "welcome";
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public ModelAndView resultPage(@RequestParam String start_time,@RequestParam String end_time,@RequestParam String sort) throws ParseException {
        ModelAndView model1 = new ModelAndView();
        LocalDate start = LocalDate.parse(start_time);
        LocalDate end = LocalDate.parse(end_time);
        List<Car1> user = carService.getCarByCarId(start,end,sort);
        if(user.isEmpty())
        {
             model1.addObject("empty_list",user);
             model1.setViewName("Error1");
             return model1;
        }


        model1.addObject("users",user);
        model1.setViewName("result");
        System.out.println("working");
        return model1;
    }
   /* @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String welcomePag() {
        return "result";
    }*/
   /*@RequestMapping(value = "/result", method = RequestMethod.GET)
   public String bookPage() {
       return "result";
   }
*/

    @RequestMapping(value="/book",method=RequestMethod.POST)
    public ModelAndView bookPage(@RequestParam int car_id,@RequestParam String user_name,@RequestParam String pickup,@RequestParam String drop_off){
        //model.put("rental",rental);
        ModelAndView mode = new ModelAndView();
        List<Car1> books2 =carService.bookCarByCarId(car_id,user_name,pickup,drop_off);
      /*  Car1 c=new Car1();
        books2.add(c);*/
        if(books2.isEmpty())
        {
            mode.addObject("empty_list",books2);
            mode.setViewName("error2");
            return mode;
        }
        mode.addObject("booking",books2);
        mode.setViewName("final");
        return mode;
    }

    /* @RequestMapping(value = "/book", method = RequestMethod.GET)
     public ModelAndView BookingDetails(@RequestParam int userId) {
         ModelAndView model = new ModelAndView("/book");


         model.addObject("user", user);
         return model;
     }*/
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String BookingDetails() {
        return "book";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation() {
        return "reservation";
    }

    @RequestMapping(value="/reservation",method=RequestMethod.POST)
    public ModelAndView bookPage(@RequestParam String reservation_id){

        ModelAndView model3 = new ModelAndView();
        List<Car1> reservation =carService.reservationCheck(reservation_id);
        model3.addObject("reserving",reservation);
        model3.setViewName("reservation");
        return model3;
    }
    @RequestMapping(value="/Error1",method=RequestMethod.GET)

        public String errorMsg() {
        return "Error1";
    }
    @RequestMapping(value="/error2",method=RequestMethod.GET)

    public String errorMsg2() {
        return "error2";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String successPage() {
        return "success";
    }
    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public String returnPage() {
        return "return";
    }

    @RequestMapping(value="/return",method=RequestMethod.POST)
    public ModelAndView returnPage(@RequestParam int return_id){

        ModelAndView model5 = new ModelAndView();
        List<Car1> return_car =carService.returnCar(return_id);
        model5.addObject("returning",return_car);
        model5.setViewName("success");
        return model5;
    }

}