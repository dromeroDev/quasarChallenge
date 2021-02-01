package com.challenge.quasar.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.quasar.exceptions.LocationException;
import com.challenge.quasar.exceptions.MessageException;
import com.challenge.quasar.forms.SatellitesDataForm;
import com.challenge.quasar.services.CommunicationService;

@RestController
@Validated
public class CommunicationController {
	@Autowired
	CommunicationService serviceCommunication;

	@RequestMapping(value = "/topsecret", method= RequestMethod.POST)
	public ResponseEntity getDataSpaceship(@Valid @RequestBody SatellitesDataForm form) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(serviceCommunication.getDataSpaceship(form));
		}
		catch (MessageException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
		catch (LocationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
