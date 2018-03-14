package be.vdab.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.KostRepositoryStub;
import be.vdab.repositories.OpbrengstRepository;
import be.vdab.repositories.OpbrengstRepositoryStub;

public class WinstServiceTest {
	private KostRepository kostRepository;
	private OpbrengstRepository opbrengstRepository;
	private WinstService winstService;

	@Before
	public void before() {
		kostRepository = new KostRepositoryStub();
		opbrengstRepository = new OpbrengstRepositoryStub();
		winstService = new WinstService(kostRepository, opbrengstRepository);
	}

	@Test
	public void berekenWinst() {
		assertEquals(0, BigDecimal.valueOf(1800).compareTo(winstService.getWinst()));
	}
}