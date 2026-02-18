package etopupapp;


	 
	import com.jcraft.jsch.ChannelExec;
	import com.jcraft.jsch.JSch;
	import com.jcraft.jsch.Session;
	 
	import java.io.BufferedReader;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	 
	public class OtpReader {
	 
	    public static void main(String[] args) {
	        String otp = getOTPFromServer("2482565896");
	        System.out.println("Fetched OTP is : " + otp);
	    }
	 
	    public static String getOTPFromServer(String msisdn) {
	 
	        String host = "10.0.6.79";
	        String user = "etopupApp";
	        String password = "etopupApp";
	 
	        String otp = null;
	 
	        try {
	            JSch jsch = new JSch();
	            Session session = jsch.getSession(user, host, 22);
	            session.setPassword(password);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.connect();
	 
	            ChannelExec channel = (ChannelExec) session.openChannel("exec");
	 
	            // ✅ BEST & RELIABLE COMMAND
	            String command =
	                "grep 'Generated OTP for " + msisdn + "' " +
	                "/opt/etopupApp/nodeJsApiServer/logs/etopup.log | tail -1";
	 
	            channel.setCommand(command);
	 
	            InputStream input = channel.getInputStream();
	            channel.connect();
	 
	            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	            String line;
	 
	            // ✅ CORRECT REGEX (OTP AFTER COLON)
	            Pattern otpPattern = Pattern.compile(":\\s*(\\d{6})");
	 
	            while ((line = reader.readLine()) != null) {
	                Matcher matcher = otpPattern.matcher(line);
	                if (matcher.find()) {
	                    otp = matcher.group(1);
	                }
	            }
	 
	            channel.disconnect();
	            session.disconnect();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        return otp;
	    }
	}
