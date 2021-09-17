package com.sbs.untact.DTO;

import java.util.Map;

import com.sbs.untact.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultData {
	private String resultCode;
	
	private String msg;
	
	private Map<String, Object> body;
	
	public ResultData(String resultCode, String msg, Object...args) { 
		this.resultCode = resultCode;
		this.msg = msg;
		this.body = Util.mapOf(args);

	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}

}