package belac.blogs;

import belac.blogs.Dtos.GreetingWrapper;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @GET
    public GreetingWrapper hello() {
        var greeting = new GreetingWrapper();
        greeting.text = "Hello";
        return greeting;
    }


}
