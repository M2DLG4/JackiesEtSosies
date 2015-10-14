package jackiesetsosies

class WallController {

    def user
    def posts

    def news() {
        getPosts()
        render(view: "news", model: [posts: posts])
    }

    def getPosts() {
        user = Membre.findByMail("lodo@gmail.com")
        if (user == null)
            user = new Membre(nom: "lodo", prenom: "bene", ville: "toulouse", sexe: "F", isSosie: false, mail: "lodo@gmail.com", mdp: "lodo")
        if (user.getPosts() != null)
            posts = user.getPosts()
    }

}
