package com.dadytech.dslist.repository;

import com.dadytech.dslist.entity.Game;
import com.dadytech.dslist.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
