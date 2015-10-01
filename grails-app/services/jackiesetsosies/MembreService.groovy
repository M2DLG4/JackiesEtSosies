package jackiesetsosies

import grails.transaction.Transactional

class MembreService {

    def membreDAOService

    def serviceMethod() {

    }

    Membre inscriptionMembre(Membre membre) {
        return membreDAOService.addMembre(membre);
    }

    Membre connexionMembre(String mail, String mdp) {
        Membre m = membreDAOService.searchMembre(mail)

        if (m) {
            if (m.mdp.equals(mdp)) {
                return m
            }
        } else {
            return null
        }
    }
}
