package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

/**
 * Se puede usar cualquiera de las dos anotaciones: @Component o @Service La
 * diferencia es que @Service aporta una semántica, algo descriptivo de que esta
 * clase representa un servicio en Spring, es decir una clase de lógica de
 * negocio, pero ambos hacen lo mismo.
 *
 */

//@Service
//@Primary //Indica que esta clase será la que se inyectará por defecto
//@Component("miServicioSimple") //Se le puede poner un nombre
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante simple :')...";
	}

}
