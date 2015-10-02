package jackiesetsosies

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class StarSpec extends Specification {

    @Unroll
    void "test une Star valide"() {
        given: "une star avec un prenom, nom, url"
        def star = new Star(prenom: "Johnny", nom: "Hallyday", urlPhoto: "machin.jpg")

        when: "on valide la star"
        def isValid = star.validate()

        then: "la star est valide"
        isValid
    }

    @Unroll
    void "test une Start invalide"() {
        given: "une star avec un prenom, nom, url en parametre"
        def star = new Star(prenom: prenom, nom: nom, urlPhoto: url)

        when: "on valide la star"
        def isValid = star.validate()

        then: "la star n'est pas valide"
        !isValid

        where: "avec le jeu de donnees suivant"
        nom        | prenom   | url
        ""         | "Johnny" | "machin.jpg"
        null       | "Johnny" | "machin.jpg"
        "Hallyday" | ""       | "machin.jpg"
        "Hallyday" | null     | "machin.jpg"
        "Hallyday" | "Johnny" | ""
        "Hallyday" | "Johnny" | null

    }
}
