import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.servise.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private static final User VALID_USER = new User("Maksim");
    private static final User INVALID_USER = new User("Maks");

    private static final List<User> users = List.of(
            VALID_USER,
            new User("Miksam"),
            new User("Maskim")
    );

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("Возвращает true если пользователь с именем есть в списке")
    void shouldReturnTrueIfUserExists() {
        when(userRepository.getAllUser())
                .thenReturn(users);
        assertTrue(userService.checkUserExist(VALID_USER));
    }

    @Test
    @DisplayName("Возвращает false если пользователя с именем нет в списке")
    void shouldReturnFalseIfUserNotExists() {
        when(userRepository.getAllUser())
                .thenReturn(users);
        assertFalse(userService.checkUserExist(INVALID_USER));
    }
}
