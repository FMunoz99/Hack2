package com.example.demo.user.application;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccion;
import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccionService;
import com.example.demo.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ListaDeReproduccionService listaDeReproduccionService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> crear(@RequestBody ListaDeReproduccion listaDeReproduccion, @PathVariable int id){
        userService.crear(id,listaDeReproduccion);
        return  ResponseEntity.accepted().build();
    }

    @GetMapping("/{user_id}/playlists")
    public ResponseEntity<Object> getListas(@PathVariable int user_id) {
        return ResponseEntity.ok(userService.getlista(user_id));
    }

}
