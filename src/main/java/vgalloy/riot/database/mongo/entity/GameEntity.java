package vgalloy.riot.database.mongo.entity;

import org.mongojack.Id;

import vgalloy.riot.api.rest.request.game.dto.GameDto;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class GameEntity implements Identifiable, Cloneable {

    private final GameDto gameDto;

    /**
     * Constructor.
     *
     * @param gameDto the game dto
     */
    public GameEntity(GameDto gameDto) {
        this.gameDto = gameDto;
    }

    @Id
    @Override
    public String getId() {
        return String.valueOf(gameDto.getGameId());
    }

    @Override
    public void setId(String id) {
        gameDto.setGameId(Long.valueOf(id));
    }

    public GameDto getGameDto() {
        return gameDto;
    }
}
