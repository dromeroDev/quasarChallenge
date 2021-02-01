package com.challenge.quasar.services;

import org.springframework.http.ResponseEntity;

import com.challenge.quasar.dto.ResponseCommunicationDTO;
import com.challenge.quasar.exceptions.LocationException;
import com.challenge.quasar.exceptions.MessageException;
import com.challenge.quasar.forms.SatellitesDataForm;

public interface CommunicationService {
	public ResponseCommunicationDTO getDataSpaceship(SatellitesDataForm form) throws MessageException, LocationException;
}
