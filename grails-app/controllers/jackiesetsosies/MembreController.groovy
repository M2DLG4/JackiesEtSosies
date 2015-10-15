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
    final String DECONNEXION_OK = "Vous avez été déconnecté avec succès."
    final String SUPRESSION_OK = "Votre compte a été supprimé avec succès."


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

        Membre membreinscrit = membreService.inscriptionMembre(membre)

        if (membreinscrit != null && !membreinscrit.hasErrors()) {
            flash.message = INSCRIPTION_OK
        } else {
            flash.error = INSCRIPTION_NOK
        }

        render(view: "index")
    }

    def connexion() {
        def mail = params.mail
        def mdp = params.mdp

        Membre membre = membreService.connexionMembre(mail, mdp)

        if (membre == null) {
            render(view: "index")
            flash.error = CONNEXION_NOK
        } else {
            flash.message = CONNEXION_OK
            session.setAttribute("user", membre)
            redirect(action: "profil", id: membre.getId())
        }
    }

    def deconnexion() {
        session.removeAttribute("user")
        session.removeAttribute("mail")
        redirect action: "index"
        flash.message = DECONNEXION_OK
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
        else
            params.isSosie = false

        if (membreService.editionMembre(session.getAttribute("user"), params)) {
            session.setAttribute("user", membreService.getMembre(session.getAttribute("user").id));
            flash.message = EDITION_OK
        } else {
            flash.error = EDITION_NOK
        }

        redirect(action: "profil", id: session.getAttribute("user").getId())
    }

    def suppression() {
        membreService.supprimerMembre(membreService.getMembre(session.getAttribute("user").id))
        session.removeAttribute("user")
        session.removeAttribute("mail")
        redirect action: "index"
        flash.message = SUPRESSION_OK
    }
}
