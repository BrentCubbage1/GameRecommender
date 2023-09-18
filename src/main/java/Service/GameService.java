package Service;

import Entity.Game;
import Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;


    public Game create(Game game){
        Game newGame = gameRepository.save(game);
        return newGame;
    }

    public Game read(Long id){

        Optional<Game> maybeGame = gameRepository.findById(id);
        if (maybeGame.isPresent()) {
            Game readGame = maybeGame.get();
            return readGame;
        }
        return null;
    }

    public Game update(Long id){
        //do I need an update. Lets think about this one.
        return null;
    }

    public Game delete(Long id){
        Game game = read(id);
        gameRepository.delete(game);
        return game;
    }

    public List<Game> readAll() {
        List<Game> gameList = new ArrayList<>();
        gameRepository.findAll().forEach(gameList::add);
        return gameList;
    }
}
