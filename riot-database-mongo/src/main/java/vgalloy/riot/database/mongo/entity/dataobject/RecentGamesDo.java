package vgalloy.riot.database.mongo.entity.dataobject;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RecentGamesDo extends DataObject<RecentGamesDto> {
    /**
     * Constructor. For Jackson deserialization.
     */
    private RecentGamesDo() {

    }
    /**
     * Constructor.
     *
     * @param region the region
     * @param itemId the item id
     * @param item   the item
     */
    public RecentGamesDo(Region region, Long itemId, RecentGamesDto item) {
        super(region, itemId, item);
    }
}
