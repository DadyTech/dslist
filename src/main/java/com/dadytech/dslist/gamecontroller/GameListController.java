package com.dadytech.dslist.gamecontroller;

import com.dadytech.dslist.dto.GameListDto;
import com.dadytech.dslist.entity.GameList;
import com.dadytech.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameList")
public class GameListController {


    public  final GameListService service;

     @Autowired
    public GameListController(GameListService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<GameListDto>> listar(){
         List<GameListDto> gameLists = service.findAll();
         return ResponseEntity.ok(gameLists);
    }
}
