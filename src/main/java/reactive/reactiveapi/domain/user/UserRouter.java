package reactive.reactiveapi.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@RequiredArgsConstructor
public class UserRouter {

    @Bean
    RouterFunction<ServerResponse> userHandlers(UserHandler userHandler) {
        return RouterFunctions
                .route(POST(
                                "/reactive").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::saveUser)
                .andRoute(GET(
                                "/reactive/user/{id}").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::getUser)
                .andRoute(GET(
                                "/reactive/user").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::getAll);
    }

}
