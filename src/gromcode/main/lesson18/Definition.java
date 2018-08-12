package gromcode.main.lesson18;

public class Definition {
    public static void main(String[] userEmails) {


        for(String email : userEmails){
            //обработка ошибок
            try{
                //send email
                System.out.println("Email "+email+" was sent");
                //
                //
                //
            } catch (Exception e) {
                //how should i handle exception
                System.err.println("Email "+email+" was not sent");
            }
            finally {
                // update status
            }
        }
        //1
        //2
        //3
    }
}
