package jackiesetsosies

class MembreService {

    def membreDAOService

    Membre inscriptionMembre(Membre membre) {
        return membreDAOService.addMembre(membre);
    }

    Membre getMembre(String mail, String mdp) {
        Membre m = membreDAOService.searchMembre(mail)

        if (m?.mdp.equals(mdp)) {
            return m
        } else {
            return null
        }
    }

    Boolean editionMembre(Membre membre, Map params) {
        return false;
    }
}
