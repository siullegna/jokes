package com.hap.jokes_provider;

import java.util.Locale;

/**
 * Created by luis on 3/10/18.
 */

public class Joke {
    private final String part1;
    private final String part2;

    Joke(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    Joke(String part1) {
        this(part1, null);
    }

    @Override
    public String toString() {
        if (isNotEmpty(part1) && isNotEmpty(part2)) {
            return String.format(Locale.US, "%s\n%s", part1, part2);
        } else if (isNotEmpty(part1)) {
            return part1;
        } else if (isNotEmpty(part2)) {
            return part2;
        } else {
            return "Age is a relative thing.\n" +
                    "All my relatives keep reminding me how old I am.";
        }
    }

    private boolean isNotEmpty(final String text) {
        return text != null && text.length() > 0;
    }
}
