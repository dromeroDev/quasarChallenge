package com.challenge.quasar.dto;

import com.challenge.quasar.entities.Position;

public class ResponseCommunicationDTO {
	private Position position;
	private String message;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
