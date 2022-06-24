package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.model.Venta;
import com.demo.repository.VentasAnalysis;



@RestController
@RequestMapping("/api/v1/analisis")
public class AnalysisService {
	
	@Autowired
	VentasAnalysis analysis;
	
	@GetMapping("/top1ventasporanio/{anio}")
	public ArrayList top1Ventasinayear(@PathVariable(value="anio") String anio){
		int i = Integer.parseInt(anio);
		return analysis.findByTop1Ventas(i);
	}
	@GetMapping("/promedioventas")
	public ArrayList promedioVentas(){
		return analysis.findByAVGventas();
	}
	@GetMapping("/ganaciastotales")
	public ArrayList gananciasTotales(){
		return analysis.findByGananciasTotales();
	}
	@GetMapping("/gananciapormeses/{hasta}/{desde}")
	public ArrayList gananciaspormeses(@PathVariable(value="hasta") String hasta, @PathVariable(value="desde")String desde){
		int i1 = Integer.parseInt(hasta);
		int i2 = Integer.parseInt(desde);
		return analysis.findByGananciaspormeses(i1,i2);
	}
	@GetMapping("/gananciaporanio/{anio}")
	public ArrayList ganaciasporanio(@PathVariable(value="anio") String anio){
		int i = Integer.parseInt(anio);
		return analysis.findByGananciasporAnio(i);
	}
	@GetMapping("/top10articulos")
	public ArrayList toparticulos(){
		return analysis.findBytop10articulosmasvendidos();
	}
	

}
