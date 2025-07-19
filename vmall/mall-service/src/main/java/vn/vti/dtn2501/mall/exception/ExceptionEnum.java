package vn.vti.dtn2501.mall.exception;

import org.springframework.http.HttpStatus;
import vn.vti.dtn2501.common.api.exeption.VMallExceptionInfo;

public enum ExceptionEnum implements VMallExceptionInfo {
  BAD_REQUEST(
      "BAD_REQUEST",
          "Bad request",
      HttpStatus.BAD_REQUEST
      ),
  CATEGORY_NAME_MUST_NOT_NULL_OR_EMPTY(
      "CATEGORY_NAME_MUST_NOT_NULL_OR_EMPTY",
      "Category name must not be null or empty",
      HttpStatus.BAD_REQUEST
  ),
  PRODUCT_NAME_NOT_FIND(
          "PRODUCT_NAME_NOT_FIND",
          "product name must not be find",
          HttpStatus.BAD_REQUEST
  ),
  PRODUCT_NAME_EXISTS(
          "PRODUCT_NAME_EXISTS",
          "product name must be exists",
          HttpStatus.BAD_REQUEST
  ),
  CATEGORY_NAME_EXIST(
          "CATEGORY_NAME_EXIST",
          "Category name must not be exist",
          HttpStatus.BAD_REQUEST
  ),
  CART_NO_EXISTS(
          "CART_NO_EXISTS",
                  "cart no exists",
          HttpStatus.BAD_REQUEST),
  CART_EXISTS(
          "CART_EXISTS",
          "cart exists",
          HttpStatus.BAD_REQUEST),
  ORDER_USER_EXISTS(
          "ORDER_USER_EXISTS",
          "order user exists",
          HttpStatus.BAD_REQUEST),
  INVALID_CART_ID(
          "INVALID CART ID",
          "invalid cart id",
          HttpStatus.BAD_REQUEST),
  INVENTORY_IS_NOT_ENOUGH(
          "INVENTORY_IS_NOT_ENOUGH",
          "our inventory is not enough",
          HttpStatus.BAD_REQUEST
  ),
  CART_ITEM_IS_EMPTY(
          "CART_ITEM_IS_EMPTY",
          "cart item is empty",
          HttpStatus.BAD_REQUEST)
  ;

  private final String errorCode;
  private final String errorDescription;
  private final HttpStatus httpStatus;

  ExceptionEnum(String errorCode, String errorDescription, HttpStatus httpStatus) {
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
    this.httpStatus = httpStatus;
  }
  @Override
  public String getErrorCode() {
    return this.errorCode;
  }

  @Override
  public String getErrorDescription() {
    return this.errorDescription;
  }

  @Override
  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }
}
