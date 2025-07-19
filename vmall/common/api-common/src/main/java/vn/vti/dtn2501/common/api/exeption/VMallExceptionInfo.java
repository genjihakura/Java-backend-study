package vn.vti.dtn2501.common.api.exeption;

import org.springframework.http.HttpStatus;

public interface VMallExceptionInfo {
  String getErrorCode();

  String getErrorDescription();

  HttpStatus getHttpStatus();
}
