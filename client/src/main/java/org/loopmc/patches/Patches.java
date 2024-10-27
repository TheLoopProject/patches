package org.loopmc.patches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class Patches implements ModInitializer {

	public static final String MOD_ID = "patches";

	public static final FalseLogger LOGGER = new FalseLogger(MOD_ID);

	@Override
	public void init() {
		LOGGER.log("Loop Patches loading");
	}
}
