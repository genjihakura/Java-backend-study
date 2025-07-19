package vn.vti.dtn2501.common.api.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VMallException extends RuntimeException{
  VMallExceptionInfo exceptionInfo;
}
