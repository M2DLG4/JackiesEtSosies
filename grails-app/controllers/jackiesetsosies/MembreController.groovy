package jackiesetsosies

class MembreController {

    public static
    final String INSCRIPTION_OK = "Inscription terminée ! Vous pouvez maintenant vous connecter."
    final String INSCRIPTION_NOK = "Inscription impossible ! Veuillez réessayer."
    final String CONNEXION_OK = "Vous êtes maintenant connecté."
    final String CONNEXION_NOK = "Mail ou mot de passe erroné."
    final String EDITION_OK = "La mise à jour du profil a été réalisé."
    final String EDITION_NOK = "Mise à jour du profil impossible."
    final String PROFIL_NOK = "<img src='http://www.oyez-perigord.fr/Oyez_Perigord/de_linsolite_au_rigolo/Entrees/2014/8/1_Johnny_Depp,_cest_lui_files/shapeimage_3.png' /><h3>Le membre n'existe pas</h3>"


    def membreService

    @Override
    def index() {
        render view: "index"
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

        Membre membre = membreService.connexionMembre(mail, mdp)

        if (membre == null) {
            render(view: "index", model: [erreur: CONNEXION_NOK])
        } else {
            session.setAttribute("user", membre)
            redirect(action: "profil", id: membre.getId())
        }
    }

    def deconnexion() {
        session.removeAttribute("user")
        session.removeAttribute("mail")
        redirect action: "index"
    }

    def actus() {
        render(view: "actus")
    }

    def profil() {
        Membre membre = membreService.getMembre(Integer.parseInt(params.get("id")))

        if(membre != null)
            render(view: "profil", model: [membre:membre])
        else
            render(layout: "main", text: PROFIL_NOK)
    }

    def edit() {
        render(view: "edit")
    }

    def edition() {
        if (params.isSosie)
            params.isSosie = params.boolean("isSosie")

        String validationEdition;
        if (membreService.editionMembre(session.getAttribute("user"), params)) {
            session.setAttribute("user", membreService.getMembre(session.getAttribute("user").id));
            validationEdition = EDITION_OK;
        } else {
            validationEdition = EDITION_NOK;
        }

        flash.message = validationEdition
        redirect(action: "profil", id: session.getAttribute("user").getId(), params:[validation:validationEdition])
    }
}
