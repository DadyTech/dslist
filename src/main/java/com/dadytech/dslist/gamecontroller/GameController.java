package com.dadytech.dslist.gamecontroller;

import com.dadytech.dslist.dto.GameDto;
import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    public final GameService service;
    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<GameMinDto> >findAll(){
        List<GameMinDto> result = service.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable Long id){
       GameDto game = service.findByid(id);
        return ResponseEntity.ok(game);
    }
}
