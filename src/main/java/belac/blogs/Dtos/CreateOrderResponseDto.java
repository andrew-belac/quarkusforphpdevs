package belac.blogs.Dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CreateOrderResponseDto {
    public String orderId;

    public CreateOrderResponseDto(String orderId) {
        this.orderId = orderId;
    }
}
