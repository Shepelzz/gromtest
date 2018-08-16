package lesson36.model.types;

public enum UserType {
    ADMIN, USER;

    public static UserType getTypeByName(String inputType) throws Exception{
        for(UserType userType : UserType.values())
            if(inputType.trim().equals(userType.toString()))
                return userType;
        throw new Exception("UserType "+inputType+" is not valid");
    }
}
