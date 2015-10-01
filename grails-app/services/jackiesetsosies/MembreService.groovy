package jackiesetsosies

import grails.transaction.Transactional

@Transactional
class MembreService {

    def serviceMethod() {

    }

    Membre inscriptionMembre(String prenom, String nom, String sexe, String mail, String ville, Boolean isSosie, String mdp) {
        Membre newMembre = new Membre(nom: nom, prenom: prenom, sexe: sexe, mail: mail, ville: ville, isSosie: isSosie, mdp: mdp)
        newMembre.save()
        return newMembre
    }

    Membre connexionMembre(String mail, String mdp) {
        def m = Membre.findByMail(mail)

        if (m) {
            if (m.mdp == mdp) {
                return m
            }
        } else {
            return null
        }
    }
}
