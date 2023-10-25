package com.example.demo;

import com.example.demo.Domain.Cuenta;
import com.example.demo.Repository.cuentaRepository;
import com.example.demo.Service.cuentaService;
import com.example.demo.Service.hashService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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
	void testGetAllCuentas(){
		List<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(new Cuenta());
		cuentas.add(new Cuenta());
		cuentas.add(new Cuenta());
		cuentaService mock = new cuentaService();
		cuentaService service = Mockito.spy(mock);
		Mockito.doReturn(cuentas).when(service).getAllCuentas();
		Assert.assertEquals(cuentas.size(), service.getAllCuentas().size());
	}

	@Test
	void addCuenta() {
		Cuenta cuenta = new Cuenta("1234");
		cuentaService mock = new cuentaService();
		cuentaService service = Mockito.spy(mock);
		Mockito.doReturn(true).when(service).createCuenta(cuenta);
		Assert.assertEquals(true, service.createCuenta(cuenta));
	}

	@Test
	void deleteCuenta(){
		cuentaService mock = new cuentaService();
		cuentaService service = Mockito.spy(mock);
		Cuenta c = new Cuenta();
		Mockito.doReturn(c).when(service).deleteCuenta("1");
		Assert.assertEquals(c, service.deleteCuenta("1"));
	}


}
