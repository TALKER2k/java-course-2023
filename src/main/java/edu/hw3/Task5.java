package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Task5 {
    private Task5() {}

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public static List<String> parseContacts(List<String> contacts, String compareString) {
        if (contacts == null) {
            return new ArrayList<>();
        }
        return contacts.stream().sorted((o1, o2) -> {
            List<String> split1 = List.of(o1.split(" "));
            List<String> split2 = List.of(o2.split(" "));
            if (ASC.equals(compareString)) {
                return split1.get(split1.size() - 1).compareTo(split2.get(split2.size() - 1));
            } else if (DESC.equals(compareString)) {
                return split2.get(split2.size() - 1).compareTo(split1.get(split1.size() - 1));
            }
            return 0;
        }).collect(Collectors.toList());
    }
}
