package com.concessionaria.service;

import com.concessionaria.model.Auto;
import com.concessionaria.model.Veicolo;
import com.concessionaria.model.Moto;
import com.concessionaria.repository.SalvataggioDati;
import com.concessionaria.repository.GestoreDati;


import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Concessionaria {
    private GestoreDati gestore;
        private ArrayList<Veicolo> inventario = new ArrayList<>(); //lista che contiene tutte le auto della concessionaria

        public void aggiungiVeicolo(Veicolo a) { //metodo per aggiungere un'veicolo
            inventario.add(a);
        }

        public ArrayList<Veicolo> getInventario() { //metodo per ottenere la lista dell'inventario
            return inventario;
        }
        public void stampaParco() { //metodo per stampa tutti i veicoli
            for (Veicolo veicolo : inventario) {
                veicolo.stampaScheda();
                System.out.println("-------------");
            }
        }
        public void cercaPerMarca (String marca) { //metodo per cercare e stampare tutte le auto di una marca specifica
            inventario.stream()
                        .filter(veicolo -> veicolo.getMarca().equalsIgnoreCase(marca))
                        .forEach(veicolo -> veicolo.stampaScheda());
        }

        public void stampaVeicoloEconomici(double budget) {
            inventario.stream()
                        .filter(veicolo -> veicolo.getPrezzo() <= budget)
                        .forEach(veicolo -> veicolo.stampaScheda());
        }

    public Concessionaria(GestoreDati gestore) {
        this.gestore = gestore;
    }

    public void aggiungiESalva(Veicolo v) {
        inventario.add(v);
        gestore.salva(v); // Non gli interessa se è un file, un database o un server!
    }
}
