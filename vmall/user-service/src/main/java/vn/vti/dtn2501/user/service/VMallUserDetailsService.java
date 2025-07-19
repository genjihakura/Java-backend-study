package vn.vti.dtn2501.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import vn.vti.dtn2501.user.model.VMallUserDetails;
import vn.vti.dtn2501.user.repository.UserRepository;

@Slf4j
@Transactional(readOnly = true)
public class VMallUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public VMallUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .map(userEntity -> new VMallUserDetails(
            userEntity.getUsername(),
            userEntity.getPassword()
        ))
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
  }
}
