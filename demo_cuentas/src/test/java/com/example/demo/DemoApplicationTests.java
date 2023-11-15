package com.example.demo;

import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Movimiento;
import com.example.demo.Domain.Reporte;
import com.example.demo.Repository.cuentaRepository;
import com.example.demo.Service.cuentaService;
import com.example.demo.Service.hashService;
import com.example.demo.Service.movimientoService;
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
		Mockito.doReturn(cuenta).when(service).createCuenta(cuenta);
		Assert.assertEquals(cuenta, service.createCuenta(cuenta));
	}

	@Test
	void deleteCuenta(){
		cuentaService mock = new cuentaService();
		cuentaService service = Mockito.spy(mock);
		Cuenta c = new Cuenta();
		Mockito.doReturn(c).when(service).deleteCuenta("1");
		Assert.assertEquals(c, service.deleteCuenta("1"));
	}


	@Test
	void testGetAllMovimientos(){
		List<Movimiento> movimientos = new ArrayList<>();
		movimientos.add(new Movimiento());
		movimientos.add(new Movimiento());
		movimientos.add(new Movimiento());
		movimientoService mock = new movimientoService();
		movimientoService service = Mockito.spy(mock);
		Mockito.doReturn(movimientos).when(service).getAllMovimiento("1");
		Assert.assertEquals(movimientos.size(), service.getAllMovimiento("1").size());
	}

	@Test
	void addMovimiento() {
		Movimiento movimiento = new Movimiento();
		movimientoService mock = new movimientoService();
		movimientoService service = Mockito.spy(mock);
		Mockito.doReturn("succesfull").when(service).registerMovimiento(1, "1");
		Assert.assertEquals("succesfull", service.registerMovimiento(1,"1"));
	}

	@Test
	void testReporte(){
		List<Reporte> reporteList = new ArrayList<>();
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		reporteList.add(new Reporte("2023-05-25 00:00:00", 100, "1"));
		cuentaService servicePersona = new cuentaService();
		cuentaService service = Mockito.spy(servicePersona);
		Mockito.doReturn(reporteList).when(service).getReport("2023-05-25 00:00:00", "2023-08-25 09:08:18", "1");
		Assert.assertEquals(reporteList,service.getReport("2023-05-25 00:00:00", "2023-08-25 09:08:18", "1"));
	}

}



