package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(PostController)
class PostControllerSpec extends Specification {

    void setup() {
        //controller.membreService = Mock(MembreService)
        controller.postService = Mock(PostService)
    }

    void "test sharedPost avec un post valide"() {
        given: "un message"
        params.message = "le message"


        and: "un membre connecté"
        controller.postService.addPostToMembre(_, _) >> Mock(Membre)

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        flash.message == "OK"
        response.redirectedUrl == "/wall/news"
    }

    void "test sharedPost avec un post pas valide"() {
        given: "un message vide"
        params.message = ""

        and: "un membre connecté"
        controller.postService.addPostToMembre(_, _) >> null

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        flash.message == "NOK"
        response.redirectedUrl == "/wall/news"
    }
}
