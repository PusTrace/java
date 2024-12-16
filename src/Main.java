import java.io.*;

public class Main {
    public static void main(String[] args) {
        String encryptedFilePath = args[0];
        String decryptedFilePath = args[1];
        String resultFilePath = args[2];
        byte decryptionKey = Byte.parseByte(args[3]);

        //dop
        String reEncryptedFilePath = args[4];
        byte reEncryptionKey = Byte.parseByte(args[5]);

        try {
            decryptFile(encryptedFilePath, decryptedFilePath, decryptionKey);
            processDecryptedFile(decryptedFilePath, resultFilePath);

            //dop
            encryptFile(resultFilePath, reEncryptedFilePath, reEncryptionKey);

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    private static void decryptFile(String inputFile, String outputFile, byte key) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ key);
            }
        }
    }

    private static void processDecryptedFile(String inputFile, String outputFile) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile))) {

            long longValue = dis.readLong();
            long longResult = longValue * 119;
            dos.writeLong(longResult);

            byte byteValue = dis.readByte();
            byte byteResult = (byte) (byteValue - 119);
            dos.writeByte(byteResult);

            int intValue = dis.readInt();
            int intResult = intValue + 119;
            dos.writeInt(intResult);
        }
    }
   private static void encryptFile(String inputFile, String outputFile, byte key) throws IOException {
    try (FileInputStream fis = new FileInputStream(inputFile);
         FileOutputStream fos = new FileOutputStream(outputFile)) {

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data ^ key);
        }
    }
}
}

