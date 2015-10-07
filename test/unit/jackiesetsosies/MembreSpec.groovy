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

    @Unroll
    void "test toString"() {
        given:"un Mock star et un membre avec un nom, prenom, mail, mdp, sexe, ville, isSosie, urlPhoto"
        def star = Mock(Star)
        def membre = new Membre(nom: "Halliday", prenom: "Johnny", mail: "john.hal@hal.fr", mdp: "aze",
                                sexe: "M", ville: "Paris", isSosie: false, urlPhoto: "john.jpg", idStar: star);

        when:"on affiche le membre"
        def toString = membre.toString()

        then:"le resultat affiché est le bon"
        toString=="Membre{" +
                "nom='" + "Halliday" + '\'' +
                ", prenom='" + "Johnny" + '\'' +
                ", mail='" + "john.hal@hal.fr" + '\'' +
                ", mdp='" + "aze" + '\'' +
                ", ville='" + "Paris" + '\'' +
                ", sexe='" + "M" + '\'' +
                ", isSosie=" + "false" +
                ", idStar=" + star.toString() +
                ", urlPhoto='" + "john.jpg" + '\'' +
                '}';
    }

    @Unroll
    void "test equals"() {
        given:"Deux membres avec la même adresse mail"
        def membre1 = new Membre(nom: _, prenom: _, mail: "john.hal@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);
        def membre2 = new Membre(nom: _, prenom: _, mail: "john.hal@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);
        def membre3 = new Membre(nom: _, prenom: _, mail: "john@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);

        when:"on cherche à savoir si membre1 et membre2 sont les mêmes"
        def isEquals = membre1.equals(membre2)

        then:"ils sont les mêmes"
        isEquals

        when:"on cherche à savoir si membre1 est égal à lui-même"
        isEquals = membre1.equals(membre1)

        then:"il est égal à lui-même"
        isEquals

        when:"on cherche à savoir si membre1 et membre3 sont les mêmes"
        isEquals = membre1.equals(membre3)

        then:"ils ne sont pas les mêmes"
        !isEquals

        when:"on cherche à savoir si membre1 et une instance d'autre classe sont les mêmes"
        isEquals = membre1.equals(Mock(Star))

        then:"ils ne sont pas les mêmes"
        !isEquals
    }

    @Unroll
    void "test hashCode"() {
        given:"Deux membres avec la même adresse mail et un autre avec une adresse mail différente"
        def membre1 = new Membre(nom: _, prenom: _, mail: "john.hal@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);
        def membre2 = new Membre(nom: _, prenom: _, mail: "john.hal@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);
        def membre3 = new Membre(nom: _, prenom: _, mail: "john@hal.fr", mdp: _,
                sexe: _, ville: _, isSosie: _,);

        when:"on cherche à savoir si membre1 et membre2 ont le même HashCode"
        def sameHashCode = (membre1.hashCode() == membre2.hashCode())

        then:"ils sont les mêmes"
        sameHashCode

        when:"on cherche à savoir si membre1 et membre3 ont le même HashCode"
        sameHashCode = (membre1.hashCode() == membre3.hashCode())

        then:"ils ne sont pas les mêmes"
        !sameHashCode
    }
}
