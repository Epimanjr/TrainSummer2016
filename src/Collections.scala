
object Collections {
  
  /**
   * Méthode principale.
   */
  def main(args: Array[String]): Unit = {
    // Opérations arithmétiques
    arithmeticOperations()
    
    // Mapping operations
    mappingOperations()
  }
  
  /**
   * Opérations arithmétiques : 
   * 	1°) ::
   * 	2°) :::
   * 	3°) ++
   * 	4°) ==
   * 	5°) distinct
   * 	6°) drop
   * 	7°) filter
   * 	8°) flatten
   * 	9°) partition
   * 	10°) reverse
   * 	11°) slide
   * 	12°) sortBy
   * 	13°) sorted
   * 	14°) splitAt
   * 	15°) take
   * 	16°) zip
   */
  def arithmeticOperations(): Unit = {
    println("Operations arithmétiques : ")
    println("---------------------------")
    
    // Création d'une liste avec ::
    println("1°)\t" + (1 :: 2 :: 3 :: Nil))
    
    // Concaténation de deux listes
    println("2°)\t" + (List(1, 2) ::: List(2, 3)))
    
    // Ajoute une nouvelle collection à une liste
    println("3°)\t" + (List(1, 2) ++ Set(3, 4, 3))) // Rappel : Set est une collection qui supprime automatiquement les doublons
    
    // Test de l'égalité entre deux listes
    println("4°)\t" + (List(1, 2) == List(1, 2)))
    
    // Supression des doublons d'une liste
    println("5°)\t" + (List(3, 5, 4, 3, 4).distinct))
    
    // Supprime les deux premiers éléments d'une liste
    println("6°)\t" + (List('a', 'b', 'c', 'd', 'e') drop 2))
    
    // Filtrage d'une liste à partir d'une fonction booléenne
    println("7°)\t" + (List(23, 8, 14, 21) filter (_ > 18)))
    
    // Convertion d'une "liste de liste" en une grande liste simple
    println("8°)\t" + (List(List(1, 2), List(3, 4)).flatten))
    
    // Créer deux partitions à partir d'une fonction booléenne
    println("9°)\t" + (List(1, 2, 3, 4, 5) partition (_ < 3)))
    
    // Inverse la liste
    println("10°)\t" + (List(1, 2, 3).reverse))
    
    // Récupère une séquence de la liste
    println("11°)\t" + (List(2, 3, 5, 7) slice (1, 3)))
    
    // Trie la liste à partir d'une fonction
    println("12°)\t" + (List("apple", "to") sortBy (_.size)))
    
    // Trie la liste naturellement (généralement par ordre alphabétique ou numérique)
    println("13°)\t" + (List("apple", "to").sorted))
    
    // Regroupe les éléments en deux liste (avant et après l'index)
    println("14°)\t" + (List(2, 3, 5, 7) splitAt 2))
    
    // Extrait les trois premiers éléments de la liste
    println("15°)\t" + (List(2, 3, 5, 7, 11, 13) take 3))
    
    // Combinaison des deux listes
    println("16°)\t" + (List(1, 2) zip List("a", "b")))
  }
  
  /**
   * Mapping operations : 
   * 	1°) collect
   * 	2°) flatMap
   * 	3°) map
   */
  def mappingOperations(): Unit = {
    println("Mapping Operations : ")
    println("---------------------")

    // Récupère la liste à partir d'une fonction partielle
    println("1°)\t" + (List(0, 1, 0) collect {case 1 => "ok"}))
    
    // 
    println("2°)\t" + (List("milk,tea") flatMap (_.split(','))))
    
    // Transforme chaque élément à partir d'une fonction donnée
    println("3°)\t" + (List("milk", "tea") map (_.toUpperCase)))
  }
  
}