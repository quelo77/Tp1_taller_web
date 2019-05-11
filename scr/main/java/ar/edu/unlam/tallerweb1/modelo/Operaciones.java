package ar.edu.unlam.tallerweb1.modelo;

public class Operaciones {

	String a;
	String b;
	String texto;
	String operacion;
	
	public Operaciones() {
		
	}
	public String getA() {
		return a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	

	
	
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getOperar() {
		switch(operacion) {
		case "Pasar a mayuscula": 
				return texto.toUpperCase();
		case "Pasar a Minuscula":
				return texto.toLowerCase();
		case "Invertir orden del texto":
			String invertida=" ";
			for (int indice = texto.length() - 1; indice >= 0; indice--) {
				// Y vamos concatenando cada carácter a la nueva cadena
				invertida += texto.charAt(indice);
			}
			return invertida;
		case "Cantidad de caracteres del texto":
			 int aux=texto.length();
			return Integer.toString(aux);
		default:
				return null;
				
		}		
	}

}