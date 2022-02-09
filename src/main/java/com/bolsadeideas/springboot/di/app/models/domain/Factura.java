package com.bolsadeideas.springboot.di.app.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Factura {

	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired
	private Cliente cliente;

	@Autowired //Se está inyectando del AppConfig.java, método registrarItems()
	private List<ItemFactura> items;
	
	/**
	 * Se ejecuta justo después de creado el objeto y después de
	 * haber inyectado las dependencias en los atributos.
	 */
	@PostConstruct
	public  void inicializar() {
		//Por ejemplo, usamos el postConstruct para cambiar valores a los atributos
		this.cliente.setNombre(this.cliente.getNombre().concat(" ").concat("Gaspar"));
		this.descripcion = this.descripcion.concat(" del cliente: ").concat(this.cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(this.descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Factura [descripcion=");
		builder.append(descripcion);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append("]");
		return builder.toString();
	}

}
