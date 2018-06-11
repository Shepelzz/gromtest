package lesson10.abstractfirstexample;

public class OracleDbProvider extends DbProvider{

    public OracleDbProvider(String dbHost) {
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
