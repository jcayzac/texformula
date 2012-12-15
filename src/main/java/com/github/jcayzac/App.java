package com.github.jcayzac;
import uk.ac.ed.ph.snuggletex.SnuggleSession;
import uk.ac.ed.ph.snuggletex.SnuggleEngine;
import uk.ac.ed.ph.snuggletex.SnuggleInput;
import uk.ac.ed.ph.snuggletex.XMLStringOutputOptions;
import uk.ac.ed.ph.snuggletex.SerializationMethod;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class App 
{
	public static void main( String[] args )
	{
		SnuggleSession session = (new SnuggleEngine()).createSession();
		String input = null;
		try {
			input = IOUtils.toString(System.in, "UTF-8");
			session.parseInput(new SnuggleInput(input));
		} catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		}

		XMLStringOutputOptions options = new XMLStringOutputOptions();
		options.setSerializationMethod(SerializationMethod.XML);
		options.setIncludingXMLDeclaration(true);
		options.setIndenting(true);
		options.setEncoding("UTF-8");
		options.setAddingMathSourceAnnotations(true);
		options.setUsingNamedEntities(false);
		System.out.println(session.buildXMLString(options));
	}
}
