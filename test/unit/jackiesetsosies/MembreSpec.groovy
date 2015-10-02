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
                ville:ville, isSosie: isSosie, idStar: Mock(Star), urlPhoto: urlPhoto)

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre est valide"
        isValid

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville      | isSosie | urlPhoto
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true    | "machin.png"
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | true    | null
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | false   | "machin.png"
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse" | false   | null
    }

    void "test un membre valide sans isSosie"() {
        given: "Un membre avec un nom, prenom, mail, mdp, sexe, ville, photo en parametre"
        Membre member = new Membre(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville, idStar: Mock(Star))

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre est valide"
        isValid

        where: "avec le jeu de donnees suivant"
        nom     | prenom      | mail                         | mdp            | sexe | ville
        "Jacky" | "Pierre"    | "pierre.jacky@gmail.com"     | "JohnnyLeBest" | "H"  | "Toulouse"
    }

    @Unroll
    void "test un membre invalide"() {
        given: "Un membre avec un nom, prenom, mail, mdp, sexe, ville, estUnSosie, une Star en parametre et une photo par défaut"
        Membre member = new Membre(nom: nom, prenom: prenom, mail: mail, mdp: mdp, sexe: sexe,
                ville:ville)

        when: "on valide le membre"
        def isValid = member.validate()

        then: "le membre n'est pas valide"
        !isValid

        where: "avec le jeu de donnees suivant"
        nom     | prenom   | mail                     | mdp            | sexe | ville
        ""      | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse"
        null    | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse"
        "Jacky" | ""       | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse"
        "Jacky" | null     | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | "Toulouse"
        "Jacky" | "Pierre" | ""                       | "JohnnyLeBest" | "H"  | "Toulouse"
        "Jacky" | "Pierre" | null                     | "JohnnyLeBest" | "H"  | "Toulouse"
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | ""             | "H"  | "Toulouse"
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | null           | "H"  | "Toulouse"
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "-"  | "Toulouse"
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | null | "Toulouse"
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | ""
        "Jacky" | "Pierre" | "pierre.jacky@gmail.com" | "JohnnyLeBest" | "H"  | null
    }
}
