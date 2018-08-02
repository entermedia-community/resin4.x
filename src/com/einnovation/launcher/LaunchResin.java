package com.einnovation.launcher;

import java.io.File;

/**
 * @author jlouis
 * @author Matt Avery
 */
public class LaunchResin
{
	public static void main(String[] args)
	{

		if (args.length == 0)
		{
			args = new String[] { "conf/resin.conf" };
		}
		File resinConf = new File(args[0]);
		if (!resinConf.exists())
		{
			System.out.println(
				"Usage:\n\n LaunchResin <relative-path-from-project-root-to-resin.conf>\n"
					+ "Defauts to \"resin.conf\"");
			System.exit(0);
		}
		System.out.println("Using Resin config file: " + resinConf.getAbsolutePath());
		try
		{
			String[] resinArgs = new String[] { "-conf", resinConf.getAbsolutePath()};
			ResinServer.main(resinArgs);
		}
		catch (Exception e)
		{
			System.err.println("LaunchResin.main: " + e.getMessage());
		}
	}
}