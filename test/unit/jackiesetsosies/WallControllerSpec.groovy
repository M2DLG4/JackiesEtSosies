package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(WallController)
class WallControllerSpec extends Specification {
    void setup() {
        controller.postService = Mock(PostService)
    }

    void "test redirection news"() {
        given: "un utilisateur connecté"
        controller.postService.getPosts() >> null
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre

        when: "on execute news"
        controller.news()

        then: "la vue est news"
        view.equals("/wall/news")
    }
}
