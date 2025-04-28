package com.example.controllers;

import com.example.exceptions.ResourceNotFoundException;
import com.example.models.Game;
import com.example.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findbyId(@PathVariable(name = "id") long id){
        Game game = gameService.findById(id);
        if(game == null)
            throw  new ResourceNotFoundException("Game não encontrado");
        return game;
    }

    @PostMapping()
    public Game createGame(@RequestBody Game game){
        return gameService.CreateGame(game);
    }

    @PutMapping("/{id}")
    public Game updateById(@PathVariable(name = "id") long id, @RequestBody Game game){
        Game gameUpdated = gameService.updateGame(id, game);

        if(gameUpdated == null)
            throw new ResourceNotFoundException("Game não encontrado");

        return gameUpdated;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") long id){
        gameService.deleteGame(id);
    }

}