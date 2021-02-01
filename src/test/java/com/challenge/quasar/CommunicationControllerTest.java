package com.challenge.quasar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.quasar.controllers.CommunicationController;
import com.challenge.quasar.entities.Satellite;
import com.challenge.quasar.forms.SatellitesDataForm;
import com.challenge.quasar.services.CommunicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(CommunicationController.class)
public class CommunicationControllerTest {
	@Autowired
    private MockMvc mvc;
	
	@MockBean
    private CommunicationService service;

	@Test
	public void given2SatellitesGetStatus404() throws Exception{
		SatellitesDataForm form = new SatellitesDataForm();
		Satellite sat1 = new Satellite();
		Satellite sat2 = new Satellite();
		List<Satellite> satellites = Arrays.asList(sat1, sat2);
		form.setSatellites(satellites);
		service.getDataSpaceship(form);
		mvc.perform(post("/topsecret")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().is(400));
	}
	
}
