import jackiesetsosies.Membre

class BootStrap {

    def init = { servletContext ->
        Membre membre1 = new Membre(prenom: "Patrice", nom:"Perdu", mail: "pat.perdu@wanadoo.net", mdp: "1234", ville:"Chalon-Sur-Saulnes", sexe:"H", urlPhoto:"http://www.cesam-international.com/_upload/ressources/photos/patrick_bruel__jerome/jeromebruel.jpg", isSosie: true).save()
        Membre membre2 = new Membre(prenom: "Carl", nom:"Raté", mail: "carlo.el.bandito@laposte.net", mdp: "1234", ville:"Champagne-Sur-Ardennes", sexe:"H", urlPhoto:"http://img1.gtsstatic.com/insolite/le-sosie-de-gerard-depardieu-fredo-de-belgique-en-photo-dans-une-soiree_114289_w620.jpg", isSosie: true).save()
        Membre membre3 = new Membre(prenom: "Jeanne", nom:"Python", mail: "jeannie.python@sfr.fr", mdp: "1234", ville:"Seine St Denis", sexe:"F", urlPhoto:"http://www.sequence4.com/wp-content/uploads/2015/04/karine-portrait-inconnu-du-jour-paris-940x623.jpg", isSosie: false).save()
    }
    def destroy = {
    }
}
