package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    final String CONNEXION_OK = "Vous êtes maintenant connecté."
    final String CONNEXION_NOK = "Mail ou mot de passe erroné."

    def membreService

    @Override
    def index() {
    }

    def inscription() {
        if (params.isSosie)
            params.isSosie = params.boolean("isSosie")
        else
            params.isSosie = false;
        Membre membre = new Membre(nom: params.nom, prenom: params.prenom, ville: params.ville,
                sexe: params.sexe, isSosie: params.isSosie, mail: params.mail, mdp: params.mdp);

        String validationInscription;

        if (!membreService.inscriptionMembre(membre)?.hasErrors()) {
            validationInscription = INSCRIPTION_OK;
        } else {
            validationInscription = INSCRIPTION_NOK;
        }

        render(view: "index", model: [validation:validationInscription])
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        session.setAttribute("user", membreService.connexionMembre(mail, mdp))

        if (session.getAttribute("user") == null)
            render(view: "index", model: [erreur: CONNEXION_NOK])
        else
            session.setAttribute("mail", mail)
            redirect(action: "actus")
    }

    def actus() {
        render(view: "actus")
    }
}
