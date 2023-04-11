package m7.only.groupworkbot.services.impl;

import m7.only.groupworkbot.entity.user.User;
import m7.only.groupworkbot.repository.UserRepository;
import m7.only.groupworkbot.services.UserService;
import org.springframework.stereotype.Service;


/**
 * Сервисный слой для работы с сущностью {@link User}
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Метод для поиска пользователя по идентификатору телеграм чата
     *
     * @param chatId идентификатор чата
     * @return сущность {@code User} или {@code null} если не найден
     */
    @Override
    public User findUserByChatId(Long chatId) {
        return userRepository.findByChatId(chatId).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(new User());
    }
}
