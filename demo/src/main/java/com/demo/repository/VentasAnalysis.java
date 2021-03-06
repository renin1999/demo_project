package com.demo.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Venta;

public interface VentasAnalysis extends JpaRepository<Venta, Integer> {
	@Modifying 
	@Transactional
	@Query(value= "select top 1 totalventas,[idventas],[cantidad],[codventas],[fechaventa] "
			+ "from ventas  where year(fechaventa)=?1"
			, nativeQuery = true)
	ArrayList findByTop1Ventas(int anio);
	
	@Modifying 
	@Transactional
	@Query(value= "SELECT avg (totalventas) from ventas", nativeQuery = true)
	ArrayList findByAVGventas();
	
	@Modifying 
	@Transactional
	@Query(value= "\r\n"
			+ "SELECT SUM (totalventas) from ventas", nativeQuery = true)
	ArrayList findByGananciasTotales();
	
	@Modifying 
	@Transactional
	@Query(value= "\r\n"
			+ "SELECT SUM (totalventas) from ventas\r\n"
			+ "WHERE NOT ( year(fechaventa) = ?1)", nativeQuery = true)
	ArrayList findByGananciasporAnio(int anio);
	
	@Modifying 
	@Transactional
	@Query(value= "\r\n"
			+ "SELECT SUM (totalventas) from ventas\r\n"
			+ "WHERE NOT ( Month(fechaventa) > ?1 OR Month(fechaventa) < ?2)", nativeQuery = true)
	ArrayList findByGananciaspormeses(int hasta, int desde);
	
	@Modifying 
	@Transactional
	@Query(value= "select top 10 art.codarticulo, max (vent.totalventas) \r\n"
			+ "	from ventas as vent join articulo as art on vent.idarticulo=art.idarticulo\r\n"
			+ "	group by art.cod_articulo,vent.totalventas", nativeQuery = true)
	ArrayList findBytop10articulosmasvendidos();

}
