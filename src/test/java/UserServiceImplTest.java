import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.servise.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private static final User VALID_USER = new User("Сергей");
    private static final User INVALID_USER = new User("Жук");
    private static final List<User> user = List.of(VALID_USER, new User("Андрей"));

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("Возвращает true если пользователь с именем есть в списке")
    void shouldReturnTrue() {
        when(userRepository.getAllUser()).thenReturn(user);
        Assertions.assertEquals(user, userRepository.getAllUser());
        Assertions.assertTrue(userService.checkUserExist(VALID_USER));
    }

    @Test
    @DisplayName("Возвращает false если пользователя с именем нет в списке")
    void shouldReturnFalse() {
        when(userRepository.getAllUser()).thenReturn(user);
        Assertions.assertEquals(user, userRepository.getAllUser());
        Assertions.assertFalse(userService.checkUserExist(INVALID_USER));
    }
}
