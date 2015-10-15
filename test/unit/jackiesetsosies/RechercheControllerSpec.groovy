package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RechercheController)
class RechercheControllerSpec extends Specification {
    void setup() {
        controller.rechercheService = Mock(RechercheService)
    }

    void "appel du controlleur de recherche des membres"() {
        when: "on se connecte au site"
        params.text = "JEANNNES !"
        def membreList = new ArrayList<Membre>();
        membreList.add(Mock(Membre));
        controller.rechercheService.getMembres(_) >> membreList
        controller.index()

        then: "la vue est index"
        view.equals("/recherche/result")
    }
}
