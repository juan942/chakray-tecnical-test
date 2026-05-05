package com.example.demo.helper;

import com.example.demo.model.User;

import java.util.Comparator;
import java.util.List;

public class UserCriteriaHelper {
    private static final int CRITERIA_PARTS = 3;
    private static final String CRITERIA_SEPARATOR = " ";

    public static List<User> applyFilter(List<User> users, String filter) {
        String[] criteria = filter.split(CRITERIA_SEPARATOR, CRITERIA_PARTS);

        if (criteria.length != CRITERIA_PARTS)
            return users;

        return users.stream()
                .filter(user -> matchFilter(user, criteria))
                .toList();
    }

    public static Comparator<User> getComparator(String sortedBy) {
        return switch (sortedBy) {
            case "id" -> Comparator.comparing(user -> user.getId().toString());
            case "email" -> Comparator.comparing(User::getEmail);
            case "phone" -> Comparator.comparing(User::getPhone);
            case "tax_id" -> Comparator.comparing(User::getTaxId);
            case "created_at" -> Comparator.comparing(User::getCreatedAt);
            default -> Comparator.comparing(User::getName);
        };
    }

    private static boolean matchFilter(User user, String[] criteria) {
        String fieldName = criteria[0];
        String operator = criteria[1];
        String match = criteria[2];
        String fieldValue = getFieldValue(user, fieldName);

        if (fieldValue == null)
            return false;

        return switch (operator) {
            case "co" -> fieldValue.contains(match);
            case "eq" -> fieldValue.equalsIgnoreCase(match);
            case "sw" -> fieldValue.startsWith(match);
            case "ew" -> fieldValue.endsWith(match);
            default -> false;
        };
    }

    private static String getFieldValue(User user, String field) {
        return switch (field) {
            case "id" -> user.getId().toString();
            case "email" -> user.getEmail();
            case "name" -> user.getName();
            case "phone" -> user.getPhone();
            case "tax_id" -> user.getTaxId();
            case "created_at" -> user.getCreatedAt().toString();
            default -> null;
        };
    }
}
