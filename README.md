# SYM - Labo 1 : Introduction à Android

Auteurs : Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot

Date : 6 octobre 2019

## Réponses aux questions

### Question 1 :

Pour obtenir une application multi-langues, il suffit de créer un dossier `values` pour chaque langue supportée avec leur suffixe (`values-fr`, `values-de`, `values-it` et `values-es`). Le dossier `values` sans suffixe est sensé contenir les valeurs de la langue par défaut (anglais dans notre cas).

Si une traduction est manquante, un warning à la compilation `Missing Translation` est lancé.

### Question 2 :

Dans un premier temps, on télécharge l'icône souhaité en format `.svg`. On peut l'inclure dans notre projet en créant un `Vector Asset` dans le dossier `res`. Cela va générer un fichier `.xml` contenant notre icône dans un dossier `drawable`.

On peut ensuite l'inclure dans notre code.

Source : https://developer.android.com/studio/write/vector-asset-studio.html#running ("Importing an SVD or PSD file")

### Question 3 :

Quand on presse le bouton Back, l'application n'est plus visible, donc `onStop()` est appelé. Cette méthode n'est pas implémentée dans notre application, donc quand on la rouvre, il faut se re-loguer à nouveau car l'Activity de départ est relancée.

Il faudrait que l'état du login soit sauvegardé dans un état créé dans la méthode `onStart()`.

Dans notre application, nous avons tout implémenté dans des méthodes `onCreate()`. Ce n'est pas une bonne méthode du tout, il faudrait essayer d'implémenter chaque fonction définie dans la question 8 (voir ci-dessous).

### Question 4 : 

Pour le laboratoire, nous avons transmis l’email entrée dans l’Activity de départ à la seconde, et pour ce faire nous avons créé une variable static qui peut être accessible dans d’autres Activity. La variable reçoit la valeur que l’utilisateur entre pour se connecter (l’email). Puis nous créeons une Intent pour nous permettre de mettre la variable dedans avec la méthode putExtra.

Pour renvoyer du second à celui de départ, il faut mettre en place un TextView et un bouton. Le bouton permettra d’executé l’action et ensuite il faut créer une intent, d y insérer le résultat via la méthode putExtra. Dans l’Activity de départ, il faudra mettre en place un TextView invisible qui s’activera dès qu il recoit une réponse du seconde Activity.

### Question 5 :

On peut tester la version du SDK utilisé et exécuter une fonction différente selon sa valeur, comme suit :

``` Java

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String imei = telephonyMgr.getImei();
} else {
            String imei = telephonyMgr.getDeviceId();
}
```

Source : https://stackoverflow.com/questions/46744104/tm-getdeviceid-is-deprecated#46744134

### Question 6 :

On rajoute un layout spécifique à l'orientation paysage via le bouton de gestion des layouts dans l'IDE:

Preview -> orientation for preview (O) -> Create Landscape Variation

Android studio va créer ainsi toutes les composantes du nouveau layout en se basant de la version originelle en portrait, qu'on peut donc modifier afin de créer une page plus plaisante et adaptée à la vision en paysage.

### Question 7 :

Avec l'onglet de gestion des layouts, on effectue une conversion de Linearlayout -> RelativeLayout. Enfin, afin de rajouter les notions d'ordre vertical qui maitenant ne sont plus gerées par le layout parent, on indique via la commande
```
android:layout_below="@+id/XXXXXXX"
```
les différents niveaux de hiérarchie des différents éléments.

### Question 8 :

Nous avons implémenté les méthodes ci-dessous dans notre application en overridant simplement les méthodes de base, afin de tracer le parcours de l'application via des logs. En observant le résultat lorsqu'on utilise l'application, nous pouvons nous rendre compte que cela concorde bien avec le diagramme établi au 3e point de cette question.

Pour ne pas implémenter 2 fois les mêmes méthodes, nous pouvons réaliser une classe mère qui les implémenterait avec un comportement général à adopter pour l'Activiy. Ainsi, il faudrait simplement que les Activity souhaitées héritent de cette classe.

### Brève explication des méthodes :

`onCreate()` : sert à initialiser notre Activity

`onStart()` : sert à rendre visible l'Activity

`onStop()` : sert à masquer l'Activity (par exemple une autre vient devant celle-ci)

`onRestart()` : sert à redémarrer l'Activity (`onStart()` est appelé juste après)

`onPause()` : sert à suspendre les interactions avec l'Activity

`onResume()` : sert à démarrer les interactions de l'Activity avec l'utilisateur

`onDestroy()` : sert à finir l'Activity (l'éteindre)

### Enchaînement :

Lancement de l'Activity : on appelle dans l'ordre `onCreate()`, `onStart()` et `onResume()`. L'Activity devient en cours d'exécution.

Une autre Activity vient au premier plan : `onPause()` est appelé.

Si l'utilisateur y retourne, `onResume()` est appelé, qui remet l'Activity en cours d'exécution.

Sinon, `onStop()` est appelé. Si l'utilisateur y retourne, `onRestart()` est appelé, qui appelle `onStart()`.

Si l'Activity est finie ou détruite par le système, c'est `onDestroy()` qui est appelé.

Source : https://developer.android.com/reference/android/app/Activity#activity-lifecycle

