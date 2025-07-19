package vn.vti.dtn2501.user.service;

import vn.vti.dtn2501.user.entity.UserDto;
import vn.vti.dtn2501.user.payload.reponse.UpdateAccountRequest;
import vn.vti.dtn2501.user.payload.request.CreateAccountRequest;

public interface IAccountService {

  void createAccount(CreateAccountRequest request);
  void updateAccount(UpdateAccountRequest request);
  UserDto getUserById(Long id);
}
