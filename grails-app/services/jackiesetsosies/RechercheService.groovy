package jackiesetsosies

class RechercheService {

    def membreDAOService

    List<Membre> getMembres(String texte) {
        return membreDAOService.searchMembreByTexte(texte);
    }

}
