package Algorithm;

import Algorithm.common.IEncryptDecrypt;

public class Unicoder implements IEncryptDecrypt {
    @Override
    public String encrypt(String message, int index) {
        char[] messageArray = message.toCharArray();
        int messageSize = message.length();

        String messageEncrypted = "";

        for (int i = 0; i < messageSize; i++) {
            int ascii_index = (int) (messageArray[i] + index);

            messageEncrypted += (char) (ascii_index);
        }

        return messageEncrypted;
    }

    @Override
    public String decrypt(String message, int index) {
        char[] messageArray = message.toCharArray();
        int messageSize = message.length();

        String messageEncrypted = "";

        for (int i = 0; i < messageSize; i++) {
            int ascii_index = (int) (messageArray[i] - index);

            messageEncrypted += (char) (ascii_index);
        }

        return messageEncrypted;
    }
}
