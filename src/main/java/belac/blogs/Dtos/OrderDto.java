package belac.blogs.Dtos;

import belac.blogs.grpc.Order;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.OffsetDateTime;

@RegisterForReflection
public class OrderDto {

    public Integer id;
    public String orderCode;

    public String orderType;

    public OffsetDateTime orderDate;

    public OrderDto(){}
    public OrderDto(Integer id, String orderCode, String orderType, OffsetDateTime orderDate) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.orderDate = orderDate;
    }
}
