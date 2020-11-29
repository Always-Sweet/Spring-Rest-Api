package com.demo;

import com.demo.model.Contact;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 数据存储（模拟数据持久化）
 */
public class DataCaches {

    public static List<Contact> contacts = new ArrayList<>();

    public static List<Contact> findByNameOrPhoneNumber(Contact search) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<Contact> result = new HashSet<>();
        String[] searchParams = new String[]{"contactName", "telephoneNumber"};
        Class<?> contactClass = search.getClass();
        for (String param : searchParams) {
            String methodSuffix = param.substring(0, 1).toUpperCase() + param.substring(1);
            Method getMethod = contactClass.getMethod("get" + methodSuffix);
            if (StringUtils.isNotEmpty((String) getMethod.invoke(search))) {
                for (int i = 0; i < contacts.size(); i++) {
                    Contact one = contacts.get(i);
                    if (String.valueOf(getMethod.invoke(one)).equals(getMethod.invoke(search))) {
                        result.add(one);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<Contact> findAll() {
        return contacts;
    }

    public static Contact get(String id) {
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst().get();
    }

    public static void save(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        contacts.add(contact);
    }

    public static boolean modify(Contact object) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(object.getId())) {
                contacts.set(i, object);
                return true;
            }
        }
        return false;
    }

    public static boolean remove(String id) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

}
