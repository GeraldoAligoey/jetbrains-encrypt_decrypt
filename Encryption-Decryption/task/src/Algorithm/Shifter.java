package Algorithm;

import Algorithm.common.IEncryptDecrypt;

public class Shifter implements IEncryptDecrypt {
    final int LL = 96;
    final int UL = 122;
    final int ALL = 64;
    final int AUL = 90;

    @Override
    public String encrypt(String message, int index) {
        char[] messageArray = message.toCharArray();
        int messageSize = message.length();

        String messageEncrypted = "";

        for (int i = 0; i < messageSize; i++) {
            int ascii_index = (int) (messageArray[i]);

            if (ascii_index > ALL && ascii_index <= AUL) {
                ascii_index += index;

                if (ascii_index > AUL) {
                    ascii_index = ascii_index - AUL + ALL;
                }
            } else if (ascii_index > LL && ascii_index <= UL){
                ascii_index += index;

                if (ascii_index > UL) {
                    ascii_index = ascii_index - UL + LL;
                }
            }

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
            int ascii_index = (int) (messageArray[i]);

            if (ascii_index > ALL && ascii_index <= AUL) {
                ascii_index -= index;

                if (ascii_index <= ALL) {
                    ascii_index = AUL - (ALL - ascii_index);
                }
            } else if (ascii_index > LL && ascii_index <= UL){
                ascii_index -= index;

                if (ascii_index <= LL) {
                    ascii_index = UL - (LL - ascii_index);
                }
            }

            messageEncrypted += (char) (ascii_index);
        }

        return messageEncrypted;
    }
}
