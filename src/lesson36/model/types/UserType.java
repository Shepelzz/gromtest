package lesson36.model.types;

public enum UserType {
    ADMIN, USER;

    public static UserType getTypeByName(String inputType){
        for(UserType userType : UserType.values())
            if(inputType.trim().equals(userType.toString()))
                return userType;
        return null;
    }
}
