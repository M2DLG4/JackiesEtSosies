package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(PostController)
class PostControllerSpec extends Specification {

    void setup() {
        controller.membreService = Mock(MembreService)
    }

    void "test redirection post"() {
        when: "on execute news"
        controller.post()

        then: "la vue est news"
        view.equals("/post/post")
    }

    void "test sharedPost avec un post valide"() {
        given: "un message"
        params.message >> "le message"

        and: "un membre connecté"
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre
        Post post = Mock(Post)
        post.hasErrors() >> false
        post.validate() >> true
        membre.getPosts() >> post

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        response.redirectedUrl == "/wall/news"
    }

    void "test sharedPost avec un post pas valide"() {
        given: "un message vide"
        params.message >> ""

        and: "un membre connecté"
        Membre membre = Mock(Membre)
        session.getAttribute("user") >> membre
        Post post = Mock(Post)
        post.hasErrors() >> false
        post.validate() >> true
        membre.getPosts() >> []

        when: "on execute sharedPost"
        controller.sharedPost()

        then: "on est redirigé vers la vue"
        response.redirectedUrl == "/wall/news"
    }
}
