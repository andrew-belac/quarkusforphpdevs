package belac.blogs.Dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CreateOrderDto {
    public String orderCode;
    public String orderType;

    public CreateOrderDto(){
    }
    public CreateOrderDto(String orderCode, String orderType){
        this.orderCode = orderCode;
        this.orderType = orderType;
    }

}
