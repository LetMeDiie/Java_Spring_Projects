package kz.demo.spring_practic1.model;

public enum Status {
    OFFLINE, ONLINE;

    @Override
    public String toString() {
        switch (this) {
            case OFFLINE:
                return "User is offline";
            case ONLINE:
                return "User is online";
            default:
                return super.toString();
        }
    }
}
