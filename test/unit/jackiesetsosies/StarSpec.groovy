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

    @Unroll
    void "test toString"() {
        given: "une star avec un prenom, nom, url en parametre"
        def nom = "Hallyday"
        def prenom = "Johnny"
        def urlPhoto = "machin.jpg"
        def star = new Star(prenom: prenom, nom: nom, urlPhoto: urlPhoto)

        when: "on affiche le toString"
        def toString = star.toString()

        then: "le résultat est bien celui attendu"
        toString == "Star{" +
                    "nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", urlPhoto='" + urlPhoto + '\'' +
                    '}'
    }

    @Unroll
    void "test equals"() {
        given: "une star avec un prenom, nom, url en parametre"
        def nom1 = "Hallyday"
        def prenom1 = "Johnny"
        def urlPhoto1 = "machin1.jpg"
        def star1 = new Star(prenom: prenom1, nom: nom1, urlPhoto: urlPhoto1)

        and: "une autre star avec un prenom, nom, url en parametre"
        def nom2 = "Sebastien"
        def prenom2 = "Patrick"
        def urlPhoto2 = "machin2.jpg"
        def star2 = new Star(prenom: prenom2, nom: nom2, urlPhoto: urlPhoto2)

        when: "on compare deux stars différentes"
        def isEquals = star1.equals(star2)

        then: "le résultat est faux"
        !isEquals

        when: "on compare les mêmes stars"
        isEquals = star1.equals(star1)

        then: "le résultat est vrai"
        isEquals

        when: "on compare la star avec une autre classe"
        isEquals = star1.equals(new Integer(42))

        then: "le résultat est faux"
        !isEquals

        when: "on compare la star avec un nom différent"
        star2.prenom = "Johnny"
        star2.nom = "aaaa"
        star2.urlPhoto = "machin1.jpg"
        isEquals = star1.equals(star2)

        then: "le résultat est faux"
        !isEquals

        when: "on compare la star avec un prenom différent"
        star2.prenom = "aaaaa"
        star2.nom = "Hallyday"
        star2.urlPhoto = "machin1.jpg"
        isEquals = star1.equals(star2)

        then: "le résultat est faux"
        !isEquals

        when: "on compare la star avec une photo différent"
        star2.prenom = "Johnny"
        star2.nom = "Hallyday"
        star2.urlPhoto = "machin2.jpg"
        isEquals = star1.equals(star2)

        then: "le résultat est faux"
        !isEquals

        when: "on compare la star avec les mêmes infos"
        star2.prenom = "Johnny"
        star2.nom = "Hallyday"
        star2.urlPhoto = "machin1.jpg"
        isEquals = star1.equals(star2)

        then: "le résultat est vrai"
        isEquals
    }

    @Unroll
    void "test hashCode"() {
        given: "une star avec un prenom, nom, url en parametre"
        def nom1 = "Hallyday"
        def prenom1 = "Johnny"
        def urlPhoto1 = "machin1.jpg"
        def star1 = new Star(prenom: prenom1, nom: nom1, urlPhoto: urlPhoto1)

        and: "une autre star avec un prenom, nom, url en parametre"
        def nom2 = "Sebastien"
        def prenom2 = "Patrick"
        def urlPhoto2 = "machin2.jpg"
        def star2 = new Star(prenom: prenom2, nom: nom2, urlPhoto: urlPhoto2)

        when: "on calcule le hashCode de deux stars différentes"
        def hashCodeStar1 = star1.hashCode()
        def hashCodeStar2 = star2.hashCode()

        then: "le hashCode est différent"
        hashCodeStar1 != hashCodeStar2

        when: "on calcule le hashCode de la même star"
        def hashCodeStar11 = star1.hashCode()
        def hashCodeStar12 = star1.hashCode()

        then: "le hashCode est le même"
        hashCodeStar11 == hashCodeStar12
    }
}
