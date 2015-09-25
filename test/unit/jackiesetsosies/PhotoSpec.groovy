package jackiesetsosies

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class PhotoSpec extends Specification {

    @Unroll
    void "test une photo valide"() {
        given: "une photo avec une url non vide"
        Photo photo = new Photo(urlPhoto: "http://google.com")

        when: "on valide la photo"
        def isValid = photo.validate()

        then: "la photo est valide"
        isValid == true
    }

    @Unroll
    void "test une photo invalide"() {
        given: "une photo avec une url vide"
        Photo photo = new Photo(urlPhoto: "")

        when: "on valide la photo"
        def isValid = photo.validate()

        then: "la photo n'est pas valide"
        isValid == false
    }
}