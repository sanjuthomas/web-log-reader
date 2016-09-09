package org.sanju.log.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Sanju Thomas
 */

public class WebLogReader {

	public static void main(final String[] args) throws URISyntaxException, IOException, InterruptedException {

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin", "admin".toCharArray());
			}
		});

		String uri = null;
		if (args.length == 1) {
			uri = args[0];
		} else {
			System.out.println("Usage : org.sanju.log.streamer.WebLogReader <<URL>>");
			System.exit(0);
		}

		final URL uriObject = new URL(uri);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(uriObject.openStream()));
			while (true) {
				final String line = reader.readLine();
				if (null == line) {
					Thread.sleep(1000);
				} else {
					System.out.println(line);
				}
			}
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
	}
}
