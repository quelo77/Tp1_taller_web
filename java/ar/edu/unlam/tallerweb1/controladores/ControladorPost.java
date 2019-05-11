package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Operaciones;
@Controller
public class ControladorPost {
	@RequestMapping(path="/form-post", method=RequestMethod.GET)
	public ModelAndView irAFormPruebaPost() {
		Operaciones formulario= new Operaciones();
		ModelMap modelo= new ModelMap();
		modelo.put("formulario", formulario);
		return new ModelAndView("form-post",modelo);
		
	}
	@RequestMapping(path="operaciones", method=RequestMethod.POST)
	public ModelAndView sumaSimple(@ModelAttribute("formulario")Operaciones s) {
		ModelMap modelo= new ModelMap();
		if(s.getOperar()==null){
			modelo.put("error", "Solo pueden ingresarse numeros");
			return new ModelAndView("form-post", modelo);
		}
		modelo.put("formulario", s);
		return new ModelAndView("exit-post",modelo);
		
	}
	
	
	@RequestMapping(path="exit-post",method=RequestMethod.GET)
	public ModelAndView irAExitPrueba() {
		return new ModelAndView("exit-post");
	}
	
}
