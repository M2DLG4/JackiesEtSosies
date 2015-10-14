package jackiesetsosies

class MembreService {

    def membreDAOService

    Membre inscriptionMembre(Membre membre) {
        return membreDAOService.saveMembre(membre);
    }

    Membre connexionMembre(String mail, String mdp) {
        Membre m = membreDAOService.searchMembre(mail)

        if (m?.mdp.equals(mdp)) {
            return m
        } else {
            return null
        }
    }

    Boolean editionMembre(Membre membreSession, Map params) {
        Membre membre = membreDAOService.searchMembre(membreSession.id)

        for (String key : params.keySet()) {
            def val = params.get(key)
            switch (key) {
                case "nom":
                    membre.setNom(val);
                    break;
                case "prenom":
                    membre.setPrenom(val);
                    break;
                case "mail":
                    membre.setMail(val);
                    break;
                case "mdp":
                    if (! val.isEmpty()) {
                        membre.setMdp(val);
                    }
                    break;
                case "ville":
                    membre.setVille(val);
                    break;
                case "isSosie":
                    membre.setIsSosie(val);
                    break;
                case "urlPhoto":
                    if (! val.isEmpty()) {
                        membre.setUrlPhoto(val);
                    }
                    break;
            }
        }
        membre = membreDAOService.saveMembre(membre);

        return (membre != null && !membre?.hasErrors());
    }

    Membre getMembre(int id) {
        Membre m = membreDAOService.searchMembre(id)

        return m
    }
    Membre getMembre(long id) {
        Membre m = membreDAOService.searchMembre(id)
        return m
    }

    Boolean supprimerMembre(Membre membre) {
        return membreDAOService.supprimerMembre(membre);
    }
}
