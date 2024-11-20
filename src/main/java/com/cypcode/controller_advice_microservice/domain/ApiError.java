package com.cypcode.controller_advice_microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError{
	private Date timestamp;
	private String status;
	private List<String> errors;
	
}
