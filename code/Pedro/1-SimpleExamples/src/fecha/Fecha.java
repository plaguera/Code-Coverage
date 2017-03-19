package fecha;

import java.util.Arrays;
import java.util.List;

public class Fecha {
	
	private int dia;
	private int mes;
	private int anio;
	private int bisiesto;
	private final List<List<Integer>> diasMes;
	private final List<String> semana, meses;
	
	public Fecha(int dia_p, int mes_p, int anio_p){
		
		if(esBisiesto(anio_p))
			bisiesto = 1;
		else
			bisiesto = 0;
		
		diasMes = 	Arrays.asList(
			    	Arrays.asList( 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ),
			    	Arrays.asList( 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ) );
		semana = 	Arrays.asList("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
		meses = 	Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
		
		if(!esFechaValida(dia_p, mes_p, anio_p))
			throw new IllegalArgumentException("Día, mes o año no válido");
		dia = dia_p;
		mes = mes_p;
		anio = anio_p;
		
	}
	
	public int getDia(){
		return dia;
	}
	
	public int getMes(){
		return mes;
	}
	
	public int getAnio(){
		return anio;
	}
	
	/**
	 * Método estático que devuelve true si el año (parámetro) es bisiesto o false si no.
	 * @param anio_p
	 * @return
	 */
	public static boolean esBisiesto(int anio_p){
		 if (anio_p % 4 == 0){
	        if (anio_p % 100 == 0){
	            if (anio_p % 400 == 0)
	                return true;
	            else
	            	return false;
	        }
	        else
	        	return true;
	    }
	    else
	    	return false;
	}
	
	/**
	 * Método de clase que devuelve true si el año es bisiesto o false si no.
	 * @return
	 */
	public boolean esBisiesto(){
		 if (anio % 4 == 0){
	        if (anio % 100 == 0){
	            if (anio % 400 == 0){
	            	bisiesto = 1;
	            	return true;
	            }
	                
	            else {
	            	bisiesto = 0;
	            	return false;
	            }
	        }
	        else{
	        	bisiesto = 1;
	        	return true;
	        }
	        	
	    }
	    else {
	    	bisiesto = 0;
	    	return false;
	    }
	}
	
	/**
	 * Comprueba si la fecha es válida
	 * @param dia_p
	 * @param mes_p
	 * @param anio_p
	 * @return
	 */
	public boolean esFechaValida(int dia_p, int mes_p, int anio_p){
		
		int auxBis = 0;
		if(esBisiesto(anio_p))
			auxBis = 1;
			
		if(dia_p < 1 || dia_p > diasMes.get(auxBis).get(mes_p-1))
			return false;
		else if(mes_p < 1 || mes_p > 12)
			return false;
		else if(anio_p < 1 || anio_p > 9999)
			return false;
		return true;
		
	}
	
	/**
	 * Devuelve el día de la semana. Válido a partir de Octubre 1582 (Calendario Gregoriano)
	 * @return 0 -> Domingo, 1 -> Lunes, 2 -> Martes, ...
	 */
	public int getDiaSemana(){
		int d = dia, m = mes, y = anio;
		d += m<3 ? y-- : y-2;
		return (23 * m/9 + d + 4 + y/4 -y/100 + y/400) % 7;
	}
	
	/**
	 * Comprueba si la nueva fecha es válida y si lo es, cambia los valores de los atributos.
	 * @param day
	 * @param month
	 * @param year
	 */
	public void setFecha(int day, int month, int year){
		if(!esFechaValida(day, month, year))
			throw new IllegalArgumentException("día, mes o año no válido");
		else{
			dia = day;
			mes = month;
			anio = year;
		}
	}
	
	public void setDia(int day){

		if(day < 1 || day > diasMes.get(bisiesto).get(mes-1))
			throw new IllegalArgumentException("día no válido en " + mes +"/"+ anio);
		else
			dia = day;
	}
	
	public void setMes(int month){
		if(month < 1 || month > 12)
			throw new IllegalArgumentException("mes no válido");
		else
			mes = month;
	}

	public void setAnio(int year){
		if((year < 1 || year > 9999) || (dia == 29 && mes == 2 && !esBisiesto(year)))
			throw new IllegalArgumentException("año no válido");
		else
			anio = year;
		
	}
	
	public String toString(){
		return semana.get(getDiaSemana()) + ", " + getDia() + " de " + meses.get(getMes()-1) + " de " + getAnio();
	}
	
	/**
	 * Cambia la fecha de la instancia al siguiente día y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha siguienteDia(){
		
		if(dia == diasMes.get(bisiesto).get(mes-1)){
			if(mes == 12)
				if(anio == 9999)
					throw new IllegalArgumentException("año fuera de rango");
				else{
					anio++;
					mes = 1;
				}	
			else
				mes++;
			dia = 1;
		}
		else
			dia++;
		return this;
		
	}
	
	/**
	 * Cambia la fecha de la instancia al siguiente mes y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha siguienteMes(){
		
		if(mes == 12){
			if(anio == 9999)
				throw new IllegalArgumentException("año fuera de rango");
			else{
				anio++;
				mes = 1;
			}
		}
		else{
			if(diasMes.get(bisiesto).get(mes-1) == dia)
				dia = diasMes.get(bisiesto).get(mes);
			mes++;
		}
		return this;
		
	}
	
	/**
	 * Cambia la fecha de la instancia al siguiente año y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha siguienteAnio(){
		
		if(anio == 9999)
			throw new IllegalArgumentException("año fuera de rango");
		else{
			if(esBisiesto(anio) && mes == 2 && dia == 29)
				dia = 28;
			anio++;
		}
		return this;
		
	}
	
	/**
	 * Cambia la fecha de la instancia al día anterior y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha anteriorDia(){
		
		if(dia == 1){
			if(mes == 1)
				if(anio == 1)
					throw new IllegalArgumentException("año fuera de rango");
				else{
					anio--;
					mes = 12;
				}	
			else
				mes--;
			dia = diasMes.get(bisiesto).get(mes-1);
		}
		else
			dia--;
		return this;	
		
	}
	
	/**
	 * Cambia la fecha de la instancia al mes anterior y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha anteriorMes(){
		
		if(mes == 1){
			if(anio == 1)
				throw new IllegalArgumentException("año fuera de rango");
			else{
				anio--;
				mes = 12;
			}
		}
		else{
			if(diasMes.get(bisiesto).get(mes-1) == dia)
				dia = diasMes.get(bisiesto).get(mes-2);
			mes--;
		}
		return this;
		
	}
	
	/**
	 * Cambia la fecha de la instancia al año anterior y devuelve el nuevo objeto Fecha.
	 * @return
	 */
	public Fecha anteriorAnio(){
		
		if(anio == 1)
			throw new IllegalArgumentException("año fuera de rango");
		else{
			if(esBisiesto(anio) && mes == 2 && dia == 29)
				dia = 28;
			anio--;
		}
		return this;
		
	}
	
}
