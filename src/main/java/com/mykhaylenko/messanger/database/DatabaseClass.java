package com.mykhaylenko.messanger.database;

import com.mykhaylenko.messanger.model.Message;
import com.mykhaylenko.messanger.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.mykhaylenko on 7/27/2015.
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();

    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
