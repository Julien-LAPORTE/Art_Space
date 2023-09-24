package fr.samneo.artspace

class ArtBank(id: Int) {
    private var id = id
    val maxId: Int
    var title: String? = null
    var author: String? = null
    var year: Int? = null
    var description: String? = null

    init {
        maxId = 7 // Modifier si ajoute des id dans attributeInit
        attributesInit()
    }

    private fun attributesInit() {
        when (id) {
            1 -> {
                title = "Au marché flottant"
                author = "Le Diascorn, François\n(né en 1947)"
                year = 1985
                description =
                    "Tirage photographique\n" + "Localisation: Thaïlande\n" + "Tirage noir et blanc ; Gélatino-argentique\n" + "Format du tirage: 18x24 cm"
            }

            2 -> {
                title = "Au marché flottant"
                author = "Le Diascorn, François\n(né en 1947)"
                year = 1980
                description =
                    "Tirage photographique\n" + "Localisation: Thaïlande, Province de Ratchaburi, Damnoen Saduak\n" + "Tirage noir et blanc ; Gélatino-argentique\n" + "Format du tirage: 18x24 cm"
            }

            3 -> {
                title = "Au marché flottant"
                author = "Le Diascorn, François\n(né en 1947)"
                year = 1985
                description =
                    "Tirage photographique\n" + "Localisation: Thaïlande, Province de Ratchaburi, Damnoen Saduak\n" + "Tirage noir et blanc ; Gélatino-argentique\n" + "Format du tirage: 18x24 cm"
            }

            4 -> {
                title = "Tuile thaï estampillé"
                author = "Tuile donnée par\nMme Anne-Marie Negre"
                year = 1989
                description =
                    "Élément d’architecture ; tuile\n" + "Localisation: Thaïlande ; 00 ; Bangkok ; Maison\n" + "Matériaux et techniques d'interventions: Terre cuite ; vernis\n" + "Dimensions normalisées: 26,6x12,5x2,6"
            }

            5 -> {
                title = "Architecture asiatique"
                author = "(André Malraux?)"
                year = 1931
                description =
                    "Négatif\n" + "Édifice: Temple Wat Pho\n" + "Localisation: Thaïlande, Province de Bangkok, Bangkok\n" + "Support pellicule ; Négatif noir et blanc ; cratère ; tache\n" + "Format du négatif: 8 x 11\n" + "Il est possible que cette photographie ait été prise lors d'un voyage d'André Malraux en Asie au cours des années 1920 ; Ancienne Indochine"
            }

            6 -> {
                title = "Intérieur de la cour"
                author = "Parry, Roger\n(1905-1977)"
                year = 1930
                description =
                    "Négatif\n" + "Édifice: Temple Wat Pho\n" + "Localisation: Thaïlande, Province de Bangkok, Bangkok\n" + "Support pellicule ; Négatif noir et blanc ; cratère ; tache\n" + "Format du négatif: 8 x 11"
            }

            7 -> {
                title = "Moines à l'ombrelle"
                author = "Le Diascorn, François\n(né en 1947)"
                year = 1985
                description =
                    "Tirage photographique\n" + "Localisation: Thaïlande, Province de Chiang Mai, Chiang Mai\n" + "Tirage noir et blanc ; Gélatino-argentique\n" + "Format du tirage: 18x24 cm"
            }
        }
    }
    fun nextArt(){
        this.id++
        attributesInit()
    }
    fun previousArt(){
        this.id--
        attributesInit()
    }
    fun selectArt(id: Int){
        this.id = id
        attributesInit()
    }
}