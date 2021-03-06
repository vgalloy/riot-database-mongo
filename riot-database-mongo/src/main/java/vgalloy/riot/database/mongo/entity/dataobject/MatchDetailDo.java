package vgalloy.riot.database.mongo.entity.dataobject;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchDetailDo extends DataObject<MatchDetail> {

    /**
     * Constructor. For Jackson deserialization.
     */
    private MatchDetailDo() {

    }

    /**
     * Constructor.
     *
     * @param region the region
     * @param itemId the item id
     * @param item   the item
     */
    public MatchDetailDo(Region region, Long itemId, MatchDetail item) {
        super(region, itemId, item);
    }
}
