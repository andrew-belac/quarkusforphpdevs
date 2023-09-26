package belac.blogs;

import belac.blogs.Dtos.CreateOrderDto;
import belac.blogs.Dtos.OrderDto;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.annotations.Merge;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

@ApplicationScoped
public class OrderConsumer {

    private final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
    @Inject
    Jsonb jsonb;

    @Channel("orders-processed")
    Emitter<String> emitter;


    @Incoming("orders")
    public void consume(String message){
        var createOrderDto =jsonb.fromJson(message, CreateOrderDto.class);
        logger.info(createOrderDto.orderType);
        emitter.send(jsonb.toJson(new OrderDto(1, createOrderDto.orderCode, createOrderDto.orderType, OffsetDateTime.now())));
    }

    @Incoming("orders-processed")
    @Blocking("order-processed-processor")
    @Merge
    public void consumeProcessedOrder(String message){
        var orderDto =jsonb.fromJson(message, OrderDto.class);
        logger.info(jsonb.toJson(orderDto.orderDate));
    }
}
