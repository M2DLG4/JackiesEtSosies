package jackiesetsosies
/*
    Modele du Membre
 */
class Membre {
    String nom;
    String prenom;
    String mail;
    String mdp;
    String ville;
    String sexe;
    boolean isSosie;
    Star idStar;
    Photo idPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        mail email: true
        ville blank: false
        sexe inList: ["F", "M"]
        isSosie nullable: false
        idStar nullable: true
        idPhoto nullable: true
    }
}
