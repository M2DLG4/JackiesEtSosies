package jackiesetsosies
/*
    Modele du Star
 */
class Star {
    String nom;
    String prenom;
    String urlPhoto;

    static constraints = {
        nom blank: false
        prenom blank: false
        urlPhoto blank: false
    }
}
