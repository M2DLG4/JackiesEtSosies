package jackiesetsosies

class RechercheController {

    def rechercheService

    def index() {
        def resultatRecherche = rechercheService.getMembres(params.text);
        render(view: "result", model: [resultatRecherche:resultatRecherche])
    }
}
