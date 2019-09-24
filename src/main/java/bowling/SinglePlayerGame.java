package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        private int tours;
        private int points;
        private int nbQuilles;
        private boolean secondBoule;
        private int compteDouble;
        
        private final Integer POINTSMAX = 300;
        
	/**
	 * Constructeur
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
            int compteDoubleLocale = 0;
            nbQuilles -= nombreDeQuillesAbattues;
            if(nbQuilles == 0) {
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
            } else {
                if(secondBoule) {
                    secondBoule = false;
                } else {
                    secondBoule = true;
                }
            }
            
            if(compteDouble != 0) {
                if(compteDouble >= 3 && compteDoubleLocale == 2) {
                    points += nombreDeQuillesAbattues*3;
                } else {
                    points += nombreDeQuillesAbattues*2;
                }
                compteDouble --;
            } else {
                points += nombreDeQuillesAbattues;
            }
            
            compteDouble += compteDoubleLocale;
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
