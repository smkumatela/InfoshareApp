package com.example.songezo.infoshareapp.services.messagingcontacts;

import com.example.songezo.infoshareapp.domain.MessagingContacts;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface MessagingContactsService {

    MessagingContacts getMessagingContactsByID(Long id);


    MessagingContacts saveMainMenu(MessagingContacts entity);

    Set<MessagingContacts> findAll();
}
