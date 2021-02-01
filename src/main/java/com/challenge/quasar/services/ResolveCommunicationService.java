package com.challenge.quasar.services;

import java.util.List;

import com.challenge.quasar.exceptions.MessageException;

public interface ResolveCommunicationService {
	public List<String> getMessage(List<List<String>> messages);
	public double[] getLocation(double[] distances);
}
