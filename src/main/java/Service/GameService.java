package Service;

import Entity.Game;
import Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private String steamApiKey = "BAF80C0AF44DE75CC3818FC963CCF5FD";
    private final String steamApiUrl = "http://api.steampowered.com/ISteamApps/GetAppList/v0002/?key=" + steamApiKey + "&format=json";

    private final GameRepository gameRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public GameService(GameRepository gameRepository, RestTemplate restTemplate) {
        this.gameRepository = gameRepository;
        this.restTemplate = restTemplate;
    }

    public void fetchAndSaveGamesFromSteam() {
        GameResponse response = restTemplate.getForObject(steamApiUrl, GameResponse.class);

        if (response != null && response.getAppList() != null) {
            for (Game steamGame : response.getAppList().getApps()) {
                Game game = new Game();
                game.setAppId(steamGame.getAppId());
                game.setName(steamGame.getName());
                gameRepository.save(game);
            }
        }
    }

    public Game create(Game game){
        //Do I need a create? Maybe not

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
