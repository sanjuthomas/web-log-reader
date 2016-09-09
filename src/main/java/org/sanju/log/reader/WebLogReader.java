package org.sanju.log.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Sanju Thomas
 */

public class WebLogReader{

	public static void main(final String[] args) throws URISyntaxException, IOException, InterruptedException {

		String uri = null;
		if(args.length == 1){
			uri = args[0];
		}else{
			System.out.println("Usage : org.sanju.log.streamer.WebLogReader <<URI>>");
			System.exit(0);
		}

		final URI uriObject = new URI(uri);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(uriObject)));
			while(true){
				final String line = reader.readLine();
				if(null == line){
					Thread.sleep(1000);
				}
				System.out.println(line);
			}
		} finally{
			if(null != reader) {
				reader.close();
			}
		}
	}
}

