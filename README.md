#  Java Workshop Manager (Sistema Gestione Concessionaria)

Un'applicazione Java professionale progettata per la gestione di un inventario di veicoli (Auto e Moto). Il progetto implementa i principali pilastri della programmazione a oggetti (OOP) e utilizza un'architettura a strati per garantire scalabilità e manutenibilità.

##  Tecnologie Utilizzate
* **Java 17**: Core language.
* **Maven**: Gestione delle dipendenze e build automation.
* **Lombok**: Riduzione del boilerplate code (Getter, Setter, Constructor).
* **Stream API**: Manipolazione avanzata delle collezioni.
* **Git**: Controllo di versione.

##  Architettura del Progetto
Il software segue una **Layered Architecture** (Architettura a strati) per separare le responsabilità:
* **Model**: Definisce le entità del dominio (`Veicolo`, `Auto`, `Moto`).
* **Service**: Contiene la logica di business (gestione sconti, calcolo tasse).
* **Repository**: Gestisce la persistenza dei dati (I/O su file system).
* **App**: Punto di ingresso dell'applicazione (Main).

##  Funzionalità Principali
- **Ereditarietà e Polimorfismo**: Gestione dinamica di diverse tipologie di veicoli.
- **Persistenza**: Salvataggio e caricamento dei dati da file di testo (`.txt`).
- **Interfacce**: Utilizzo del pattern Repository per disaccoppiare la logica dalla persistenza.
- **Validazione**: Gestione delle eccezioni e dei flussi di input/output.

##  Come avviare il progetto
1. Clona il repository: `git clone https://github.com/docpezza/Java-Workshop-Manager.git`
2. Assicurati di avere **Maven** installato.
3. Esegui il build: `mvn clean install`
4. Avvia l'applicazione dalla classe `Main`.

---
*Progetto sviluppato come parte di un percorso di specializzazione in Java Development.*
