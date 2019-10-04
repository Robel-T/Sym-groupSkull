# SYM - Labo 1 : Introduction à Android

Auteurs : Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot

Date : 6 octobre 2019

## Réponses aux questions

### Question 1 :

Pour obtenir une application multi-langues, il suffit de créer un dossier `values` pour chaque langue supportée avec leur suffixe (`values-fr`, `values-de`, `values-it` et `values-es`). Le dossier `values` est sensé contenir les valeurs de la langue par défaut (anglais dans notre cas).

Si une traduction est manquante, un warning `Missing Translation` à la compilation est lancé.

### Question 2 :

Dans un premier temps, on télécharge l'icône souhaité en format `.svg`. On peut l'inclure dans notre projet en créant un `Vector Asset` dans le dossier `res`. Cela va générer un fichier `.xml` contenant notre icône dans un dossier `drawable`.

On peut ensuite l'inclure dans notre code.

Source : https://developer.android.com/studio/write/vector-asset-studio.html#running ("Importing an SVD or PSD file")

### Question 3 : 

Quand on presse le bouton Back, l'application n'est plus visible, donc `onStop()` est appelé. Cette méthode n'est pas implémentée dans notre application, donc quand on la rouvre, il faut se re-loguer à nouveau car l'Activity de départ est relancée.

Il faudrait que l'état du login soit sauvegardé dans un état créé dans la méthode `onStart()`.

Dans notre application, nous avons tout implémenté dans des méthodes `onCreate()`. Ce n'est pas une bonne méthode du tout, il faudrait essayer d'implémenter chaque fonction définie dans la question 8 (voir ci-dessous).

### Question 4 : TODO

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

### Question 6 : TODO

### Question 7 : TODO

### Question 8 : Pas fini (faire le code)

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
