package com.dulp.xyz.common.exception;

import com.dulp.xyz.common.result.CodeMsg;

public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public GlobalException(String msg) {
	    super(msg);
	}
	
	public GlobalException(Exception e){
	    super(e.getMessage());
    }

}
