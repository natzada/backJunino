package com.ex.natzada.dto;

public class DailyVoucherResponse {
    private String message;
    private long secondsLeft;

    public DailyVoucherResponse(String message, long secondsLeft) {
        this.message = message;
        this.secondsLeft = secondsLeft;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getSecondsLeft() {
		return secondsLeft;
	}

	public void setSecondsLeft(long secondsLeft) {
		this.secondsLeft = secondsLeft;
	}

    
}