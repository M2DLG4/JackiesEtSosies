package jackiesetsosies

class MembreService {

    def membreDAOService
    def suivreMembreDAOService
    def starDAOService

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
            boolean sosieChanged;
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
        if(params.get("isSosie")) {
            String id = params.get("star");
            if (id.equals("")) {
                membre.setIsSosie(false);
                return false;
            }
            else {
                membre.setIdStar(starDAOService.searchStar(Integer.parseInt(id)));
            }
        }
        else {
            membre.setIdStar(null);
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

    SuivreMembre addSuivreMembre(Long id0, Long id1) {
        return suivreMembreDAOService.saveSuivreMembre(new SuivreMembre(membre: getMembre(id0), membreSuivi: getMembre(id1)))
    }

    SuivreMembre removeSuivreMembre(Long id0, Long id1) {
        return suivreMembreDAOService.supprimerSuivreMembre(suivreMembreDAOService.getSuivreMembre(getMembre(id0), getMembre(id1)))
    }

    Boolean isFollowingMembre(Long id0, Long id1) {
        return suivreMembreDAOService.searchSuivreMembre(getMembre(id0), getMembre(id1))
    }
}
