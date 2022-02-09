package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	/**
	 * Estos métodos crean los componentes y retornan la instancia del objeto
	 */
	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto p1 = new Producto("Cámara Sony", 650);
		Producto p2 = new Producto("Bicicleta Bianchi Aro 26", 890);
		Producto p3 = new Producto("Luces LED direcionales", 15);

		ItemFactura item1 = new ItemFactura(p1, 27);
		ItemFactura item2 = new ItemFactura(p2, 73);
		ItemFactura item3 = new ItemFactura(p3, 67);

		return Arrays.asList(item1, item2, item3);
	}
	
	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficina() {
		Producto p1 = new Producto("Monitor LG 27'", 750);
		Producto p2 = new Producto("Teclado Micronics", 80);
		Producto p3 = new Producto("Bocina Pc", 77);
		Producto p4 = new Producto("Impresora Epson L350 multifuncional", 730);
		
		ItemFactura item1 = new ItemFactura(p1, 2);
		ItemFactura item2 = new ItemFactura(p2, 1);
		ItemFactura item3 = new ItemFactura(p3, 1);
		ItemFactura item4 = new ItemFactura(p4, 1);
		
		return Arrays.asList(item1, item2, item3, item4);
	}

}
