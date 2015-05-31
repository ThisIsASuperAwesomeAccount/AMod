package com.aa.mod.updateChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraftforge.common.MinecraftForge;

public class ThreadVersionChecker extends Thread {

	public ThreadVersionChecker() {
		setName("Arcane Arteries Checker Thread");
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/jordsta95/ArcaneArteries/master/aaversion.txt");
			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			VersionChecker.onlineVersion = r.readLine();
			r.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		VersionChecker.doneChecking = true;
	}
}