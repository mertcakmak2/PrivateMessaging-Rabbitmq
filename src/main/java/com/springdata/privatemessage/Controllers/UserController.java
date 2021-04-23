package com.springdata.privatemessage.Controllers;

import com.springdata.privatemessage.Dtos.UserDtos.LoginDto;
import com.springdata.privatemessage.Entities.User;
import com.springdata.privatemessage.Services.User.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping(value = "")
    public List<User> getUsers(){
        System.out.println("getusers");
        return userService.getUsers();
    }

    @PostMapping(value = "")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(userService.login(loginDto));
    }


    //EXCEPTION HANDLER
    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity excHandler(RuntimeException e, HttpServletRequest httpServletRequest) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND   ).body("Yanlış e-mail yada şifre");
    }

}
