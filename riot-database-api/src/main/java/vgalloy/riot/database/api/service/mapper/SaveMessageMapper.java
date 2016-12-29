package vgalloy.riot.database.api.service.mapper;

import vgalloy.javaoverrabbitmq.api.marshaller.RabbitMessageMarshaller;
import vgalloy.riot.database.api.service.message.SaveParameterMessage;
import vgalloy.riot.database.api.service.util.GsonMarshaller;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class SaveMessageMapper {

    private static final RabbitMessageMarshaller rabbitMessageMarshaller = GsonMarshaller.INSTANCE;

    /**
     * Constructor.
     * To prevent instantiation
     */
    private SaveMessageMapper() {
        throw new AssertionError();
    }

    public static <DTO> byte[] map(DTO dto) {
        new SaveParameterMessage(rabbitMessageMarshaller.serialize(dto);
    }
}
