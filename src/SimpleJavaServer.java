import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SimpleJavaServer {
//10 + 20
    public static void main(String[] args) 	{
        try {
            String [] expressao=null;
            ServerSocket s = new ServerSocket(9999);
            String str;
            while (true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do {
                    byte[] line = new byte[100];
                    i.read(line);//Pega linha enviada pelo cliente
                    str = new String(line).trim();
                    System.out.println(str);
                    expressao=str.split(" ");
                    System.out.println(Arrays.toString(Arrays.stream(expressao).toArray()));
                    System.out.println(expressao[1]);
                    float result = 0.0F;
                    switch (expressao[1].charAt(0)){

                //        result=new Calculadora(Float.parseFloat(expressao[0]), Float.parseFloat(expressao[2])).soma();

                        case '+':
                            result = new Calculadora(Float.parseFloat(expressao[0]), Float.parseFloat(expressao[2])).soma();
                            break;
                        case '-':
                            result = new Calculadora(Float.parseFloat(expressao[0]), Float.parseFloat(expressao[2])).subtracao();
                        case '*':
                            result = new Calculadora(Float.parseFloat(expressao[0]), Float.parseFloat(expressao[2])).multiplicacao();
                        case '/':
                            if (Float.parseFloat(expressao[2])==0) {
                                System.out.println("ERRO\nNAO EH POSSÍVEL DIVIDIR POR 0");
                            }else {
                                result = new Calculadora(Float.parseFloat(expressao[0]), Float.parseFloat(expressao[2])).divisao();
                            }

                        default:

                    }
                    System.out.println(result);
                    o.write(Float.toString(result).getBytes());//Envia resultado para o cliente

                } while ( !str.trim().equals("bye") );
                c.close();
            }
        }
        catch (Exception err){
            System.err.println(err);
        }
    }

}
