package Controller;

import Entity.Game;
import Service.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GameController {

    private GameService service;

    @Autowired
    public GameController(GameService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Game>> getAllEntities(){
        List<Game> games = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game){
        Game createdGame = service.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }

    @DeleteMapping
    public ResponseEntity<Game> deleteGame(@PathVariable Long id){
        Game deleteThisGame = service.read(id);
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleteThisGame);
    }



}
