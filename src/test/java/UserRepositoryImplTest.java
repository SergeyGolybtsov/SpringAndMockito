import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRepositoryImplTest {
    private static final User VALID_USER = new User("Сергей");
    private static final User INVALID_USER = new User("Жук");
    private static final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    @DisplayName("Возвращает пользователя из списка по имени")
    void shouldGetUserByName() {
        Assertions.assertEquals(VALID_USER, userRepository.getUserByName(VALID_USER.getName()));
    }

    @Test
    @DisplayName("Возвращает null по имени, которого нет в списке с пользователями")
    void shouldGetNullFromMethodGetUserByName() {
        Assertions.assertNull(userRepository.getUserByName(INVALID_USER.getName()));
    }
}
