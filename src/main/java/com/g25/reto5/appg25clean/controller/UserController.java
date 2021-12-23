package com.g25.reto5.appg25clean.controller;


import com.g25.reto5.appg25clean.model.User;
import com.g25.reto5.appg25clean.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanh
 */
@RestController
/**
 * Endpoint /api/user
 */
@RequestMapping("/api/user")
/**
 * Permite realizar cualqueir tipo de peticion sin restriccion
 */
@CrossOrigin("*") //(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, 
                                      // RequestMethod.PUT, RequestMethod.DELETE})
/**
 * clase UserController
 */
public class UserController {
     /**
     * @Autowired instancia la clase UserService
     */
    @Autowired
    private UserService userService;
    /**
      * Metodo que permite mostrar todos los usuarios
      * @return retorna todos los usuarios
      */

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    /**
     * Metodo post para agregar un usuario
     * @param user datos del uusuario 
     * @return retorna el usuario reguistrado
     */
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /** 
     * metodo para eliminar un usuario por id
     * @param id para seleccionar usuario
     * @return  no devuelve nada
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    /**
     * Metodo para autenticar un usuario
     * @param email que va atraves de la url
     * @param password que va atraves de la url
     * @return el usuario autenticado con el email y password
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * Metodo get que permite saber si el email existe
     * @param email que va atraves de la url
     * @return si existe el email con un true o false
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    /**
     * Metodo get que permite saber el cumpleaños de un cliente
     * @param month que va atraves de la url
     * @serialData  que va atraves de la url
     * @return fecha de nacimiento 
     */
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
     /**
    * Fin de la clase UserController
    */ 
}
