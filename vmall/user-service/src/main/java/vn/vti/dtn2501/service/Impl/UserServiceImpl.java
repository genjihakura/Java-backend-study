package vn.vti.dtn2501.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.entity.User;
import vn.vti.dtn2501.repository.UserRepository;

import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements vn.vti.dtn2501.service.Impl.IUserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("create User: [{}]", user);

        Optional<User> entity = userRepository.findByUserName(user.getUserName());
        if (entity.isPresent()) {
            throw new RuntimeException();
        }
        return userRepository.save(user);
    }
}
