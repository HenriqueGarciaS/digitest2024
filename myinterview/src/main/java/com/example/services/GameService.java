package com.example.services;

import com.example.models.Game;
import com.example.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game findById(Long id){
        Optional<Game> game = gameRepository.findById(id);
        return game.orElse(null);
    }

    public Game CreateGame(Game game){
        return gameRepository.save(game);
    }

    public Game updateGame(Long id, Game game){
        Optional<Game> gameToBeUpdated = gameRepository.findById(id);
        if(gameToBeUpdated.isPresent()) {
            gameToBeUpdated.get().setName(game.getName());
            gameToBeUpdated.get().setGenres(game.getGenres());
            gameToBeUpdated.get().setAvailableSystems(game.getAvailableSystems());
            gameToBeUpdated.get().setPrice(game.getPrice());
            gameToBeUpdated.get().setReleaseDate(game.getReleaseDate());

            return gameRepository.save(gameToBeUpdated.get());
        }
        return null;
    }

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }

}
