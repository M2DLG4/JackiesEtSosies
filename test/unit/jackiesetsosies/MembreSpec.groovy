package jackiesetsosies

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Membre)
class MembreSpec extends Specification {

    @Unroll
    void "test un membre valide"() {
        given: "Un membre avec un nom, prenom, mail, mdp, sexe, ville, estUnSosie, photo en parametre"
        Membre member = new Membre(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville, isSosie: isSosie, idStar: Mock(Star), idPhoto: idPhoto)

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre est valide"
        isValid == true

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie | idPhoto
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Photo)
        "Jacky" | "Bernadette"| "bernadette.jacky@gmail.com" | "JohnnyLeBest" | "F"  | "Toulouse" | true    | null
    }

    void "test un membre valide sans isSosie"() {
        given: "Un membre avec un nom, prenom, mail, mdp, sexe, ville, photo en parametre"
        Membre member = new Membre(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville, idStar: Mock(Star), idPhoto: idPhoto)

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre est valide"
        isValid == true

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | idPhoto
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | Mock(Photo)
    }

    @Unroll
    void "test un membre invalide"() {
        given: "Un membre avec un nom, prenom, mail, mdp, sexe, ville, estUnSosie, une Star en parametre et pas de photo"
        Membre member = new Membre(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville, isSosie: isSosie, idStar: idStar, idPhoto: null)

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre n'est pas valide"
        isValid == false

        where: "avec le jeu de donnees suivant"
        nom     | prenom   | mail                     | mdp            | sexe | ville      |isSosie  | idStar
        ""      | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        null    | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | ""       | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | null     | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | ""                       | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | null                     | "JohnnyLeBest" | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | ""             | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | null           | "H"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "-"  | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | null | "Toulouse" | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | ""         | true    | Mock(Star)
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | null       | true    | Mock(Star)
    }
}
