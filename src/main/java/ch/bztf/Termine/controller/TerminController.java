
package ch.bztf.Termine.controller;



import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ch.bztf.Termine.model.Termin;
import ch.bztf.Termine.respository.TerminRepository;



@Controller
@RequestMapping("/termin") // /Termin pfad
public class TerminController {

    // TerminRepository ist die Schnittstelle zur DB
	private final TerminRepository terminRepository;

    //logger
    static final Logger logger = LoggerFactory.getLogger("TerminController.class");
    // AutoWired : wir automatisch ausgeführt
	@Autowired
	public TerminController(TerminRepository terminRepository) {
		this.terminRepository = terminRepository;
	}
    
    // HTTP-GET auf http://localhost:8080/Termin
    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("termine", terminRepository.findAll()); // Datenbank Durchsuchen
        logger.info("Index aufgeruffen"); //Logger
        return "Termin/index"; // wir laden die termin/index.html
    }
    // HTTP-GET auf https://localhost:8080/Termin
    @GetMapping("error")
    public String showError(Model model) {
        
        logger.info("Index aufgeruffen"); //Logger
        return "Termin/error"; //Aufruf der error.html
    }

    // HTTP-GET auf http://localhost:8080/student/create
    @GetMapping("create")
	public String showSignUpForm(Termin termin) {
        logger.info("Termin erstellt");
        return "Termin/add"; // wir laden die student/create-student.html
	}

    // HTTP-POST Aufruf auf http://localhost:8080/termin/add
    @PostMapping("add")
	public String addTermin(@Valid Termin termin, BindingResult result, Model model) {
        
		if (result.hasErrors()) {  //Fehler in der Eingabe  
            logger.error("Falsche Angaben"); //Logger
			return "redirect:/termin/error";  // Umleitung auf Errorpage
		}
        logger.info("Termin Hinzugefügt");
        
		terminRepository.save(termin); //Speicherrung der Eingabe in der DB
		return "redirect:/termin/"; // Umleitung auf Index für Auflistung
    }
    
 
    @GetMapping("delete/{id}")
	public String deleteTermin(@PathVariable("id") long id, Model model) {
        // Wir holen uns den Stundent und gucken ob es ihn gibt
		Termin termin = terminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
                
        // Wir löschen den Studenten
        terminRepository.delete(termin);
        // Holen uns alle Studenten
        model.addAttribute("termine", terminRepository.findAll());
        // Und zeigen sie mit dem student/list.html an
        logger.info("Datensatz gelöscht");
		return "redirect:/termin/";
	}

}