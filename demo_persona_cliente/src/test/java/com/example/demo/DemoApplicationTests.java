package com.example.demo;

import com.example.demo.Domain.Cliente;
import com.example.demo.Domain.Persona;
import com.example.demo.Domain.Reporte;
import com.example.demo.Service.hashService;
import com.example.demo.Service.servicePersona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testHash(){
		hashService hashService = new hashService();
		String text = "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";
		Assert.assertEquals(text, hashService.hashString("1234"));
	}

	@Test
	void testGetAll(){
		List<Persona> personaList = new ArrayList<>();
		Persona p = new Persona();
		personaList.add(p);
		servicePersona servicePersona = new servicePersona();
		servicePersona service = Mockito.spy(servicePersona);
		Mockito.doReturn(personaList).when(service).getAllClients();
		Assert.assertEquals(personaList, service.getAllClients() );
	}

	@Test
	void testAddPerson(){
		Cliente p = new Cliente();
		servicePersona servicePersona = new servicePersona();
		servicePersona service = Mockito.spy(servicePersona);
		Mockito.doReturn(true).when(service).addClient(p);
		Assert.assertEquals(true,service.addClient(p));
	}

	@Test
	void testDeletePerson() {
		servicePersona servicePersona = new servicePersona();
		servicePersona service = Mockito.spy(servicePersona);
		Mockito.doReturn(true).when(service).deleteClient(1);
		Assert.assertEquals(true,service.deleteClient(1));
	}

	@Test
	void testReporte(){
		List<Reporte> reporteList = new ArrayList<>();
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		servicePersona servicePersona = new servicePersona();
		servicePersona service = Mockito.spy(servicePersona);
		Mockito.doReturn(reporteList).when(service).getReport("2023-05-25 00:00:00", "2023-08-25 09:08:18", "1");
		Assert.assertEquals(reporteList,service.getReport("2023-05-25 00:00:00", "2023-08-25 09:08:18", "1"));
	}

}
