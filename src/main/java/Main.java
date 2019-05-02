import Utilities.CreateWorkBook;
import Utilities.OpenWorkBook;

public class Main {

    public static void main(String args[]) throws Exception{
        CreateWorkBook createagent = new CreateWorkBook();
        OpenWorkBook openagent = new OpenWorkBook();


        createagent.createworkbook("inputdocument");

        openagent.openworkbook("inputdocument");

    }
}
