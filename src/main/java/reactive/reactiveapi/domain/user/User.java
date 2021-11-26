package reactive.reactiveapi.domain.user;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
public class User {

    @Id
    private UUID id;

    private String name;
    private String age;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(User user) {
        this();
        this.name = user.getName();
        this.age = user.getAge();
    }

}
