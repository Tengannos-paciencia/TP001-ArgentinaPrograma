package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import utils.Crypt;

public class Usuario {

	private Integer id;
	private String nombre, password;
	private Integer dineroDisponible;
	private Integer tiempoDisponible;
	private Integer tipoAtraccion;
	ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	LinkedList<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>(); // atracciones en promo
	ArrayList<Atraccion> atraccionesCompradasSinPromo = new ArrayList<Atraccion>(); // atracciones sueltas
	private Integer costoFinal;
	private Integer tiempoFinal;
	private Integer isAdmin;
	
	private HashMap<String, String> errors;

	public Usuario(Integer id, String nombre, Integer presupuesto, Integer tiempoEnMinutos, Integer tipo) {
		this.id = id;
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
	}
	
	public Usuario(Integer id, String nombre, String password, Integer presupuesto, Integer tiempoEnMinutos, Integer tipo, Integer isAdmin) {
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
		this.isAdmin = isAdmin;
	}
	
	

	public Usuario(String nombre, String password, Integer dineroDisponible, Integer tiempoDisponible,
			Integer tipoAtraccion, Integer isAdmin) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccion = tipoAtraccion;
		this.isAdmin = isAdmin;
	}

	public int getCostoFinal() {
		return costoFinal;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public LinkedList<Atraccion> getAtraccionesCompradas() {
		return atraccionesCompradas;
	}

	public ArrayList<Promocion> getPromocionesAceptadas() {
		return promocionesAceptadas;
	}

	public void agregarAtraccionComprada(Atraccion a) {
		atraccionesCompradas.add(a);
	}

	public boolean puedeComprar(Ofertable o) {
		if (dineroYTiempoSuficientes(o) && o != null) {
			return true;
		}
		return false;
	}
	
	public boolean puedeCostear(Ofertable o) {
		if (this.dineroDisponible >= o.getCostoTotal() && o != null) {
			return true;
		}
		return false;
	}
	
	public boolean tiempoDisponible(Ofertable o) {
		if (this.tiempoDisponible >= o.getTiempoTotal() && o != null) {
			return true;
		}
		return false;
	}

	public boolean atraccionYaComprada(Ofertable o) {
		if (o.esAtraccion()) {
			return atraccionesCompradas.contains(o);
		}
		if (o.esPromocion()) {
			for (Ofertable atraccion : atraccionesCompradas) {
				return o.getListaAtracciones().contains(atraccion);
			}

		}

		return false;
	}

	private boolean dineroYTiempoSuficientes(Ofertable o) {
		if (o == null) {
			return false;
		}
		return (dineroDisponible >= o.getCostoTotal() && tiempoDisponible >= o.getTiempoTotal());
	}

	public void aceptarOfertado(Ofertable o) {
		if (o.esPromocion()) {
			promocionesAceptadas.add((Promocion) o);
			contabilizarAceptado(o);
			o.ocuparAtraccion();
			for (Atraccion atraccion : o.getListaAtracciones()) {
				atraccionesCompradas.add(atraccion);
			}
		}
		if (o.esAtraccion()) {
			contabilizarAceptado(o);
			atraccionesCompradas.add((Atraccion) o);
			atraccionesCompradasSinPromo.add((Atraccion) o);
			o.ocuparAtraccion();
		}
	}

	private void contabilizarAceptado(Ofertable o) {
		if (o.esPromocion()) {
			dineroDisponible -= o.getCostoTotal();
			tiempoDisponible -= o.getTiempoTotal();
			tiempoFinal += o.getTiempoTotal();
			costoFinal += o.getCostoTotal();
		}
		if (o.esAtraccion()) {
			dineroDisponible -= o.getCosto();
			tiempoDisponible -= o.getTiempo();
			tiempoFinal += o.getTiempo();
			costoFinal += o.getCosto();
		}
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public int getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	@Override
	public String toString() {
		
		return nombre +" "+password+" "+dineroDisponible+" "+tiempoDisponible+" "+tipoAtraccion+" "+isAdmin;
		
		
		/*
		return nombre + ", Tipo de atraccion favorita: " + this.nombreTipo() + "\nPromociones compradas:"
				+ promocionesAceptadas + "\nAtracciones sin promo compradas: " + atraccionesCompradasSinPromo
				+ "\n[Total a gastar:" + costoFinal + ", Tiempo total estimado: " + tiempoFinal + "]" + "\n\n";
				
		*/

	}

	public String nombreTipo() {
		switch (this.tipoAtraccion) {
		case 1: {
			return "TERROR";
		}
		case 2: {
			return "AUDIOVISUAL";
		}
		case 3: {
			return "EXPLORACION";
		}

		}
		return null;
	}

	public int getId() {
		return this.id;
	}
	
	public boolean isNull() {
		return false;
	}
	
	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean isAdmin() {
		if (this.isAdmin == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (dineroDisponible < 0) {
			errors.put("coins", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("time", "No debe ser negativo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	
	public Integer getIsAdmin(){
		return this.isAdmin;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDineroDisponible(Integer dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}

	public void setTiempoDisponible(Integer tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public void setTipo(Integer tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}
	

}
