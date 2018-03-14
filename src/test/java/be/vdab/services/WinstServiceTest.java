package be.vdab.services;

import java.math.BigDecimal;
import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals; // static niet vergeten!!!!!!!!!!!
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class WinstServiceTest {
	private KostRepository kostRepository;
	private OpbrengstRepository opbrengstRepository;
	private WinstService winstService;

	@Before
	public void before() {
		kostRepository = mock(KostRepository.class);
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(200));
		opbrengstRepository = mock(OpbrengstRepository.class);
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(2000));
		winstService = new WinstService(kostRepository, opbrengstRepository);
	}

	@Test
	public void getWinst() {
		assertEquals(0, BigDecimal.valueOf(1800).compareTo(winstService.getWinst()));
		verify(kostRepository).findTotaleKost();
		verify(opbrengstRepository).findTotaleOpbrengst();
	}
}