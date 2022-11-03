# multi-module-app-mvvm
MultiModule project MVVM Clean
* Modules Dependency: more information: https://github.com/jraska/modules-graph-assert
  * digraph G {<br>
":ShoppingListItems" -> ":feature-listImages:presenter"
":ShoppingListItems" -> ":feature-listImages" [color=red style=bold]
":feature-listImages:presenter" -> ":feature-listImages:domain"
":feature-listImages:presenter" -> ":shared"
":feature-listImages:presenter" -> ":network"
":feature-listImages:presenter" -> ":feature-listImages:data" [color=red style=bold]
":feature-listImages:domain" -> ":network" [color=red style=bold]
":network" -> ":shared" [color=red style=bold]
":feature-listImages:data" -> ":feature-listImages:domain" [color=red style=bold]
":feature-listImages:data" -> ":network"
":feature-listImages" -> ":network"
":feature-listImages" -> ":feature-listImages:data"
":feature-listImages" -> ":feature-listImages:domain"
":feature-listImages" -> ":feature-listImages:presenter" [color=red style=bold]<br>
}
