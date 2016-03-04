package party.invitation;

public enum Gender {
    MALE("Mr "),
    FEMALE("Ms ");
    private final String prefix;
    Gender(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix.toString();
    }
}
