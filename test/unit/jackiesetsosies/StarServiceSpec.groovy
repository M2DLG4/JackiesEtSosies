package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(StarService)
class StarServiceSpec extends Specification {

    def setup() {
        service.starDAOService = Mock(StarDAOService)
    }

    void "test recuperer des stars inexistantes"() {
        given: "Une star"
        List<Star> maList = service.getStars();

        when: "on effectue la recherche de"
        Star res = service.getStar(1);
        Star res2 = service.getStar((Long) 1);

        then: "ces star n'existent pas"
        res == null
        res2 == null
    }
}
