package com.dadytech.dslist.services;

import com.dadytech.dslist.dto.GameDto;
import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    public final GameRepository repository;
     @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = repository.findAll();
       return result.stream().map(x-> new GameMinDto(x)).toList();
    }
    @Transactional(readOnly = true)
    public GameDto findByid(Long id){
         Game game = repository.findById(id).get();
         return new GameDto(game);

    }
}
