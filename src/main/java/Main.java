import Utilities.Excel_IO;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) throws Exception{

        Excel_IO excelagent = new Excel_IO();
        //excelagent.create_exceldocument("inputdocument");
        ArrayList<ArrayList<String>> questions = excelagent.open_exceldocument("Questions");

    }
}
