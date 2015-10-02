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
}
