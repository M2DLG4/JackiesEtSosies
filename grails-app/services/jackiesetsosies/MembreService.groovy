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
                    membre.setMdp(val);
                    break;
                case "ville":
                    membre.setVille(val);
                    break;
                case "sexe":
                    membre.setSexe(val);
                    break;
                case "isSosie":
                    membre.setIsSosie(val);
                    break;
                case "urlPhoto":
                    membre.setUrlPhoto(val);
                    break;
            }
        }
        membreDAOService.editerMembre(membre);

        return ! membre.hasErrors();
    }
}
