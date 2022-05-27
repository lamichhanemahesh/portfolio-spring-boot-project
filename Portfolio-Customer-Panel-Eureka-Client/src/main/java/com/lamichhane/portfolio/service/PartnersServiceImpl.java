package com.lamichhane.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.portfolio.dao.PartnersDAO;
import com.lamichhane.portfolio.entity.Partners;
import com.lamichhane.portfolio.entity.Project;
import com.lamichhane.portfolio.exception.classes.PartnersNotFoundException;
import com.lamichhane.portfolio.exception.classes.ProjectsNotFoundException;


@Service
public class PartnersServiceImpl implements PartnersService{
	
	@Autowired
	private PartnersDAO partnersDAO;
	

	
	@Override
	@Transactional
	public List<Partners> getAllPartners() {
		
		return partnersDAO.findAll();
	}

	@Override
	@Transactional
	public void savePartners(Partners thePartners) {
		partnersDAO.save(thePartners);
		}

	@Override
	@Transactional
	public Partners getPartners(int theId) {
		Optional<Partners> partners = partnersDAO.findById(theId);
		if(partners.isEmpty()) {
			throw new PartnersNotFoundException("Partners Not Found With Id-"+theId);
		}
		return partners.get();
		
	}

	@Override
	@Transactional
	public void deletePartners(int id) {
		partnersDAO.deleteById(id);
	}
	
}
