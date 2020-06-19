package ch.bztf.vorlagelb1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ch.bztf.Termine.model.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	

	//@DisplayName("Konstruktor test")
	@Test
	public void BeschreibungTest(){
		Termin termin1 = new Termin("37-20-2021", "Das ist ein Test", "Hoch");
		assertEquals("Das ist ein Test", termin1.getBeschreibung());
	}

	@Test
	public void DatumTest(){
		Termin termin1 = new Termin("37-20-2021", "Das ist ein Test", "Hoch");
		assertEquals("37-20-2021", termin1.getDatum());
	}

	@Test
	public void wichtigkeitTest(){
		Termin termin1 = new Termin("37-20-2021", "Das ist ein Test", "Hoch");
		assertEquals("Hoch", termin1.getWichtigkeit());
	}










}
