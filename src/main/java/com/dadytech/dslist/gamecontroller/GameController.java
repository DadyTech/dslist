package com.dadytech.dslist.gamecontroller;

import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
