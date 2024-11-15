package com.dadytech.dslist.services;

import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    public final GameRepository repository;
     @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameMinDto> findAll(){
        List<Game> result = repository.findAll();
       return result.stream().map(x-> new GameMinDto(x)).toList();
    }
}
