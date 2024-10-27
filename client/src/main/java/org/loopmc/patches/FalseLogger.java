package org.loopmc.patches;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FalseLogger {

	private String name;

	public FalseLogger(String name) {
		this.name = name;
	}

	private String getCurrentTimeStamp() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public void log(String text) {
		System.out.println("["+getCurrentTimeStamp()+"] ("+name+") "+text);
	}
}
