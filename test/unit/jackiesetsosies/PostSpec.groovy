package jackiesetsosies

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class PostSpec extends Specification {

    void "test un post est valide"() {
        given: "Un post avec un message, une date et un membre en paramètre"
        Post post = new Post(message: "le message", date: new Date(2015, 10, 10), membre: Mock(Membre))

        when: "on valide le post"
        def isValid = post.validate()

        then: "le post est valide"
        isValid
    }

    void "test un post n'est pas valide"() {
        given: "Un post avec un message, une date et un membre en paramètre"
        Post post = new Post(message: message, date: date, membre: membre)

        when: "on valide le post"
        def isValid = post.validate()

        then: "le post n'est pas valide"
        !isValid

        where: "avec le jeu de donnees suivant"
        message       | date                   | membre
        ""            | new Date(2015, 10, 01) | Mock(Membre)
        null          | new Date(2015, 10, 01) | Mock(Membre)
        "le message"  | null                   | Mock(Membre)
        "le message"  | new Date(2015, 10, 01) | null
    }

    void "test toString"() {
        given: "Un post avec un message, une date et un membre en paramètre"
        String message = "le message"
        Date date = new Date(2015, 10, 10)
        Membre membre = Mock(Membre)
        Post post = new Post(message: message, date: date, membre: membre)

        when: "on valide le post"
        def toString = post.toString()

        then: "le post n'est pas valide"
        toString == "Post{" +
                " date=" + date +
                ", message='" + message + '\'' +
                ", nbLikes=" + "0" +
                ", membre=" + membre +
                '}'
    }
}
