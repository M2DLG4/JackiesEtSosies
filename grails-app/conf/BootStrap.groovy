import jackiesetsosies.Membre
import jackiesetsosies.Star

class BootStrap {

    def init = { servletContext ->
        Star star1 = new Star(prenom: "Johnny", nom:"Hallyday", urlPhoto:"http://blog.stadefrance.com/wp-content/uploads/2014/06/Johnny.jpeg").save()
        Star star2 = new Star(prenom: "Pap", nom:"François", urlPhoto:"http://www.la-croix.com/var/bayard/storage/images/lacroix/religion/actualite/le-cardinal-jorge-mario-bergoglio-est-le-pape-francois-_ng_-2013-03-13-920733/30146632-9-fre-FR/Le-cardinal-Jorge-Mario-Bergoglio-est-le-pape-Francois_article_main.jpg").save()

        Membre membre1 = new Membre(prenom: "Patrice", nom:"Perdu", mail: "pat.perdu@wanadoo.net", mdp: "1234", ville:"Chalon-Sur-Saulnes", sexe:"H", urlPhoto:"http://www.cesam-international.com/_upload/ressources/photos/patrick_bruel__jerome/jeromebruel.jpg", isSosie: true, idStar: star1.id).save()
        Membre membre2 = new Membre(prenom: "Carl", nom:"Raté", mail: "carlo.el.bandito@laposte.net", mdp: "1234", ville:"Champagne-Sur-Ardennes", sexe:"H", urlPhoto:"http://img1.gtsstatic.com/insolite/le-sosie-de-gerard-depardieu-fredo-de-belgique-en-photo-dans-une-soiree_114289_w620.jpg", isSosie: true, idStar: star2.id).save()
        Membre membre3 = new Membre(prenom: "Jeanne", nom:"Python", mail: "jeannie.python@sfr.fr", mdp: "1234", ville:"EncSeine St Denis", sexe:"F", urlPhoto:"http://www.sequence4.com/wp-content/uploads/2015/04/karine-portrait-inconnu-du-jour-paris-940x623.jpg", isSosie: false).save()
        Membre membre4 = new Membre(prenom: "Jean", nom:"Albert", mail: "jean.albert@gmail.com", mdp: "1234", ville:"Berlin Est", sexe:"F", urlPhoto:"http://photos1.tf1.fr/260/346/melanie-secret-story-9-b53b89-1@1x.jpg", isSosie: false).save()
        Membre membre5 = new Membre(prenom: "Patrick", nom:"Jeannon", mail: "patrick.jeannon@monster.fr", mdp: "1234", ville:"Ordure sur mer", sexe:"H", urlPhoto:"http://photos1.tf1.fr/260/346/karisma-secret-story-9-2-80e787-1@1x.jpg", isSosie: false).save()
        Membre membre6 = new Membre(prenom: "Dark", nom:"Vador", mail: "dark@vador.fr", mdp: "1234", ville:"Planette Noire", sexe:"H", urlPhoto:"http://a403.idata.over-blog.com/300x295/0/01/23/60/2012/dark-vador-essuie-ton-pere-star-wars-rouleau-essuie-ton-per.jpg", isSosie: true, idStar: star2.id).save()
    }
    def destroy = {
    }
}
