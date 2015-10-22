import jackiesetsosies.Membre
import jackiesetsosies.Star
import jackiesetsosies.Post
import jackiesetsosies.SuivreMembre

class BootStrap {

    def init = { servletContext ->
        Star star1 = new Star(prenom: "Johnny", nom:"Hallyday", urlPhoto:"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Johnny_Hallyday_NRJ_Music_Awards_2012.jpg/220px-Johnny_Hallyday_NRJ_Music_Awards_2012.jpg").save()
        Star star2 = new Star(prenom: "Pape", nom:"François", urlPhoto:"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Pope_Francis_South_Korea_2014.png/280px-Pope_Francis_South_Korea_2014.png").save()
        Star star3 = new Star(prenom: "Patrick", nom:"Bruel", urlPhoto:"https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Patrick_Bruel_Cabourg_2012.jpg/220px-Patrick_Bruel_Cabourg_2012.jpg").save()
        Star star4 = new Star(prenom: "Gérard", nom:"Depardieu", urlPhoto:"https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/G%C3%A9rard_Depardieu_Cannes_2010.jpg/220px-G%C3%A9rard_Depardieu_Cannes_2010.jpg").save()

        Membre membre1 = new Membre(prenom: "Patrice", nom:"Perdu", mail: "pat.perdu@wanadoo.net", mdp: "1234", ville:"Chalon-Sur-Saulnes", sexe:"H", urlPhoto:"http://www.cesam-international.com/_upload/ressources/photos/patrick_bruel__jerome/jeromebruel.jpg", isSosie: true, idStar: star3.id).save()
        Membre membre2 = new Membre(prenom: "Carl", nom:"Raté", mail: "carlo.el.bandito@laposte.net", mdp: "1234", ville:"Champagne-Sur-Ardennes", sexe:"H", urlPhoto:"http://img1.gtsstatic.com/insolite/le-sosie-de-gerard-depardieu-fredo-de-belgique-en-photo-dans-une-soiree_114289_w620.jpg", isSosie: true, idStar: star4.id).save()
        Membre membre3 = new Membre(prenom: "Jeanne", nom:"Python", mail: "jeannie.python@sfr.fr", mdp: "1234", ville:"Seine St Denis", sexe:"F", urlPhoto:"http://www.sequence4.com/wp-content/uploads/2015/04/karine-portrait-inconnu-du-jour-paris-940x623.jpg", isSosie: false).save()
        Membre membre4 = new Membre(prenom: "Jean", nom:"Albert", mail: "jean.albert@gmail.com", mdp: "1234", ville:"Berlin Est", sexe:"F", urlPhoto:"http://photos1.tf1.fr/260/346/melanie-secret-story-9-b53b89-1@1x.jpg", isSosie: false).save()
        Membre membre5 = new Membre(prenom: "Patrick", nom:"Jeannon", mail: "patrick.jeannon@monster.fr", mdp: "1234", ville:"Ordure sur mer", sexe:"H", urlPhoto:"http://photos1.tf1.fr/260/346/karisma-secret-story-9-2-80e787-1@1x.jpg", isSosie: false).save()
        Membre membre6 = new Membre(prenom: "Dark", nom:"Vador", mail: "dark@vador.fr", mdp: "1234", ville:"Planette Noire", sexe:"H", urlPhoto:"http://a403.idata.over-blog.com/300x295/0/01/23/60/2012/dark-vador-essuie-ton-pere-star-wars-rouleau-essuie-ton-per.jpg", isSosie: true, idStar: star2.id).save()

        Post post1 = new Post(date: new Date(), message: "Qui a le droit ?", nbLikes: 0, membre: membre1).save()
        Post post2 = new Post(date: new Date(), message: "Moi aussi un jour je serais vigneron comme le Grand Gérard ! J'espère avoir mon passeport russe aussi.", nbLikes: 0, membre: membre2).save()
        Post post3 = new Post(date: new Date(), message: "Merci pour vos messages à propos de mon concert d'hier ! Que Dieu vous bénisse tous.", nbLikes: 0, membre: membre1).save()
        Post post4 = new Post(date: new Date(), message: "Les sosies sont les vrais artistes d'aujourd'hui. Merci Jackie&Sosies.", nbLikes: 0, membre: membre3).save()
        Post post5 = new Post(date: new Date(), message: "Comme le dis François, que la foi soit avec toi.", nbLikes: 0, membre: membre6).save()

        SuivreMembre sm1 = new SuivreMembre(membre: membre3, membreSuivi: membre1).save()
        SuivreMembre sm2 = new SuivreMembre(membre: membre3, membreSuivi: membre2).save()
        SuivreMembre sm3 = new SuivreMembre(membre: membre6, membreSuivi: membre2).save()
        SuivreMembre sm4 = new SuivreMembre(membre: membre6, membreSuivi: membre3).save()
        SuivreMembre sm5 = new SuivreMembre(membre: membre2, membreSuivi: membre1).save()
        SuivreMembre sm6 = new SuivreMembre(membre: membre2, membreSuivi: membre6).save()
        SuivreMembre sm7 = new SuivreMembre(membre: membre1, membreSuivi: membre3).save()
        SuivreMembre sm8 = new SuivreMembre(membre: membre1, membreSuivi: membre6).save()
        SuivreMembre sm9 = new SuivreMembre(membre: membre1, membreSuivi: membre2).save()
    }
    def destroy = {
    }
}
