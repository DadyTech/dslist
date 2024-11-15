package com.dadytech.dslist.gamecontroller;

import com.dadytech.dslist.dto.GameListDto;
import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.GameList;
import com.dadytech.dslist.projection.GameMinProjection;
import com.dadytech.dslist.services.GameListService;
import com.dadytech.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameList")
public class GameListController {


    public  final GameListService service;
    public final GameService gameService;

     @Autowired
    public GameListController(GameListService service, GameService gameService) {
        this.service = service;
         this.gameService = gameService;
     }


    @GetMapping
    public ResponseEntity<List<GameListDto>> listar(){
         List<GameListDto> gameLists = service.findAll();
         return ResponseEntity.ok(gameLists);
    }
    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long listId){
         List<GameMinDto> projections = gameService.findByList(listId);
         return ResponseEntity.ok().body(projections);
    }
}
