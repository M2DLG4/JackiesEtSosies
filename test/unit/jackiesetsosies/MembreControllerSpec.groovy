package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MembreController)
class MembreControllerSpec extends Specification {
    void setup() {
        controller.membreService = Mock(MembreService)
    }

    void "test une inscription valide"() {
        given: "Une demande d'inscription avec toutes les informations"
        Membre m = Mock(Membre);
        m.hasErrors () >> false
        controller.membreService.inscriptionMembre(_) >> m

        when: "on inscrit le membre"
        controller.inscription()

        then: "L'inscription est validée"
        model.validation.equals(controller.INSCRIPTION_OK)
    }

    void "test une inscription valide avec un parametre"() {
        given: "Une demande d'inscription avec toutes les informations"
        Membre m = Mock(Membre);
        m.hasErrors () >> false
        controller.membreService.inscriptionMembre(_) >> m

        when: "on inscrit le membre"
        params.isSosie = "true";
        controller.inscription()

        then: "L'inscription est validée"
        model.validation.equals(controller.INSCRIPTION_OK)
    }

    void "test une inscription invalide"() {
        given: "Une demande d'inscription avec toutes les informations"
        Membre m = Mock(Membre);
        m.hasErrors () >> true
        controller.membreService.inscriptionMembre(_) >> m

        when: "on inscrit le membre"
        controller.inscription()

        then: "L'inscription est invalidée"
        model.validation.equals(controller.INSCRIPTION_NOK)
    }

    void "test une connexion valide d'un membre"() {
        given: "Une connexion avec mail et mot de passe"
        Membre m = Mock(Membre)
        m.getId() >> 1
        controller.membreService.connexionMembre(_,_) >> m

        when: "on connecte le membre"
        controller.connexion()

        then: "La connexion est invalidée"
        response.getRedirectedUrl().equals("/membre/profil/1")
    }

    void "test une connexion non valide d'un membre"() {
        given: "Une connexion avec mail et mot de passe"
        controller.membreService.connexionMembre(_,_) >> null

        when: "on connecte le membre"
        controller.connexion()

        then: "La connexion est invalidée"
        model.erreur.equals(controller.CONNEXION_NOK)
    }

    void "test afficher la page d'actus"() {
        when: "on se connecte à la page actu"
        controller.actus()

        then: "la vue est actus"
        view.equals("/membre/actus")
    }

    void "test afficher la page de gestion de profil"() {
        given: "Une connexion avec mail et mot de passe"
        params.id = "1"
        Membre m = Mock(Membre)
        controller.membreService.getMembre(_) >> m

        when: "on se connecte à la gestion de profil"
        controller.profil()

        then: "la vue est profil"
        view.equals("/membre/profil")
    }

    void "test afficher la page d'index"() {
        when: "on se connecte au site"
        controller.index()

        then: "la vue est index"
        view.equals("/membre/index")
    }

    void "test afficher la page de modification de profil"() {
        when: "on modifie son profil"
        controller.edit()

        then: "la vue est edit"
        view.equals("/membre/edit")
    }

    void "test deconnexion membre"() {
        given: "un membre connecté"
        Membre m = Mock(Membre).save()
        m.getId() >> 1
        controller.membreService.connexionMembre(_, _) >> m
        controller.connexion()
        assert controller.session.getAttribute("user") == m

        when: "on se déconnecte"
        controller.deconnexion()

        then: "l'utilisateur n'est plus connecté"
        controller.session.getAttribute("user") == null
        controller.session.getAttribute("mail") == null
    }

    void "test consultation profil inexistant"() {
        given: "Un profil existant"
        controller.membreService.getMembre(_) >> null
        params.id = "3"

        when: "on désire afficher ce profil"
        controller.profil()

        then: "une erreur est affichée"
        controller.response.text.equals(controller.PROFIL_NOK)
    }

    void "test edition profil correct"() {
        given: "Un profil existant"
        Membre m = Mock(Membre)
        m.getId() >> 1
        session.setAttribute("user", m);
        controller.membreService.editionMembre(_,_) >> true
        controller.membreService.getMembre(_) >> m
        params.isSosie = "on"

        when: "on edite le membre"
        controller.edition()

        then: "la vue est index"
        flash.message != null
    }



    void "test edition profil incorrect"() {
        given: "Un profil existant"
        Membre m = Mock(Membre)
        session.setAttribute("user", m);
        controller.membreService.editionMembre(_,_) >> false
        params.isSosie = null

        when: "on edite le membre"
        controller.edition()

        then: "la vue est index"
        flash.message != null
    }
}
