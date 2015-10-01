package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MembreService)
class MembreServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test une inscription valide"() {
        def membreService
        Membre m = new Membre("nom": nom, "prenom": prenom, "ville": ville, "sexe": sexe, "isSosie": isSosie, "mail": mail, "mdp": mdp);

        given: "Une demande d'inscription avec toutes les informations"
        when: "on inscrit le membre"
        Membre res = membreService.inscriptionMembre("nom": nom, "prenom": prenom, "ville": ville, "sexe": sexe, "isSosie": isSosie, "mail": mail, "mdp": mdp);

        then: "L'inscription est validée"
        res == m

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true
        "Jacky" | "Bernadette"| "bernadette.jacky@gmail.com" | "JohnnyLeBest" | "F"  | "Toulouse" | false
    }

    void "test une inscription invalide"() {
        def membreService
        given: "Une demande d'inscription avec toutes les informations"
        Membre res = membreService.inscriptionMembre("nom": nom, "prenom": prenom, "ville": ville, "sexe": sexe, "isSosie": isSosie, "mail": mail, "mdp": mdp);

        when: "on inscrit le membre"

        then: "L'inscription est validée"
        res == null

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie
        "Jacky" | ""    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true
        "" | "Bernadette"| "bernadette.jacky@gmail.com" | "JohnnyLeBest" | "F"  | "Toulouse" | false
    }
}
