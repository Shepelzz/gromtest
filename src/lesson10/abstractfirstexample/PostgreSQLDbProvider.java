package lesson10.abstractfirstexample;

public class PostgreSQLDbProvider extends DbProvider {

    public PostgreSQLDbProvider(String dbHost) {
        super(dbHost);
    }

    @Override
    void connectToDb(){
        //
    }

    @Override
    void disconnectFromDb(){
        //
    }
}
