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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private static final User VALID_USER = new User("Сергей");
    private static final User INVALID_USER = new User("Жук");

    @Mock
    UserRepository userRepositoryMock;
    @InjectMocks
    UserServiceImpl userServiceOut;

    @Test
    @DisplayName("Возвращает true если пользователь с именем есть в списке")
    void shouldReturnTrue() {
        when(userRepositoryMock.getUserByName(VALID_USER.getName())).thenReturn(VALID_USER);
        assertTrue(userServiceOut.checkUserExist(VALID_USER));
        verify(userRepositoryMock, times(1)).getUserByName(VALID_USER.getName());
    }

    @Test
    @DisplayName("Возвращает false если пользователя с именем нет в списке")
    void shouldReturnFalse() {
        when(userRepositoryMock.getUserByName(INVALID_USER.getName())).thenReturn(null);
        assertFalse(userServiceOut.checkUserExist(INVALID_USER));
        verify(userRepositoryMock, times(1)).getUserByName(INVALID_USER.getName());
    }
}
