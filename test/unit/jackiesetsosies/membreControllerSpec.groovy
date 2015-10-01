package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Created by Elliot on 01/10/2015.
 */
@TestFor(MembreController)
class MembreControllerSpec extends Specification {

    void "test une inscription valide"() {
        given: "Une demande d'inscription avec toutes les informations"
        params.put("nom", nom);
        params.put("prenom", prenom);
        params.put("ville", ville);
        params.put("sexe", sexe);
        params.put("isSosie", isSosie);
        params.put("mail", mail);
        params.put("mdp", mdp);

        when: "on inscrit le membre"
        def validation = MembreController.inscription()

        then: "L'inscription est validée"
        model.validation.equals("Inscription terminée ! Vous pouvez maintenant vous connecter.")

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | "true"
        "Jacky" | "Bernadette"| "bernadette.jacky@gmail.com" | "JohnnyLeBest" | "F"  | "Toulouse" | "false"
    }
}
