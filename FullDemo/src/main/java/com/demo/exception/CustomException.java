package com.demo.exception;

public class CustomException extends Exception {
  private static final long serialVersionUID = 6919903753901205044L ;

  public CustomException() {
      super() ;
  }

  public CustomException(String message, Throwable cause) {
      super(message, cause) ;
  }

  public CustomException(String message) {
      super(message) ;
  }

  public CustomException(Throwable cause) {
      super(cause) ;
  }
}
