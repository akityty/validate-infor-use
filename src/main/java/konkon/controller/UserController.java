package konkon.controller;

import konkon.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
  @GetMapping("/index")
  public ModelAndView showIndexForm(){
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("user", new User());
    return modelAndView;
  }
  @PostMapping("/validateUser")
  public ModelAndView validateUser(@Validated @ModelAttribute User user, BindingResult result){
    if(result.hasFieldErrors()){
      return new ModelAndView("index");
    }else{
      return new ModelAndView("result");
    }
  }
}
