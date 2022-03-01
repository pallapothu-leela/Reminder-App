package dsProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SMS {
	
	static void sendSms(String message,String number)
	{
		try
		{
		
		String apiKey="mBA09LRZY7TvIfXbF6nwqxjD1apt3UKCQyJ5s2hPelcd8ioNGVDLB0hynTsb29MzjmJZ8AxSY6dP5Foa";
		String sendId="FSTSMS";
		//important step...
		message=URLEncoder.encode(message, "UTF-8");
		String language="english";
		
		String route="p";
		
		
		String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request using java...
		
		URL url=new URL(myUrl);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait..............");
		
		int code=con.getResponseCode();
		
		System.out.println("Response code : "+code);
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
