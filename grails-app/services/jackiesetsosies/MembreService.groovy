package jackiesetsosies

class MembreService {

    def membreDAOService

    Membre inscriptionMembre(Membre membre) {
        return membreDAOService.addMembre(membre);
    }

    Membre addPostToMembre(Membre membreSession, Post newPost) {
        Membre membre = membreDAOService.searchMembre(membreSession.id)

        return membreDAOService.addPost(membreSession, membre, newPost);
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
