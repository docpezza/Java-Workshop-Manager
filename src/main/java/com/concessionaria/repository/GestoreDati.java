package com.concessionaria.repository;

import com.concessionaria.model.Auto; 
import com.concessionaria.model.Veicolo;
import com.concessionaria.service.Concessionaria;
import com.concessionaria.app.Main;

import java.util.ArrayList;

public interface GestoreDati {
    void salva(Veicolo v);
    ArrayList<Veicolo> carica();
}
