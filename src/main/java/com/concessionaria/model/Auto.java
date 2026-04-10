package com.concessionaria.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data                // Genera automaticamente Getter, Setter, toString, equals e hashCode
@EqualsAndHashCode(callSuper = true)
public class Auto extends Veicolo {

    public Auto(String modello, String marca, double prezzo) {
        super(marca, modello, prezzo);
    }

        public void applicaSconto(double percentuale) {
        this.prezzo = this.prezzo - (this.prezzo * percentuale / 100);
    }

    public void applicaLogicaSconti() {
        if (this.prezzo > 200 && this.prezzo <5000) {
                this.applicaSconto(10);
                System.out.println("Sconto del 10% applicato per prezzo superiore a 200.");
            }
            else if (this.prezzo > 5000) {
                applicaSconto(15);
                System.out.println("Sconto del 15% applicato per prezzo superiore a 5000.");
            }
            if (this.marca.equals("Audi")) {
                this.applicaSconto(20);
                System.out.println("Sconto del 20% applicato per marca Audi.");
            }
    }
    
    
}