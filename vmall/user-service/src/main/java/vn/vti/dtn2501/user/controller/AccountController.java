package vn.vti.dtn2501.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.user.entity.UserDto;
import vn.vti.dtn2501.user.entity.UserEntity;
import vn.vti.dtn2501.user.exception.ExceptionEnum;
import vn.vti.dtn2501.user.payload.request.CreateAccountRequest;
import vn.vti.dtn2501.user.service.IAccountService;

@RequestMapping(value = "/api/v1/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {

  private final IAccountService accountService;

  @PostMapping
  public ResponseEntity<Void> createAccount(
      @Valid @RequestBody CreateAccountRequest request
  ) {
    accountService.createAccount(request);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/userclient/{id}")
  public UserDto getUserById(@PathVariable Long id) {
    UserDto user = accountService.getUserById(id);
    if (user == null) {
      throw new VMallException(ExceptionEnum.USER_NO_EXIST);
    }
    return new UserDto(user.getId(), user.getName(), user.getEmail());
  }
}
