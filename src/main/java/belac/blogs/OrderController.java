package belac.blogs;

import belac.blogs.Dtos.CreateOrderDto;
import belac.blogs.Dtos.CreateOrderResponseDto;
import belac.blogs.Dtos.OrderDto;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/orders")
@GraphQLApi
public class OrderController {

    @Query("allOrdersByType")
    @Description("Get all Orders By Type")
    public List<OrderDto> getOrdersByType(String orderType){
        var orders = new ArrayList<OrderDto>();
        orders.add(new OrderDto(1, "1234", "EXPRESS", OffsetDateTime.now()));
        return orders;
    }

    @POST
    public CreateOrderResponseDto createOrder(CreateOrderDto createOrderDto){
        return new CreateOrderResponseDto(UUID.randomUUID().toString());
    }
}
