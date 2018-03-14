package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;

public class WinstService {
	private final KostRepository kostRepository;
	private final OpbrengstRepository opbrengstRepository;
	
	public WinstService(KostRepository kostRepository, OpbrengstRepository opbrengstRepository) {
		this.kostRepository = kostRepository;
		this.opbrengstRepository = opbrengstRepository;
	}
	
	public BigDecimal getWinst() {
		return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
	}
}
