import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import com.fourteenfourhundredstudios.phylum.html.HTMLParser;

public class fetcher {
	
	public String getHtml(String urlName, int sourceCount){
		String totalHtml = "";
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    //int sourceCount = 0;
	    PrintWriter writer = null;

	    try {
	        url = new URL(urlName);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) {
	            //System.out.println(line);
	        	totalHtml = totalHtml+"\n"+line;
	        }
	        HTMLParser parser = new HTMLParser(totalHtml);
	       	writer = new PrintWriter(sourceCount+".txt", "UTF-8");
	       	writer.println(parser.getText());
	       	//writer.println(totalHtml);
	       	writer.flush();
        	writer.close();
        	System.out.println(url+" just got saved");
        	System.out.println(sourceCount);
	        
	        //just exception handleing down there
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {

	    }
	    return totalHtml;
	}
}
