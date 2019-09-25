package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
            
        /** représente le nombre de tours restants */
        private int tours;
        /** Nombre de points total de la partie */
        private int points;
        /** Nombre de quilles restante dans le tour */
        private int nbQuilles;
        /** Indique l'état de la manche true si deuxièmes boules sinon false */
        private boolean secondBoule;
        /** Indique le nombre de tours restants qui comptent doubles */
        private int compteDouble;

        
	/**
         * Constructeur SInglePlayerGame
         */
	public SinglePlayerGame() {
            this.tours = 10;
            this.points = 0;
            this.nbQuilles = 10;
            this.secondBoule = false;
            this.compteDouble = 0;
	}
        
	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            /** compteDoubleLocale = 1 si spare fait à ce tir et 2 si strike fait
             *  à ce tir
             */ 
            int compteDoubleLocale = 0;
            nbQuilles -= nombreDeQuillesAbattues;
            if(nbQuilles != 0) {
                // cas par défaut
                if(secondBoule) {
                    secondBoule = false;
                } else {
                    secondBoule = true;
                }
            } else {
                //cas spare ou strike
                if(secondBoule) {
                    //cas Spare
                    secondBoule = false; 
                    if(tours == 1) {
                        tours ++;
                        secondBoule = true;
                    } else {
                        compteDoubleLocale = 1;
                    }
                } else {
                    //cas Strike
                    if (tours ==1) {
                        tours ++;
                    } else {
                        compteDoubleLocale = 2;
                    }
                }

            }
            // cas boule triplé ou doublé
            if(compteDouble != 0) {
                if(compteDouble >= 3 && compteDoubleLocale == 2) {
                    points += nombreDeQuillesAbattues*3;
                } else {
                    points += nombreDeQuillesAbattues*2;
                }
                compteDouble --;
            // cas standard    
            } else {
                points += nombreDeQuillesAbattues;
            }
            compteDouble += compteDoubleLocale;
            //Passe au prochain tour
            if(secondBoule == false) {
                tours --;
                nbQuilles = 10;
            }
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            return points;
	}
}
