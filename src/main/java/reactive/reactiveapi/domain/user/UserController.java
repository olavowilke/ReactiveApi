package reactive.reactiveapi.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

//@RestController
@RequiredArgsConstructor
//@RequestMapping("/reactive")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/{id}")
    public Mono<User> get(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @GetMapping("/user")
    public Flux<User> getAll() {
        return userService.findAll();
    }

}
