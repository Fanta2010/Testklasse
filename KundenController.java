/*
 * Projekt: TaxiSys
 * Datei  : Kundeliste.java (Control-Klasse)
 * Gruppe : <hier Namen der Mitglieder eintragen>
 * Letzte Änderung: 26.08.2016
 *
 * Änderungen
 * 26.08.16 : Initiale Erstellung der Klasse
 *
 */

package controller;

import entities.Kunde;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class KundenController {

    final static boolean DEBUG = false;

    private ArrayList<Kunde> kundenliste;
    private int knr;

    // Konstruktor
    public KundenController() {
        kundenliste = new ArrayList();

        // Starte Kundennummer mit "1"
        knr = 1;
    }

    /**
     *
     * @param k
     * @return
     */
    public Boolean kundeHinzufuegen(Kunde k) {       
        try {
             // Kundenobjekt hinzufügen
            kundenliste.add(k);

            // Neue Kundennummer setzen
            knr++;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    public Boolean kundeEntfernen(String kundenNummer) {
        if( kundenliste != null && kundenliste.size() > 0) {
            int index = -1;  // Index to remove
            
            for(int i=0; i < kundenliste.size(); i++) {
                if (kundenliste.get(i).getKundenNr().equals(kundenNummer)) {
                    index = i;
                    break;
                }
            }
            
            if (index >= 0) {
                kundenliste.remove(index);
                return true;                
            } else {
                return false;
            }            
        } else {
            return true;
        }
    }

    public ArrayList<Kunde> getKundeliste() {
        return this.kundenliste;
    }

    /**
     *
     * @param kundenliste
     */
    public void setKundeliste(ArrayList<Kunde> kundenliste) {
        this.kundenliste = kundenliste;
    }

    public int getKnr() {
        return knr;
    }

    /**
     *
     * @param knr
     */
    public void setKnr(int knr) {
        this.knr = knr;
    }
    
    public Kunde getKundeByKnr(String kundenNummer) {
        for(Kunde kunde: getKundeliste()) {
            if(kunde.getKundenNr().equals(kundenNummer)) {
                return kunde;
            }
        }
        
        return null;
    
    }

    // Nur zu Debug-/Testzwecken
    public void listeAusgeben() {
        int x = 0;
        if (DEBUG) {
            System.out.println("Kundenliste");
            Iterator iter = kundenliste.iterator();

            while (iter.hasNext()) {
                Kunde k = (Kunde) iter.next();
                System.out.println(k.getKundenNr() + " - " + k.getKundenName());
            }
        }
    }

}
