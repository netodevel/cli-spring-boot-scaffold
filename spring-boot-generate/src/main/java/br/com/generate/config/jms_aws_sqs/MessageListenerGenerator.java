//package br.com.generate.config.jms_aws_sqs;
//
//import br.com.generate.helpers.FileHelper;
//
//import java.io.IOException;
//
//public class MessageListenerGenerator extends FileHelper {
//
//    @Override
//    public String getLayer() {
//        return "consumer";
//    }
//
//    @Override
//    public String operationGenerate(String javaStrings, String nameClass, String parameters) {
//        return javaStrings.replace("${package}", getPackage() + ".consumer");
//    }
//
//    public static void main(String[] args) throws IOException {
//        new MessageListenerGenerator().generateConfig("MessageListener", "jms_aws_sqs/template-message-listener.txt");
//    }
//
//}
