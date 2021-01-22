package andkonst88.providers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import andkonst88.entity.Contact;

@Provider
@Consumes("text/csv")
public class CsvToContactUnmarshaller implements MessageBodyReader<Contact> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.isAssignableFrom(Contact.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Contact readFrom(Class<Contact> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(entityStream));
		String csv = in.readLine();
		String[] args = csv.split(",");
		
		Contact c = new Contact();
		try {
			c.setId(new Integer(args[0]));
		} catch (NumberFormatException e) {
		}
		c.setName(args[1]);
		c.setGender(args[2]);
		c.setEmail(args[3]);
		c.setPhone(args[4]);
		c.setCity(args[5]);
		c.setCountry(args[6]);
		
		return c;
	}

}









