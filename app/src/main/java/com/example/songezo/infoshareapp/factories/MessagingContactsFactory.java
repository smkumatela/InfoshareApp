package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Caregiver;
import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.domain.Organisation;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class MessagingContactsFactory {

    MessagingContacts messagingContacts;

    private static MessagingContactsFactory messagingContactsFactory = null;

    public MessagingContactsFactory() {
    }

    public static MessagingContactsFactory getMessagingContactsFactory(){
        if (messagingContactsFactory == null){
            messagingContactsFactory = new MessagingContactsFactory();
        }
        return messagingContactsFactory;
    }

    public static MessagingContacts createMessagingContactsFactory(String caregiver, String organisation, Long id){
        MessagingContacts messagingContacts1 = new MessagingContacts.Builder()
                .caregiver(caregiver)
                .organisation(organisation)
                .id(id)
                .build();
        return messagingContacts1;
    }

    @Override
    public String toString() {
        return "MessagingContactsFactory{" +
                "messagingContacts=" + messagingContacts +
                '}';
    }

}
