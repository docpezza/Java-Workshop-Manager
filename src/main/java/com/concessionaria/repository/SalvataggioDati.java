package com.concessionaria.repository;

import com.concessionaria.model.Auto;
import com.concessionaria.model.Veicolo;
import com.concessionaria.model.Moto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class SalvataggioDati implements GestoreDati{
     public void salva(Veicolo daSalvare) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("db_veicoli.txt", true)))
            {
                String tipo = (daSalvare instanceof Auto) ? "AUTO" : "MOTO";
                writer.write(tipo + "," + daSalvare.getModello() + "," + daSalvare.getMarca() + "," + daSalvare.getPrezzo());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Errore impossibile salvare il dato!" + e.getMessage());
            }
            
        }
        
        public ArrayList<Veicolo> carica() {
            ArrayList<Veicolo> listaCaricata = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("db_veicoli.txt"))) {
                String riga;
                while ((riga = reader.readLine()) != null) {
                    String[] pezzi = riga.split(",");
                    if (pezzi.length == 4) {
                        String tipo = pezzi[0];
                        String modello = pezzi[1];
                        String marca = pezzi[2];
                        double prezzo = Double.parseDouble(pezzi[3]);

                        if(tipo.equals("AUTO")) {
                            listaCaricata.add(new Auto(modello, marca, prezzo));
                        } else if (tipo.equals("MOTO")) {
                            listaCaricata.add(new Moto(modello, marca, prezzo, false)); // Assumiamo che le moto caricate non abbiano sidecar
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Errore impossibile caricare i dati!" + e.getMessage());
            }
            return listaCaricata;
        }
}
