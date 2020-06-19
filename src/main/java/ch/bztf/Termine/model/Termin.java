package ch.bztf.Termine.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Entity : Student
 */
@Entity // Das sagt Hibernate, dass es einen Tabelle in der Datenbank anlegen soll
public class Termin {

    //logger
    static final Logger logger = LoggerFactory.getLogger("TerminController.class");

    @Id // ID 
    @GeneratedValue(strategy = GenerationType.AUTO) // Autoincrement
    private long id;

    @NotBlank(message = "datum is mandatory") // NOT NULL
    @Column(name = "datum") // Name der Column
    private String datum; //datum

    @NotBlank(message = "beschreibung is mandatory") // NOT NULL
    private String beschreibung;

    @NotBlank(message = "beschreibung is mandatory") // NOT NULL
    private String wichtigkeit;

    public Termin() {}

    public Termin(String datum, String beschreibung, String wichtigkeit) { //Konstruktor Termin
        this.datum = datum;
        this.beschreibung = beschreibung;
        this.wichtigkeit = wichtigkeit;
        logger.info("Neuer Termin ERstellt");
    }

    public void setDatum(String datum) {
        this.datum = datum;
        logger.info("Neues Datum Erstellt");
    }
    
    public String getDatum() {
        return datum;
    }

    public void setId(long id) {  
        this.id = id;
        logger.info("Neue ID ERstellt");
    }
    
    public long getId() {
        return id;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
        logger.info("Neue Beschreibung ERstellt");
    }
    
    public String getBeschreibung() {
        return beschreibung;
    }
    
    public void setWichtigkeit(String wichtigkeit) {
        if(wichtigkeit.equals("Hoch")||wichtigkeit.equals("Mittel")||wichtigkeit.equals("Niedrig")){ //Richtige Auswahl
        this.wichtigkeit = wichtigkeit;
        logger.info("Neue Wichtigkeit ERstellt, Auswahl ist Richtig");
        }
    }
    
    public String getWichtigkeit() {
        return wichtigkeit;
    }
}