package jackiesetsosies

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class PostSpec extends Specification {

    void "test un post est valide"() {
        given: "Un post avec un message, une date et un membre en paramètre"
        Post post = new Post(message: "le message", date: new Date(), membre: Mock(Membre))

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
        message       | date       | membre
        ""            | new Date() | Mock(Membre)
        null          | new Date() | Mock(Membre)
        "le message"  | null       | Mock(Membre)
        "le message"  | new Date() | null
    }

    void "test toString"() {
        given: "Un post avec un message, une date et un membre en paramètre"
        String message = "le message"
        Date date = new Date()
        Membre membre = Mock(Membre)
        Post post = new Post(message: message, date: date, membre: membre)

        when: "on valide le post"
        def toString = post.toString()

        then: "le post n'est pas valide"
        toString == "Post{" +
                " date=" + date +
                ", message='" + message + '\'' +
                ", nbLikes=" + "0" +
                ", membre=" + membre.getNom() + " " + membre.getPrenom() +
                '}'
    }

    @Unroll
    void "test equals"() {
        given:"Deux posts"
        def post1 = new Post(id:1, message: _, membre: _, date:_);
        def post2 = new Post(id:2, message: _, membre: _, date:_);

        when:"on cherche à savoir si post1 et post2 sont les m�mes"
        def isEquals = post1.equals(post2)

        then:"ils sont les m�mes"
        isEquals
    }
    
}
