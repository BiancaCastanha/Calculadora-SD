import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class SimpleJavaClient {

    public static void main(String[] args) 	{
        try {
            Socket s = new Socket("127.0.0.1", 9999);
            InputStream i = s.getInputStream();
            OutputStream o = s.getOutputStream();
            String str;
            do {
                byte[] line = new byte[100];
                System.in.read(line);
                o.write(line); //mandando para o servidor
                Arrays.fill(line, (byte)0);
                i.read(line); //recebendo do servidor
                str = new String(line).trim();
                System.out.println(str.trim());
            } while ( !str.trim().equals("bye") );
            s.close();
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }

}
