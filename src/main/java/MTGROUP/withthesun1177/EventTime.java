package MTGROUP.withthesun1177;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;a
//import org.jsoup.select.Elements;
public class EventTime{
	public static void main(String[] args) throws IOException {
		//get event time
		Document document = Jsoup.connect("https://www.dailyfx.com/calendar").get();
		org.jsoup.nodes.Element table = document.getElementById("daily-cal5");
		System.out.println(table.text());
		//detail extraction by regular expression
		Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}");
		Matcher m = p.matcher(table.text());
		//insert the data into Mysql
		insertMysql intoMysql = new insertMysql();
		while (m.find()) {
			System.out.println("same to : " + m.group());
			intoMysql.insertData(m.group());
		}
	}

}