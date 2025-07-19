package vn.vti.dtn2501.user.service.impl;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.queue.common.Producer;
import vn.vti.dtn2501.user.client.NotificationClient;
import vn.vti.dtn2501.user.entity.UserDto;
import vn.vti.dtn2501.user.entity.UserEntity;
import vn.vti.dtn2501.user.exception.ExceptionEnum;
import vn.vti.dtn2501.user.payload.reponse.UpdateAccountRequest;
import vn.vti.dtn2501.user.payload.request.CreateAccountRequest;
import vn.vti.dtn2501.user.payload.request.SendNotificationRequest;
import vn.vti.dtn2501.user.repository.UserRepository;
import vn.vti.dtn2501.user.service.IAccountService;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements IAccountService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final NotificationClient notificationClient;
  private final Producer<SendNotificationRequest> producer;

  @Value("${aws.s3.cdn-domain:domain}")
  private String cdnDomain;

  @Override
  @Transactional
  public void createAccount(CreateAccountRequest request) {
    try {
      log.info("(createAccount)Starting to create account with username: [{}]",
          request.getUsername());

      // Create new user with NORMAL_USER role
      var userEntity = new UserEntity();
      userEntity.setUsername(request.getUsername());
      userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
      userEntity.setEmail(request.getEmail());
      userEntity.setPhone(request.getPhone());

      userRepository.save(userEntity);

      log.info(
          "(createAccount)Successfully created account for username: [{}] with NORMAL_USER role",
          request.getUsername());

      SendNotificationRequest sendNotificationRequest = new SendNotificationRequest();
      sendNotificationRequest.setTo(userEntity.getEmail());
      sendNotificationRequest.setContent("Dang ky tai khoan thanh cong!!!");
//      notificationClient.sendNotification(sendNotificationRequest);
      producer.fire(sendNotificationRequest);
      log.info("(createAccount)Send notification to user [{}] done!",
          userEntity.getUsername());
    } catch (Exception e) {
      log.error("(createAccount)Exception when creating account username: [{}] with message: [{}]",
          request.getUsername(),
          e.getMessage(),
          e);
      throw e;
    }
  }

  @Override
  public void updateAccount(UpdateAccountRequest request) {

  }

  @Override
  public UserDto getUserById(Long id) {
    Optional<UserEntity> optional = userRepository.findById(id);
    if(optional.isEmpty()) {
      throw new VMallException(ExceptionEnum.USER_NO_EXIST);
    }
    UserDto userDto = new UserDto();
    userDto.setId(optional.get().getId());
    userDto.setEmail(optional.get().getEmail());
    userDto.setName(optional.get().getUsername());

    return userDto;
  }


}
