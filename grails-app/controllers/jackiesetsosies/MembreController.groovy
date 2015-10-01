package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    def membreService

    def index() {
    }

    def inscription() {
        params.isSosie = params.boolean("isSosie")
        Membre membre = new Membre(params);

        String validationInscription;

        if (membreService.inscriptionMembre(membre)?.hasErrors() == false) {
            validationInscription = INSCRIPTION_OK;
        } else {
            validationInscription = INSCRIPTION_NOK;
        }

        render(view: "index", model: [validation:validationInscription])
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        membreService.connexionMembre(mail, mdp)

        render(view: "index")
    }


}
