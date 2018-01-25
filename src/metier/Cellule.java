package metier;

import javafx.scene.control.Cell;

import java.util.Random;

public class Cellule {

    public static final int    FEU = 1;
    public static final int CENDRE = 2;
    public static final int    SOL = 3;
    public static final int  ARBRE = 4;
    public static final int  SAPIN = 5;

    private int[] voisins;
    private int etat;

    public Cellule(int[] voisins) {
        this.voisins = voisins;
        etat = this.voisins[4];

        Random aleatoire = new Random();

        switch (etat) {

            //En feu
            case Cellule.FEU : {
                for (int i : this.voisins) {
                    if (aleatoire.nextInt(3) == 0) {
                        etat = Cellule.CENDRE;
                    } else {
                        etat = Cellule.FEU;
                    }
                }
                break;
            }

            //Cendres
            case Cellule.CENDRE : {
                if (aleatoire.nextInt(15) == 0) {
                    etat = Cellule.CENDRE;
                } else {
                    etat = Cellule.SOL;
                }
                break;
            }

            //SOL
            case Cellule.SOL : {
                if (aleatoire.nextInt(200) == 0) {
                    if (aleatoire.nextInt(5) == 0) {
                        etat = Cellule.SAPIN;
                    } else {
                        etat = Cellule.ARBRE;
                    }
                } else {
                    etat = Cellule.SOL;
                }
                break;
            }

            //Arbre
            case Cellule.ARBRE : {
                for (int i : this.voisins) {
                    if (i == 1) {
                        if (aleatoire.nextInt(3) == 0) {
                            etat = Cellule.FEU;
                        } else {
                            etat = Cellule.ARBRE;
                        }
                    }
                }

                if (aleatoire.nextInt(100000) == 0) {
                    etat = Cellule.FEU;
                }

                break;
            }

            //Sapin
            case Cellule.SAPIN: {
                for (int i : this.voisins) {
                    if (i == 1) {
                        if (aleatoire.nextInt(8) == 0) {
                            etat = Cellule.FEU;
                        } else {
                            etat = Cellule.SAPIN;
                        }
                    }
                }

                if (aleatoire.nextInt(100000) == 0) {
                    etat = Cellule.FEU;
                }

                break;
            }
        }

        this.voisins[4] = etat;
    }

    public int[] returnCells() {
        return this.voisins;
    }

}