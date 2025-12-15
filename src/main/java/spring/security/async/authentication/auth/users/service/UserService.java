package spring.security.async.authentication.auth.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.security.async.authentication.auth.users.domain.entity.Account;
import spring.security.async.authentication.auth.users.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(Account account){
        userRepository.save(account);
    }
}
