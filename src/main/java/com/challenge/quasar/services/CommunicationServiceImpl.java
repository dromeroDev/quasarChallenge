package com.challenge.quasar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.quasar.dto.ResponseCommunicationDTO;
import com.challenge.quasar.entities.Position;
import com.challenge.quasar.exceptions.LocationException;
import com.challenge.quasar.exceptions.MessageException;
import com.challenge.quasar.forms.SatellitesDataForm;

@Service
public class CommunicationServiceImpl implements CommunicationService {
	
	@Autowired
	ResolveCommunicationService resolveCommunicationService;

	@Override
	public ResponseCommunicationDTO getDataSpaceship(SatellitesDataForm form) throws MessageException, LocationException{
		List<String> fullMessage = null;
		double[] position = null;
		try {
			fullMessage = resolveCommunicationService.getMessage(form.getMessages());
		} catch (Exception e) {
			throw new MessageException("An error occurred and the message did not arrive!");
		}
		
		try {
			position = resolveCommunicationService.getLocation(form.getDistancesConverted());		
		} catch (Exception e) {
			throw new LocationException("An error occurred and the ship could not be located!");
		}

		ResponseCommunicationDTO response = new ResponseCommunicationDTO();
		response.setMessage(String.join(" ", fullMessage));
		response.setPosition(new Position(Double.valueOf(position[0]).floatValue(), Double.valueOf(position[1]).floatValue()));
		return response;
	}
}
