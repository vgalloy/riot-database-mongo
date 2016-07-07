package vgalloy.riot.database.mongo.dao.query.mapper;

import org.bson.Document;
import vgalloy.riot.database.mongo.dao.query.model.Position;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public class PositionMapper {

    /**
     * Convert a document into a position.
     *
     * @param document the document
     * @return a position
     */
    public static Position map(Document document) {
        int x = (int) document.get("x");
        int y = (int) document.get("y");
        return new Position(x, y);
    }
}
