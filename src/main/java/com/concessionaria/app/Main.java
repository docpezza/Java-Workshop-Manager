package com.concessionaria.app;

import com.concessionaria.model.Auto; 
import com.concessionaria.model.Veicolo;
import com.concessionaria.service.Concessionaria;
import com.concessionaria.repository.SalvataggioDati;
import com.concessionaria.repository.GestoreDati;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        Scanner lettore = new Scanner(System.in);
        GestoreDati gestore = new SalvataggioDati();
        Concessionaria miaConcessionaria = new Concessionaria(gestore);
        boolean continua = true;

        miaConcessionaria.getInventario().addAll(gestore.carica());
        
        while (continua == true) {
            boolean prezzoValido = false;
            double prezzo = 0.0;

            System.out.println("Inserisci marca:");
            String marca = lettore.nextLine();

            System.out.println("Inserisci modello:");
            String modello = lettore.nextLine();

            while(prezzoValido == false) {

            System.out.println("Inserisci prezzo:");

            if (lettore.hasNextDouble()) {
                prezzo = lettore.nextDouble();
                prezzoValido = true;
            } else {
                System.out.println("Ehi, inserisci un numero valido!");
                lettore.next(); // Consuma l'input non valido
            }
        }
         
            lettore.nextLine(); // Consuma il newline rimasto

            Auto miaAuto = new Auto(modello, marca, prezzo); //carica i dati dell'auto

            miaAuto.applicaLogicaSconti(); //applica la logica degli sconti in base al prezzo e alla marca

            miaConcessionaria.aggiungiESalva(miaAuto); //salva i dati dell'auto su un file di testo
            System.out.println("File salvato in: " + new java.io.File("db_veicoli.txt").getAbsolutePath());

            System.out.println("Vuoi inserire un'altra auto? (si/no)");
            String risposta = lettore.nextLine();

            if (risposta.equalsIgnoreCase("no")) {
                continua = false;
            }
            System.out.println("Scheda Auto " + miaConcessionaria.getInventario().size() + ":");
            miaConcessionaria.stampaParco();
        }
        System.out.println("--------FASE DI RICERCA--------");
        System.out.println("Inserisci la marca da cercare:");
        String marcaDaCercare = lettore.nextLine();
        miaConcessionaria.cercaPerMarca(marcaDaCercare);
    }
}
