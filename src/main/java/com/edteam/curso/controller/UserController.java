package com.edteam.curso.controller;

import com.edteam.curso.models.User;
import com.edteam.curso.services.UserService;
import com.edteam.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    //Traer todos los user
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll(){
        return userService.getAll();
    }

    //Buscar un user
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable Long id){
        return userService.get(id);
    }

    //Registrar un user
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user){
        //TODO: registrarlo en la bd
        userService.register(user);
    }

    //Actualizar un user
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    User update(User user){
        return userService.update(user);
    }

    //Eliminar un user
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        //TODO: Eliminarlo de la bd
        userService.delete(id);
    }

    //Login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto){
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (user != null){
            String token = jwtUtil.create(String.valueOf(user.getId()),user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }
}
