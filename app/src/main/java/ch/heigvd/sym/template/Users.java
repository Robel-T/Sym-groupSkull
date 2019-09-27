package ch.heigvd.sym.template;

import java.util.HashMap;

class Users {

    private static HashMap<String, String> users;

    {
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