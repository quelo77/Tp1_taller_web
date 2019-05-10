2019 1� cuatrimestre

 							Taller Web 1
 				Trabajo pr�ctico Hibernate | Spring MVC


Montar el entorno java y subir un proyecto en com�n en github. Enviar el link para mirar los commits en
github, se validar� que existan �push� de ambos miembros del equipo.
Se muestra ejemplo de c�mo deber�a verse (no pasar screenshots, con la entrega del TP debe incluir la
URL del proyecto en github)


Dado el siguiente modelo

Pais (nombre, habitantes, idioma, capital, continente)
Continente (nombre)
Ciudad(nombre, ubicacionGeografica, pais)
Ubicacion(latitud, longitud)


1- Escribir las clases con las relaciones correspondientes
2- Hacer con junit un test que busque todos los pa�ses de habla inglesa.
3- Hacer con junit un test que busque todos los pa�ses del continente europeo.
4- Hacer con junit un test que busque todos los pa�ses cuya capital est�n al norte del tr�pico de c�ncer.
5- Hacer con junit un test que busque todas las ciudades del hemisferio sur
6- Usando path variables, hacer un action que reciba una operaci�n y una cadena de caracteres y que
lleve a una vista que muestra la siguiente frase �El resultado de <nombre-operacion> sobre <cadena> es
<cadena-resultado> �, donde la <cadena-resultado> es la cadena resultante de aplicar la operaci�n a la
cadena recibida por par�metro. Las operaciones pueden ser: pasarAMayuscula, pasarAMiniscula,
invertirOrden, cantidadDeCaracteres (en este caso se devuelve un n�mero).
