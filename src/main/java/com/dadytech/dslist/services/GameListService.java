package com.dadytech.dslist.services;

import com.dadytech.dslist.dto.GameDto;
import com.dadytech.dslist.dto.GameListDto;
import com.dadytech.dslist.dto.GameMinDto;
import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.entity.GameList;
import com.dadytech.dslist.repository.GameListRepository;
import com.dadytech.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    public final GameListRepository repository;
     @Autowired
    public GameListService(GameListRepository repository) {
        this.repository = repository;
    }
    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = repository.findAll();
       return result.stream().map(x-> new GameListDto(x)).toList();
    }

}
