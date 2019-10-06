/*
 * File     : Users.java
 * Project  : Labo01 SYM
 * Author   : Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date     : 6 octobre 2019
 *
 * Ce code contient la classe Users, qui représente les différents couples login-mdp acceptés
 * à l'authentification de l'application.
 *
 */

package ch.heigvd.sym.template;

import java.util.HashMap;

class Users {

    private static HashMap<String, String> users;

    static {
        users = new HashMap<String, String>();

        users.put("toto@tutu.com", "tata");
        users.put("gino@strada.ch", "sert");
        users.put("ad@set.sd", "cappping");
        users.put("Asdtra@dsaaa.ch", "Washington_DC");
    }


    static HashMap<String, String> getUsers(){
        return users;
    }

}