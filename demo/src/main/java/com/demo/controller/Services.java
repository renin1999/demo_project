package com.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.ArticuloRepository;


@Service
public class Services {
	@Autowired
	ArticuloRepository articuloRepository;
	
	public void updatestock(Integer stock,Integer id) {
		System.out.println(stock+"updaet"+id);
		 articuloRepository.replaceStock( stock, id);
	}
}
