package com.cypcode.controller_advice_microservice.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import com.cypcode.controller_advice_microservice.domain.ApiError;
import com.cypcode.controller_advice_microservice.exception.CustomException;
import com.cypcode.controller_advice_microservice.exception.HomeException;
import com.cypcode.controller_advice_microservice.exception.SubscribeException;
import java.util.*;

@ControllerAdvice
public class ControllerAdvicer {

	@ExceptionHandler({HomeException.class, SubscribeException.class, CustomException.class})
	public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof HomeException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            HomeException unfe = (HomeException) ex;

            return handleHomeException(unfe, headers, status, request);
        } else if (ex instanceof SubscribeException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            SubscribeException cnae = (SubscribeException) ex;

            return handleSubscribeException(cnae, headers, status, request);
        }else if (ex instanceof CustomException) {
            HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
            CustomException cnae = (CustomException) ex;

            return handleCustomException(cnae, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }
	
	 protected ResponseEntity<?> handleHomeException(HomeException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> errors = Collections.singletonList(ex.getMessage());
	        return handleExceptionInternal(ex, new ApiError(new Date(), status.name(), errors), headers, status, request);
	 }
	 
	 protected ResponseEntity<?> handleSubscribeException(SubscribeException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> errors = Collections.singletonList(ex.getMessage());
	        return handleExceptionInternal(ex, new ApiError(new Date(), status.name(),errors), headers, status, request);
	 }
	 
	 protected ResponseEntity<?> handleCustomException(CustomException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> errors = Collections.singletonList(ex.getMessage());
	        return handleExceptionInternal(ex, new ApiError(new Date(), status.name(),errors), headers, status, request);
	 }
	 
	 protected ResponseEntity<?> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
	            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
	        }

	        return new ResponseEntity<>(body, headers, status);
	    }
}
