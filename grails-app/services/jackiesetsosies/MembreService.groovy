package jackiesetsosies

class MembreService {

    def membreDAOService

    Membre inscriptionMembre(Membre membre) {
        return membreDAOService.addMembre(membre);
    }

    Membre addPostToMembre(Membre membre, Post newPost) {
        membre.addToPosts(newPost)
        return membreDAOService.update(membre);
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
