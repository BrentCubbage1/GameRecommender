package Service;

import Entity.Game;

import java.util.List;

public class GameResponse {
    private GameAppList applist;

    public GameAppList getAppList() {
        return applist;
    }

    public void setAppList(GameAppList appList) {
        this.applist = appList;
    }
}

