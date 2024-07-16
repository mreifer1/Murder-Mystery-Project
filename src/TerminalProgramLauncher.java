import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TerminalProgramLauncher {
    public static void main(String[] args) {
        
        final String JAR_FILE = "./GameData.jar";

        String os = System.getProperty("os.name").toLowerCase();

        try {
            String[] command;
            if (os.contains("win")) {
                command = new String[] { "cmd.exe", "/c", "start", "java", "-jar", JAR_FILE };
            } else if (os.contains("mac")) {
                command = new String[] { "/bin/bash", "-c", "java -jar " + JAR_FILE };
            } else {
                System.out.println("Unsupported operating system.");
                return;
            }
            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                System.out.println(inputLine);
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
