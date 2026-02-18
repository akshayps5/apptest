package etopupapp;

	import com.jcraft.jsch.*;
	public class RemoteAliasExecutor {
		private static final String HOST = "10.0.5.49";
	    private static final String USER = "etopup";
	    private static final String PASSWORD = "etopup1";
	    private static final int PORT = 22;

	    public static void execute(String command) {

	        Session session = null;
	        ChannelExec channel = null;

	        try {
	            JSch jsch = new JSch();
	            session = jsch.getSession(USER, HOST, PORT);
	            session.setPassword(PASSWORD);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.connect(10000);

	            channel = (ChannelExec) session.openChannel("exec");

	            // Important: load alias using interactive shell
	            String fullCommand = "bash -ic \"" + command + "\"";

	            channel.setCommand(fullCommand);
	            channel.connect();

	            // wait until command finishes
	            while (!channel.isClosed()) {
	                Thread.sleep(100);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (channel != null) channel.disconnect();
	            if (session != null) session.disconnect();
	        }
	    }
	

}
