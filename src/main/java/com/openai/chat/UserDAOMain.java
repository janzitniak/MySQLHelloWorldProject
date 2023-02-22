package com.openai.chat;

import com.openai.chat.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOMain {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAOobjekt = new UserDAO();

/*        // vytvarame objekt User
        User user = new User();
        // ktory naplnime udajmi ako je meno (Name) a email (Email)
        user.setName("Ján Žitniak");
        user.setEmail("jan.zitniak@gmail.com");
        // a takehoto naplneneho pouzivatela odosleme metode create, ktora sa nachadza v triede userDAO
        userDAOobjekt.create(user);*/


/*        // vyberame udaje pouzivatel s ID=2
        User user2 = userDAOobjekt.read(2);
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getEmail());

        // aktualizacia udajov pouzivatelia s id=1
        User user3 = new User();
        user3.setName("Ondrej Široký");
        user3.setEmail("ondrej.siroky@gmail.com");
        user3.setId(1);
        userDAOobjekt.update(user3);

        // vymazanie zaznamu z databazy, ktoreho id=1
        userDAOobjekt.delete(1);*/

        //ArrayList<User> users = new ArrayList<User>(); // prazdny ArrayList
        ArrayList<User> users = userDAOobjekt.readAll(); // ziskame naplneny ArrayList

        for (User vystup:users) {
            System.out.println("id: " + vystup.getId());
            System.out.println("meno: " + vystup.getName());
            System.out.println("email: " + vystup.getEmail());
        }

    }
}
