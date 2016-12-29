package vgalloy.riot.database.api.service.impl;

import com.rabbitmq.client.ConnectionFactory;
import vgalloy.javaoverrabbitmq.api.Factory;
import vgalloy.javaoverrabbitmq.api.marshaller.RabbitMessageMarshaller;
import vgalloy.javaoverrabbitmq.api.queue.ConsumerQueueDefinition;
import vgalloy.javaoverrabbitmq.api.queue.FunctionQueueDefinition;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.api.entity.Entity;
import vgalloy.riot.database.api.service.MatchDetailService;
import vgalloy.riot.database.api.service.message.GetParameterMessage;
import vgalloy.riot.database.api.service.message.ResponseMessage;
import vgalloy.riot.database.api.service.message.SaveParameterMessage;
import vgalloy.riot.database.api.service.util.GsonMarshaller;
import vgalloy.riot.database.api.service.util.Utils;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public class MatchDetailServiceImpl implements MatchDetailService {

    private final RabbitMessageMarshaller rabbitMessageMarshaller = GsonMarshaller.INSTANCE;
    private final Consumer<SaveParameterMessage> saveConsumer;
    private final Function<GetParameterMessage, ResponseMessage> getFunction;

    public MatchDetailServiceImpl() {
        ConnectionFactory connectionFactory = Utils.getConnectionFactory();
        ConsumerQueueDefinition<SaveParameterMessage> consumerQueueDefinition = Factory.createQueue("MatchDetailSave", SaveParameterMessage.class);
        saveConsumer = Factory.createClient(connectionFactory, consumerQueueDefinition);

        FunctionQueueDefinition<GetParameterMessage, ResponseMessage> functionQueueDefinition = Factory.createQueue("MatchDetailGet", GetParameterMessage.class, ResponseMessage.class);
        getFunction = Factory.createClient(connectionFactory, functionQueueDefinition);
    }

    @Override
    public void save(Region region, Long id, MatchDetail matchDetail) {
        SaveParameterMessage saveParameterMessage = new SaveParameterMessage(region, id, rabbitMessageMarshaller.serialize(matchDetail));
        saveConsumer.accept(saveParameterMessage);
    }

    @Override
    public Entity<MatchDetail> get(Region region, Long itemId) {
        GetParameterMessage getParameterMessage = new GetParameterMessage(region, itemId);
        getFunction.apply(getParameterMessage);
        return null;
    }

    @Override
    public Entity<MatchDetail> getRandom(Region region) {
        return null;
    }
}
