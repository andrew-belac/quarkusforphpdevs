package belac.blogs.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import java.util.Random;

@GrpcService
public class OrderService implements Order {
    @Override
    public Uni<CreateOrderResponse> createOrder(CreateOrderRequest request) {
        return Uni.createFrom().item(() ->
                CreateOrderResponse.newBuilder()
                        .setId(randomOrderId()).build());
    }


    private Integer randomOrderId() {
       var random = new Random();
       return random.nextInt();
    }

}
