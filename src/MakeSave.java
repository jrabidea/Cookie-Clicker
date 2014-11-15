
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.io.IOException;





public class MakeSave{
	public static void main(String[] args){

		 File saveGame = new File("CookieClickerSave.txt");

		 try{
		 	FileUtils.write(saveGame, " ");
		 }catch(IOException e){
		 	e.printStackTrace();
		 }

	}
}